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
import io.perfana.event.neoload.model.ElementsValuesFilter.ElementTypeEnum;
import io.perfana.event.neoload.model.GetTestExecutionResponse.StepEnum;
import io.perfana.eventscheduler.api.EventAdapter;
import io.perfana.eventscheduler.api.EventLogger;
import io.perfana.eventscheduler.api.config.TestContext;
import io.perfana.eventscheduler.api.message.EventMessage;
import io.perfana.eventscheduler.api.message.EventMessage.EventMessageBuilder;
import io.perfana.eventscheduler.api.message.EventMessageBus;

import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

public class NeoloadCloudEvent extends EventAdapter<NeoloadEventContext> {

    public static final String PERFANA_NEOLOAD_PREFIX = "perfana-neoload-";
    public static final String PLUGIN_NAME = NeoloadCloudEvent.class.getSimpleName();
    public static final String TRACING_HEADER_NAME = "perfanaTestRunId";

    private final AtomicReference<NeoloadClient> client = new AtomicReference<>();
    private final AtomicReference<NeoloadInfluxWriter> influxWriter = new AtomicReference<>();
    private final AtomicReference<Instant> testStartTime = new AtomicReference<>();

    private final Duration sendInfluxDataDelay;

    private final String testId;
    private volatile String workspaceId;
    private volatile String testExecutionId;
    private volatile String testResultId;

    private volatile boolean testIsRunning = true;

    public NeoloadCloudEvent(NeoloadEventContext context, TestContext testContext, EventMessageBus messageBus, EventLogger logger) {
        super(context, testContext, messageBus, logger);
        this.testId = eventContext.getNeoloadTestId();
        this.sendInfluxDataDelay = eventContext.getSendInfluxDataDelay();
    }

    @Override
    public void beforeTest() {
        logger.info("before test [" + testContext.getTestRunId() + "]");

        client.set(NeoloadUtils.createNeoloadClient(eventContext, logger));

        InfluxWriterConfig config = eventContext.getInfluxWriterConfig();
        InfluxWriterNative writer = new InfluxWriterNative(config, logger);
        if (!writer.isHealthy()) {
            throw new NeoloadEventException("Influx writer is not healthy.");
        }
        influxWriter.set(new NeoloadInfluxWriter(writer));

        TestExecutionInput input = new TestExecutionInput();
        input.setTestId(testId);
        //input.setName(testContext.getProductName());
        //input.setDuration(Duration.ofMinutes(90).toString());
        input.setDescription("Run from test-events-neoload Perfana plugin");
        // WORKAROUND: webVu=50 is needed for the Neoload API to work
        input.setWebVu(50);

        TestExecution testExecution = client.get().startRun(input);

        this.testExecutionId = testExecution.getId();
        this.workspaceId = testExecution.getWorkspaceId();

        Map<String, String> variables = Map.of(
                PERFANA_NEOLOAD_PREFIX + "testExecutionId", testExecutionId,
                PERFANA_NEOLOAD_PREFIX + "testId", testId,
                PERFANA_NEOLOAD_PREFIX + "workspaceId", workspaceId);
        sendEventBusVariables(variables);

        logger.info(String.format("started polling at %s if running for workspaceId: %s testId: %s testExecutionId: %s",
                Instant.now(), workspaceId, testId, testExecutionId));

        startThread("NeoloadPollForTestRunning",
                createPollForTestRunningThread());
        startThread("ResultsFromNeoloadToInflux",
                sendResultsFromNeoloadToInfluxThread());
        startThread("ElementValuesAndSeriesFromNeoloadToInflux",
                sendElementValuesAndElementSeriesFromNeoloadToInfluxThread());
        startThread("ErrorsFromNeoloadToInflux",
                sendErrorsFromNeoloadToInfluxThread());

        logger.info(String.format("before test finished at %s with test execution id: %s. Now waiting for test status RUNNING.",
            Instant.now(), testExecutionId));
    }

    private void sendEventBusVariables(Map<String, String> variables) {
        EventMessageBuilder builder = EventMessage.builder();
        builder.pluginName(pluginName());
        variables.forEach((key, value) -> builder.variable(PERFANA_NEOLOAD_PREFIX + key, value));
        eventMessageBus.send(builder.build());
    }

    private static void startThread(String neoloadPollForTestRunning, Runnable pollForTestRunning) {
        Executor executor = Executors.newSingleThreadExecutor(r -> new Thread(r, neoloadPollForTestRunning));
        executor.execute(pollForTestRunning);
    }

