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
import io.perfana.eventscheduler.log.EventLoggerStdOut;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class NeoloadClientLiveTest {

    /**
     * Add a the following to your unit test environment to do a real connected test:
     * NEOLOAD_ACCOUNT_TOKEN=123e4567-e89b-12d3-a456-426655440000;NEOLOAD_WORKSPACE_ID=123435
     *
     * @return an initialized NeoloadClient
     */
    private NeoloadClient createRealNeoloadClient() {
        String neoloadAccountToken = System.getenv("NEOLOAD_ACCOUNT_TOKEN");

        return new NeoloadClient(
                "https://neoload-v2.saas.neotys.com/v4",
                neoloadAccountToken,
                EventLoggerStdOut.INSTANCE_DEBUG);
    }

    @Test
    @Disabled("only works with real influxdb to connect to")
    void me() {
        NeoloadClient client = createRealNeoloadClient();
        CurrentUser me = client.me();
        System.out.println(me);
    }

    @Test
    @Disabled("only works with real influxdb to connect to")
    void listTests() {
        String neoloadWorkspaceId = System.getenv("NEOLOAD_WORKSPACE_ID");
        assertNotNull(neoloadWorkspaceId);

        NeoloadClient client = createRealNeoloadClient();
        TestPage testPage = client.listTests(neoloadWorkspaceId);
        System.out.println(testPage);
        assertNotNull(testPage);
    }

    @Test
    @Disabled("only works with real influxdb to connect to")
    void getTest() {
        String testId = "c2b85681-66b3-4142-8bf2-46208d0d2b2a";
        NeoloadClient client = createRealNeoloadClient();
        io.perfana.event.neoload.model.Test test = client.getTest(testId);
        OffsetDateTime lastRunDate = test.getLastRunDate();
        System.out.println("lastRunDate: " + lastRunDate);
        System.out.println(test);
        assertNotNull(test);
    }

    @Test
    @Disabled("only works with real influxdb to connect to")
    void startRealTest() {
        NeoloadClient client = createRealNeoloadClient();

        Duration duration = Duration.ofMinutes(90);

        TestExecutionInput input = new TestExecutionInput();
        String testId = "c2b85681-66b3-4142-8bf2-46208d0d2b2a";
        input.setTestId(testId);
        //input.setReservationId(testId);
        //input.setDuration(duration.toString());
        //input.setName("Afterburner test run from Java");
        //input.setDescription("This is a first test");
        //input.setSapVu(0);
        input.setWebVu(50);

        TestExecution testExecution = client.startRun(input);
        System.out.println(testExecution);

        assertNotNull(testExecution);
    }

    @Test
    @Disabled("only works with real influxdb to connect to")
    void testResultsTimeSeries() throws InterruptedException {
        NeoloadClient client = createRealNeoloadClient();

        String testId = "5a988a90-5f07-42f6-b6cd-10ead5e09f31";

        String nextRequestToken = null;
        while (true) {
            ResultTimeseries result = client.resultsTimeSeries(testId, nextRequestToken);
            assertNotNull(result);

            nextRequestToken = result.getNextRequestToken();
            showPoints(result, nextRequestToken);

            System.out.println("Sleep 30 seconds");
            Thread.sleep(30_000);
        }
    }

    private static void showPoints(ResultTimeseries result, String nextRequestToken) {
        int size = result.getPoints().size();
        if (size > 1) {
            System.out.println("isFromScratch: " + result.getIsFromScratch()
                    + " next token: " + nextRequestToken
                    + " size: " + size
                    + " points: " + result.getPoints().get(0) + " " + result.getPoints().get(result.getPoints().size() - 1));
        } else {
            System.out.println("isFromScratch: " + result.getIsFromScratch()
                    + " next token: " + nextRequestToken
                    + " size: " + size);
        }
    }

    @Test
    @Disabled("only works with real influxdb to connect to")
    void testResults() {
        NeoloadClient client = createRealNeoloadClient();

        String workspaceId = System.getenv("NEOLOAD_WORKSPACE_ID");

        TestResultPage result = client.results(workspaceId, Collections.emptyList(), Collections.emptyList());

        List<TestResult> items = result.getItems();
        for (TestResult item : items) {
            System.out.println(item);
        }

        assertNotNull(result);
    }

    @Test
    @Disabled("only works with real influxdb to connect to")
    void getResultElementValues() {
        NeoloadClient client = createRealNeoloadClient();

        String resultId = "bf990cfc-14f8-4765-99bb-140c353ca782";

        GetResultElementValuesResponse response = client.getResultElementsValues(resultId);

        List<ResultElementValue> items = response.getItems();
        for (ResultElementValue item : items) {
            System.out.println(item);
        }

        assertNotNull(response);
    }

    @Test
    @Disabled("only works with real influxdb to connect to")
    void getResultElementTimeSeriesAll() {
        NeoloadClient client = createRealNeoloadClient();

        String resultId = "bf990cfc-14f8-4765-99bb-140c353ca782";

        GetResultElementValuesResponse response = client.getResultElementsValues(resultId);

        List<ResultElementValue> items = response.getItems();
        // items collect to map
        Map<String, String> nameToIds = items.stream()
                .collect(Collectors.toMap(ResultElementValue::getId, ResultElementValue::getName));

        // note: next token only works on running test
        String requestToken = null;
        // for each map entry
        for (Map.Entry<String, String> entry : nameToIds.entrySet()) {
            String id = entry.getKey();
            String name = entry.getValue();
            ElementTimeSeries timeseries = client.getResultElementTimeSeries(resultId, id, requestToken);
            assertNotNull(timeseries);
            System.out.println("Name: " + name);
            System.out.println("Timeseries: " + timeseries);
            requestToken = timeseries.getNextRequestToken();
        }

        assertNotNull(response);
    }

    @Test
    @Disabled("only works with real influxdb to connect to")
    void getResultElementTimeSeries() {
        NeoloadClient client = createRealNeoloadClient();

        String resultId = "bf990cfc-14f8-4765-99bb-140c353ca782";
        String elementId = "29259a3e-ae5a-4724-b12d-33801d264d3a";

        ElementTimeSeries timeseries = client.getResultElementTimeSeries(resultId, elementId, null);
        assertNotNull(timeseries);
        System.out.println("Timeseries: " + timeseries);
    }

    @Test
    @Disabled("only works with real influxdb to connect to")
    void testUploadTimeSeriesToRealInfluxDB() throws Exception {

        NeoloadClient client = createRealNeoloadClient();

        String testId = "80a0e387-13b6-4b46-9bf5-162c58216eed";

        ResultTimeseries result = client.resultsTimeSeries(testId, null);
        System.out.println(result);

        String influxDbUrl = "http://localhost:8086";
        String influxDbDatabase = "neoload";

        InfluxWriterConfig config = new InfluxWriterConfig(influxDbUrl, influxDbDatabase);

        try (InfluxWriterNative influxWriter = new InfluxWriterNative(config, EventLoggerStdOut.INSTANCE_DEBUG)) {
            NeoloadInfluxWriter neoloadWriter = new NeoloadInfluxWriter(influxWriter);
            Map<String, String> tags = Collections.singletonMap("systemUnderTest", "Afterburner");
            neoloadWriter.uploadResultsTimeSeriesToInfluxDB(result.getPoints(), Instant.now(), tags);
        }

        assertFalse(result.getPoints().isEmpty());
    }

    @Test
    //@Disabled("only works with real influxdb to connect to")
    void testErrorEventsToRealInfluxDB() throws Exception {

        NeoloadClient client = createRealNeoloadClient();

        String resultId = "46b1d9c5-6909-43b7-a3ab-8321df12dd64";

        EventPage result = client.getResultEvents(resultId);
        System.out.println(result);

//        String influxDbUrl = "http://localhost:8086";
//        String influxDbDatabase = "neoload";
//
//        InfluxWriterConfig config = new InfluxWriterConfig(influxDbUrl, influxDbDatabase);
//
//        try (InfluxWriterNative influxWriter = new InfluxWriterNative(config, EventLoggerStdOut.INSTANCE_DEBUG)) {
//            NeoloadInfluxWriter neoloadWriter = new NeoloadInfluxWriter(influxWriter);
//            Map<String, String> tags = Collections.singletonMap("systemUnderTest", "Afterburner");
//            neoloadWriter.uploadResultsTimeSeriesToInfluxDB(result.getPoints(), Instant.now(), tags);
//        }

        assertFalse(result.getItems().isEmpty());
    }

}