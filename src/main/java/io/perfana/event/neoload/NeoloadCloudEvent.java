/*
 * Copyright (C) 2024 Peter Paul Bakker, Perfana
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.perfana.event.neoload;

import io.perfana.event.neoload.influx.InfluxWriterConfig;
import io.perfana.event.neoload.influx.InfluxWriterNative;
import io.perfana.event.neoload.influx.NeoloadInfluxWriter;
import io.perfana.event.neoload.model.*;
import io.perfana.event.neoload.model.GetTestExecutionResponse.StepEnum;
import io.perfana.eventscheduler.api.EventAdapter;
import io.perfana.eventscheduler.api.EventLogger;
import io.perfana.eventscheduler.api.config.TestContext;
import io.perfana.eventscheduler.api.message.EventMessage;
import io.perfana.eventscheduler.api.message.EventMessageBus;

import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicReference;

public class NeoloadCloudEvent extends EventAdapter<NeoloadEventContext> {

    private static final String NEOLOAD_BASE_URL = "https://neoload-v2.saas.neotys.com/v4/";
    public static final String PERFANA_NEOLOAD_PREFIX = "perfana-neoload-";
    public static final String PLUGIN_NAME = NeoloadCloudEvent.class.getSimpleName();
    public static final String TRACING_HEADER_NAME = "perfanaTestRunId";

    private final AtomicReference<NeoloadClient> client = new AtomicReference<>();
    private final AtomicReference<NeoloadInfluxWriter> influxWriter = new AtomicReference<>();
    private final AtomicReference<Instant> testStartTime = new AtomicReference<>();

    private volatile String testExecutionId;
    private volatile String workspaceId;
    private volatile boolean testIsRunning = true;

    public NeoloadCloudEvent(NeoloadEventContext context, TestContext testContext, EventMessageBus messageBus, EventLogger logger) {
        super(context, testContext, messageBus, logger);
    }

    @Override
    public void beforeTest() {
        logger.info("before test [" + testContext.getTestRunId() + "]");

        String accountToken = eventContext.getAccountToken();

        boolean useProxy = eventContext.isUseProxy();

        client.set(new NeoloadClient(NEOLOAD_BASE_URL, accountToken, logger, useProxy, eventContext.getProxyPort()));

        InfluxWriterConfig config = eventContext.getInfluxWriterConfig();
        InfluxWriterNative writer = new InfluxWriterNative(config, logger);
        influxWriter.set(new NeoloadInfluxWriter(writer));

        TestExecutionInput input = new TestExecutionInput();
        input.setTestId(eventContext.getNeoloadTestId());
        //input.setName(testContext.getProductName());
        //input.setDuration(Duration.ofMinutes(90).toString());
        input.setDescription("Run from test-events-neoload Perfana plugin");
        input.setWebVu(50);

        TestExecution testExecution = client.get().startRun(input);

        this.testExecutionId = testExecution.getId();
        this.workspaceId = testExecution.getWorkspaceId();

        EventMessage message = EventMessage.builder()
                .pluginName(pluginName())
                .variable(PERFANA_NEOLOAD_PREFIX + "testExecutionId", testExecutionId)
                .variable(PERFANA_NEOLOAD_PREFIX + "testId", eventContext.getNeoloadTestId())
                .variable(PERFANA_NEOLOAD_PREFIX + "workspaceId", workspaceId)
                .build();
        eventMessageBus.send(message);

        logger.info(String.format("started polling if running for workspaceId: %s testId: %s at %s with testExecutionId: %s",
                workspaceId, testExecutionId, Instant.now(), this.testExecutionId));

        Runnable pollForTestRunning = createPollForTestRunningThread();

        Executor executor1 = Executors.newSingleThreadExecutor(r -> new Thread(r, "NeoloadPollForTestRunning"));
        executor1.execute(pollForTestRunning);

        Runnable resultsFromNeoloadToInflux = createResultsFromNeoloadToInfluxThread();
        Executor executor2 = Executors.newSingleThreadExecutor(r -> new Thread(r, "ResultsFromNeoloadToInflux"));
        executor2.execute(resultsFromNeoloadToInflux);

        logger.info(String.format("started run at %s with test execution id: %s. Waiting for status TEST_STARTED.",
            Instant.now(), testExecution.getId()));
    }

    private Runnable createResultsFromNeoloadToInfluxThread() {
        return () -> {
            String nextRequestToken = null;
            Point lastPoint = null;
            Map<String, String> tags = Map.of(
                    "application", testContext.getProductName(),
                    "testEnvironment", testContext.getTestEnvironment(),
                    "workload", testContext.getWorkload());

            logger.info("Start thread to send results to Influx");

            while (testIsRunning) {
                try {
                    if (client.get() != null
                            && testExecutionId != null
                            && testStartTime.get() != null) {
                        ResultTimeseries result = client.get().resultsTimeseries(testExecutionId, nextRequestToken);
                        nextRequestToken = result.getNextRequestToken();

                        List<Point> points = result.getPoints();

                        if (!points.isEmpty()) {
                            // not the first
                            if (lastPoint != null) {
                                int lastPointIndex = points.lastIndexOf(lastPoint);
                                points = points.subList(lastPointIndex, points.size() - 1);
                            }
                            if (!points.isEmpty()) {
                                lastPoint = points.get(points.size() - 1);
                                logger.info("Sending " + points.size() + " points to InfluxDB");
                                influxWriter.get().uploadTimeSeriesToInfluxDB(
                                        points,
                                        testStartTime.get(),
                                        tags);
                            }
                        }
                    } else {
                        logger.info("No test execution id available, not fetching results to send to InfluxDB");
                    }
                } catch (Exception e) {
                    logger.warn("Failed to send data to InfluxDB:" + e.getMessage());
                }
                try {
                    Thread.sleep(30_000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            logger.info("End thread to send results to Influx");
        };
    }

    private Runnable createPollForTestRunningThread() {
        return () -> {

            long sleepInMillis = eventContext.getPollingPeriod().toMillis();
            long maxPollingTimestamp = System.currentTimeMillis() + eventContext.getPollingMaxDuration().toMillis();

            boolean continuePolling = true;
            boolean testRunStarted = false;

            while (continuePolling) {

                // now start polling if load test is running, then send Go! message
                try {
                    GetTestExecutionResponse execution = client.get().getTestExecution(testExecutionId);

                    StepEnum step = execution.getStep();

                    logger.info(String.format("Status for test execution id %s is now: %s",
                            testExecutionId, step == null ? "<no status>" : step.name()));
                    if (step == StepEnum.CANCELLED
                            || step == StepEnum.FAILED
                            || step == StepEnum.FAILED_TO_PREPARE_CONTROLLER
                            || step == StepEnum.FAILED_TO_PREPARE_LGS) {
                        continuePolling = false;
                        testRunStarted = false;
                    }
                    if (step == StepEnum.STARTED_TEST) {
                        continuePolling = false;
                        testRunStarted = true;
                        // TODO: is there a more precise start date to set?
                        testStartTime.set(Instant.now());
                    }
                } catch (NeoloadClientException e) {
                    logger.warn("Cannot call test runs active, will retry: " + e.getMessage());
                }

                try {
                    Thread.sleep(sleepInMillis);
                } catch (InterruptedException e) {
                    logger.warn("Interrupt received, will stop polling now.");
                    continuePolling = false;
                    EventMessage stopMessage = EventMessage.builder()
                        .pluginName(pluginName())
                        .message("Stop!")
                        .build();
                    eventMessageBus.send(stopMessage);
                    Thread.currentThread().interrupt();
                }

                if (System.currentTimeMillis() > maxPollingTimestamp) {
                    logger.warn("Max polling period reached (" + eventContext.getPollingMaxDuration() + " seconds), will stop polling now.");
                    continuePolling = false;
                    EventMessage stopMessage = EventMessage.builder()
                        .pluginName(pluginName())
                        .message("Stop!")
                        .build();
                    eventMessageBus.send(stopMessage);
                }
            }

            if (testRunStarted) {
                EventMessage goMessage = EventMessage.builder()
                        .pluginName(pluginName())
                        .message("Go!")
                        .build();
                eventMessageBus.send(goMessage);
            }
            else {
                EventMessage stopMessage = EventMessage.builder()
                        .pluginName(pluginName())
                        .message("Stop!")
                        .build();
                eventMessageBus.send(stopMessage);
            }

        };
    }

    private void sendTracingHeader(String projectId, String loadTestId) {
        String testRunId = testContext.getTestRunId();
        logger.warn("send tracing header IS NOT IMPLEMENTED '" + TRACING_HEADER_NAME + ": " + testRunId + "'");

    }

    private String pluginName() {
        return PLUGIN_NAME + "-" + eventContext.getName();
    }

    @Override
    public void abortTest() {
        logger.info("abort test [" + testContext.getTestRunId() + "] with runId [" + this.testExecutionId + "]");
        if (client.get() != null) {
            client.get().cancelTestExecution(testExecutionId);
        } else {
            logger.warn("Cannot call stop run, LoadRunnerCloudClient is null");
        }
    }


    @Override
    public void afterTest() {
        logger.info("after test [" + testContext.getTestRunId() + "] with runId [" + this.testExecutionId + "]");
        testIsRunning = false;
    }
}