    private Runnable sendErrorsFromNeoloadToInfluxThread() {
        return () -> {
            logger.info("Send errors to Influx thread");

            final Map<String, String> tags = createBasicTagsFromTestContext();
            Duration lastOffset = Duration.ZERO;
            Duration highestOffset = Duration.ZERO;
            int foundErrors = 0;
            int sentErrors = 0;

            while (testIsRunning) {
                try {
                    if (client.get() != null
                            && testExecutionId != null
                            && testStartTime.get() != null) {

                        EventPage result = client.get().getResultEventsForErrors(testResultId);

                        List<Event> events = result.getItems();

                        for (Event event : events) {
                            foundErrors++;

                            Duration currentOffset = Duration.parse(event.getOffset());
                            if (currentOffset.compareTo(highestOffset) > 0) {
                                highestOffset = currentOffset;
                            }

                            Instant eventTimestamp = testStartTime.get().plus(currentOffset);
                            logger.info("currentOffset: " + currentOffset + ", lastOffset: " + lastOffset + " eventTimestamp: " + eventTimestamp + ", foundErrors: " + foundErrors);

                            // greater than last recorded offset
                            if (currentOffset.compareTo(lastOffset) > 0) {
                                String code = event.getCode();
                                String eventId = event.getId();

                                ErrorEvent errorEvent = client.get().getResultEvent(testResultId, eventId);

                                String userPath = stripUserPathFromSource(errorEvent.getSource());

                                ErrorEventDetails details = (ErrorEventDetails) errorEvent.getDetails();
                                String transaction = details.getTransaction();
                                String request = details.getRequest();

                                String statusLineRequest = errorEvent.getCurrentRequest().getStatusLine();
                                String statusLineResponse = errorEvent.getCurrentResponse().getStatusLine();
                                String contentIdResponse = errorEvent.getCurrentResponse().getContentId();

                                String stringContentResponse = null;
                                if (contentIdResponse != null) {
                                    stringContentResponse = ""; //getStringContent(contentIdResponse);
                                }

                                RequestOrResponseDetails firstIterationResponse = errorEvent.getFirstIterationCurrentResponse();
                                String stringContentFirstIteration;
                                if (firstIterationResponse != null) {
                                    String contentId = firstIterationResponse.getContentId();
                                    stringContentFirstIteration = ""; //getStringContent(contentId);
                                } else {
                                    stringContentFirstIteration = null;
                                }

                                logger.debug("statusLineRequest: " + statusLineRequest + ", statusLineResponse: " + statusLineResponse);

                                Map<String, Object> fields = new HashMap<>();
                                fields.put("message", combineStringContent(stringContentResponse, stringContentFirstIteration));

                                sentErrors++;

                                tags.put("request", request);
                                tags.put("transaction", transaction);
                                tags.put("userPath", userPath);
                                tags.put("code", code);

                                influxWriter.get().uploadErrorToInfluxDB(
                                        eventTimestamp,
                                        fields,
                                        tags);
                            }

                            try {
                                // wait a little to reduce load on remote API
                                Thread.sleep(3);
                            } catch (InterruptedException e) {
                                Thread.currentThread().interrupt();
                            }
                        }

                    } else {
                        logger.info("No data available yet, not fetching errors to send to InfluxDB, will retry");
                    }
                } catch (Exception e) {
                    logger.error("Failed to send errors to InfluxDB", e);
                }

                try {
                    // wait 2 times to reduce load on error fetching
                    Thread.sleep(sendInfluxDataDelay.toMillis() * 2);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }

                logger.info("Sent " + sentErrors + " errors for " + foundErrors + " total errors. Highest offset: " + highestOffset);
                lastOffset = highestOffset;
                foundErrors = 0;
                sentErrors = 0;
            }
        };
    }

    private String combineStringContent(String stringContentResponse, String stringContentFirstIteration) {
        if (stringContentResponse != null && stringContentFirstIteration != null) {
            return stringContentResponse;
        } else if (stringContentResponse == null && stringContentFirstIteration != null) {
            return stringContentFirstIteration;
        }
        else if (stringContentResponse != null) {
            return stringContentResponse;
        }
        return "";
    }

    /**
     * Get userPath from a source string as "UserPath1#0 - Actions#38"
     */
    private String stripUserPathFromSource(String source) {
        if (source == null) { return "null"; }
        int index = source.indexOf('#');
        return index != -1 ? source.substring(0, index) : source;
    }

    private String getStringContent(String contentId) {
        EventContent eventContents =
                client.get().getResultEventContents(testResultId, contentId);
        return eventContents.getStringContent();
    }

    private Runnable sendElementValuesAndElementSeriesFromNeoloadToInfluxThread() {
        return () -> {

            String nextRequestToken = null;
            Map<String, String> tags = createBasicTagsFromTestContext();

            logger.info("Start thread to send series to Influx");

            while (testIsRunning) {
                try {
                    if (client.get() != null
                            && testExecutionId != null
                            && testStartTime.get() != null) {

                        // loop over TRANSACTION, REQUEST, ACTION and PAGE
                        for (ElementTypeEnum elementType : ElementTypeEnum.values()) {
                            GetResultElementValuesResponse response = client.get().getResultElementsValues(testResultId, elementType);

                            List<ResultElementValue> elementValues = response.getItems();

                            Map<String, String> idToName = elementValues.stream()
                                    .collect(Collectors.toMap(ResultElementValue::getId, ResultElementValue::getName));

                            Map<String, String> idToUserPath = elementValues.stream()
                                    .collect(Collectors.toMap(ResultElementValue::getId, ResultElementValue::getUserPath));

                            // expected to replace value per loop
                            tags.put("elementType", elementType.getValue());
                            sendElementValuesToInflux(elementValues, idToName, idToUserPath, tags);

                            for (Map.Entry<String, String> entry : idToName.entrySet()) {
                                String elementId = entry.getKey();
                                String name = entry.getValue();

                                ElementTimeSeries timeSeries = client.get().getResultElementTimeSeries(testResultId, elementId, nextRequestToken);

                                if (logger.isDebugEnabled()) {
                                    logger.debug("Name: " + name);
                                    logger.debug("TimeSeries: " + timeSeries);
                                }

                                List<ElementPoint> points = timeSeries.getPoints();

                                nextRequestToken = timeSeries.getNextRequestToken();
                                Boolean isFromScratch = timeSeries.getIsFromScratch();

                                if (!points.isEmpty()) {
                                    logger.info("Sending " + points.size() + " points to InfluxDB " +
                                            "for element: " + name +
                                            " with isFromScratch: " + isFromScratch +
                                            " for elementType: " + elementType);

                                    // expected to replace values for each loop
                                    tags.put("name", name);
                                    tags.put("userPath", idToUserPath.get(elementId));

                                    influxWriter.get().uploadElementPointsTimeSeriesToInfluxDB(
                                            points,
                                            testStartTime.get(),
                                            tags);
                                }
                            }
                        }
                    } else {
                        logger.info("No data available yet, not fetching element values and errors to send to InfluxDB, will retry");
                    }
                } catch (Exception e) {
                    logger.error("Failed to send element values and errors to InfluxDB", e);
                }

                try {
                    Thread.sleep(sendInfluxDataDelay.toMillis());
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            logger.info("End thread to send results to Influx");
        };
    }

    private Map<String, String> createBasicTagsFromTestContext() {
        Map<String, String> tags = new HashMap<>();
        tags.put("systemUnderTest", testContext.getSystemUnderTest());
        tags.put("testEnvironment", testContext.getTestEnvironment());
        tags.put("workload", testContext.getWorkload());
        return tags;
    }

    private void sendElementValuesToInflux(
            List<ResultElementValue> items,
            Map<String, String> idToName,
            Map<String, String> idToUserPath,
            Map<String, String> tags) {

        logger.info("Sending " + items.size() + " elementValues to Influx for elementType: " + tags.get("elementType"));

        for (ResultElementValue value : items) {

            Map<String, String> extendedTags = new HashMap<>(tags);
            extendedTags.put("name", idToName.get(value.getId()));
            extendedTags.put("userPath", idToUserPath.get(value.getId()));

            influxWriter.get().uploadResultElementsToInfluxDB(
                    value,
                    Instant.now(),
                    extendedTags);
        }
    }

    private Runnable sendResultsFromNeoloadToInfluxThread() {
        return () -> {

            String nextRequestToken = null;
            Map<String, String> tags = createBasicTagsFromTestContext();

            logger.info("Start thread to send results to Influx");

            while (testIsRunning) {
                try {
                    if (client.get() != null
                            && testExecutionId != null
                            && testStartTime.get() != null) {
                        ResultTimeseries result = client.get().resultsTimeSeries(testExecutionId, nextRequestToken);
                        nextRequestToken = result.getNextRequestToken();
                        boolean isFromScratch = result.getIsFromScratch();

                        List<Point> points = result.getPoints();

                        if (!points.isEmpty()) {
                            logger.info("Sending " + points.size() + " points to InfluxDB with isFromScratch: " + isFromScratch);
                            influxWriter.get().uploadResultsTimeSeriesToInfluxDB(
                                    points,
                                    testStartTime.get(),
                                    tags);
                        }
                    } else {
                        logger.info("No data available yet, not fetching results to send to InfluxDB, will retry");
                    }
                } catch (Exception e) {
                    logger.error("Failed to results to InfluxDB", e);
                }
                try {
                    Thread.sleep(sendInfluxDataDelay.toMillis());
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
            boolean checkStartTime = false;

            while (continuePolling) {

                // now start polling if load test is running, then send Go! message
                try {
                    if (!checkStartTime) {
                        GetTestExecutionResponse execution = client.get().getTestExecution(testExecutionId);

                        StepEnum step = execution.getStep();

                        logger.info(String.format("Status for test execution id %s is now: %s",
                                testExecutionId, step == null ? "<no status>" : step.name()));
                        if (step == StepEnum.CANCELLED
                                || step == StepEnum.FAILED
                                || step == StepEnum.FAILED_TO_PREPARE_CONTROLLER
                                || step == StepEnum.FAILED_TO_PREPARE_LGS) {
                            continuePolling = false;
                        }
                        if (step == StepEnum.STARTED_TEST) {
                            checkStartTime = true;
                        }
                    } else if (checkStartTime) {
                        // find test results
                        TestResultPage results = client.get().testResultsPage(workspaceId, List.of(TestResult.StatusEnum.values()), List.of(testId));
                        Optional<TestResult> testResultMaybe = results.getItems().stream().findFirst();
                        if (testResultMaybe.isPresent()) {
                            TestResult testResult = testResultMaybe.get();
                            logger.info("Test result status: " + testResult.getStatus());
                            if (testResult.getStatus() == TestResult.StatusEnum.RUNNING) {
                                // used to get series in other thread
                                testResultId = testResult.getId();
                                sendEventBusVariables(Map.of("testResultId", testResultId));
                                continuePolling = false;
                                testRunStarted = true;
                                testStartTime.set(testResult.getStartDate().toInstant());
                            } else if (checkTestResultForEndState(testResult)) {
                                continuePolling = false;
                            }
                        } else {
                            logger.warn("No test result available, will retry");
                        }
                    }

                    try {
                        Thread.sleep(sleepInMillis);
                    } catch (InterruptedException e) {
                        logger.warn("Interrupt received, will stop polling now.");
                        continuePolling = false;
                        sendEventMessageStop();
                        Thread.currentThread().interrupt();
                    }

                    if (System.currentTimeMillis() > maxPollingTimestamp) {
                        logger.warn("Max polling period reached (" + eventContext.getPollingMaxDuration() + " seconds), will stop polling now.");
                        continuePolling = false;
                        sendEventMessageStop();
                    } else {
                        if (testRunStarted) {
                            sendEventMessageGo();
                        } else {
                            sendEventMessageStop();
                        }
                    }
                } catch (NeoloadClientException e) {
                    logger.warn("Cannot check test result, will retry: " + e.getMessage());
                }
            }
        };
    }

    private static boolean checkTestResultForEndState(TestResult testResult) {
        return testResult.getStatus() == TestResult.StatusEnum.FAILED
                || testResult.getStatus() == TestResult.StatusEnum.TERMINATED
                || testResult.getStatus() == TestResult.StatusEnum.PASSED;
    }

    private void sendEventMessageStop() {
        EventMessage stopMessage = EventMessage.builder()
                .pluginName(pluginName())
                .message("Stop!")
                .build();
        eventMessageBus.send(stopMessage);
    }

    private void sendEventMessageGo() {
        EventMessage goMessage = EventMessage.builder()
                .pluginName(pluginName())
                .message("Go!")
                .build();
        eventMessageBus.send(goMessage);
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
            logger.warn("Cannot call stop run, NeoloadClient is null");
        }
    }


    @Override
    public void afterTest() {
        logger.info("after test [" + testContext.getTestRunId() + "] with runId [" + this.testExecutionId + "]");
        testIsRunning = false;
    }
}