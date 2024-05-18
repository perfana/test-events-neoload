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

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import io.perfana.event.neoload.model.*;
import io.perfana.event.neoload.model.UserPathElement.StatisticsEnum;
import io.perfana.eventscheduler.api.EventLogger;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.*;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.client.LaxRedirectStrategy;
import org.apache.http.impl.conn.DefaultProxyRoutePlanner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.List;
import java.util.Map;

import static io.perfana.event.neoload.NeoloadCloudEvent.TRACING_HEADER_NAME;

public class NeoloadClient {

    public static final List<String> ALL_TIME_SERIES = List.of(
            "requestAvgDuration",
            "requestCountPerSecond",
            "requestErrors",
            "userLoad");

    public static final String CALL_TO_NEOLOAD_FAILED = "call to Neoload failed";

    private final ObjectMapper objectMapper = createCustomObjectMapper();

    private static ObjectMapper createCustomObjectMapper() {
        // Needed to read events with EventDetails interface that is
        // actually an ErrorEventDetails implementation.
        // Note that other modules are needed for other EventDetails.
        final var errorEventModule = new SimpleModule()
                .addAbstractTypeMapping(EventDetails.class, ErrorEventDetails.class);

        return new ObjectMapper()
                .registerModule(errorEventModule)
                .registerModule(new JavaTimeModule())
                .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
                .setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }

    private final ObjectReader currentUserReader = objectMapper.readerFor(CurrentUser.class);
    private final ObjectReader testPageReader = objectMapper.readerFor(TestPage.class);
    private final ObjectReader testExecutionReader = objectMapper.readerFor(TestExecution.class);
    private final ObjectReader resultTimeSeriesReader = objectMapper.readerFor(ResultTimeseries.class);
    private final ObjectReader getTestExecutionsResponseReader = objectMapper.readerFor(GetTestExecutionResponse.class);
    private final ObjectReader testResultPageReader = objectMapper.readerFor(TestResultPage.class);
    private final ObjectReader testReader = objectMapper.readerFor(Test.class);
    private final ObjectReader getResultElementValuesResponseReader = objectMapper.readerFor(GetResultElementValuesResponse.class);
    private final ObjectReader elementTimeSeriesReader = objectMapper.readerFor(ElementTimeSeries.class);
    private final ObjectReader eventPageReader = objectMapper.readerFor(EventPage.class);
    private final ObjectReader errorEventReader = objectMapper.readerFor(ErrorEvent.class);
    private final ObjectReader eventContentReader = objectMapper.readerFor(EventContent.class);
    private final ObjectReader projectReader = objectMapper.readerFor(Project.class);

    private final HttpClient httpClient;
    private final String baseUrl;
    private final EventLogger logger;

    private final int proxyPort;

    private final String accountToken;

    public NeoloadClient(String baseUrl, String accountToken, EventLogger logger) {
        this(baseUrl, accountToken, logger, false, 8888);
    }

    public NeoloadClient(String baseUrl, String accountToken, EventLogger logger, boolean useProxy, int proxyPort) {
        notEmpty(accountToken, "accountToken");
        this.accountToken = accountToken;

        checkBaseUrl(baseUrl);

        this.baseUrl = removeLastSlashIfPresent(baseUrl);
        this.logger = logger;
        this.httpClient = createHttpClient(useProxy);
        this.proxyPort = proxyPort;
    }

    private HttpClient createHttpClient(boolean useProxy) {

        RequestConfig requestConfig = RequestConfig.custom()
            .setConnectionRequestTimeout(1_000)
            .setConnectTimeout(5_000)
            .setSocketTimeout(10_000).build();

        HttpClientBuilder httpClientBuilder = HttpClients.custom()
            .setRedirectStrategy(new LaxRedirectStrategy())
            .setDefaultRequestConfig(requestConfig);

        if (useProxy) {
            HttpHost httpProxy = new HttpHost("localhost", proxyPort);
            DefaultProxyRoutePlanner routePlanner = new DefaultProxyRoutePlanner(httpProxy);
            httpClientBuilder.setRoutePlanner(routePlanner);
        }

        return httpClientBuilder.build();
    }

    public CurrentUser me() {
        String uri = String.format("%s/me", baseUrl);
        try {
            URIBuilder uriBuilder = new URIBuilder(uri);
            String result = executeGet(uriBuilder);
            return currentUserReader.readValue(result);

        } catch (URISyntaxException | IOException e) {
            throw new NeoloadClientException(CALL_TO_NEOLOAD_FAILED, e);
        }
    }

    public void cancelTestExecution(String testExecutionId) {

        String uri = String.format("%s/test-executions/%s", baseUrl, testExecutionId);

        try {
            URIBuilder uriBuilder = new URIBuilder(uri);

            executeDelete(uriBuilder);

        } catch (URISyntaxException | IOException e) {
            throw new NeoloadClientException(CALL_TO_NEOLOAD_FAILED, e);
        }
    }

    public TestExecution startRun(TestExecutionInput input) {
        String uri = String.format("%s/test-executions", baseUrl);

        try {
            URIBuilder uriBuilder = new URIBuilder(uri);

            String result = executePost(uriBuilder, input);

            return testExecutionReader.readValue(result);

        } catch (URISyntaxException | IOException e) {
            throw new NeoloadClientException(CALL_TO_NEOLOAD_FAILED, e);
        }
    }

    public TestPage listTests(String neoloadWorkspaceId) {

        String uri = String.format("%s/tests", baseUrl);

        try {
            URIBuilder uriBuilder = new URIBuilder(uri);
            uriBuilder.setParameter("workspaceId", neoloadWorkspaceId)
                    .setParameter("pageNumber", "0")
                    .setParameter("pageSize", "25")
                    .setParameter("sort", "-updatedAt");

            String result = executeGet(uriBuilder);

            return testPageReader.readValue(result);

        } catch (URISyntaxException | IOException e) {
            throw new NeoloadClientException(CALL_TO_NEOLOAD_FAILED, e);
        }
    }

    /**
     * Get results as the test progresses.
     *
     * @param resultId the result id
     * @param requestToken is null for first call, get from ResultTimeseries for subsequent calls.
     * @return results based on PT10M timewindow, use requestToken to fetch next data.
     */
    public ResultTimeseries resultsTimeSeries(String resultId, String requestToken) {
        return resultsTimeSeries(resultId, ALL_TIME_SERIES, requestToken);
    }

    /**
     * Start scraping live data.
     */
    public ResultTimeseries resultsTimeSeries(String resultId, List<String> series, String requestToken) {
        notEmpty(resultId, "resultId");

        String uri = String.format("%s/results/%s/timeseries", baseUrl, resultId);

        try {
            URIBuilder uriBuilder = new URIBuilder(uri);
            for (String s : series) { uriBuilder.addParameter("series", s); }
            if (requestToken != null) {
                uriBuilder.addParameter("requestToken", requestToken);
            }
            // fixedWindowDuration can be 10M or 30M only
            uriBuilder.addParameter("fixedWindowDuration", Duration.ofMinutes(10).toString());

            String result = executeGet(uriBuilder);

            return resultTimeSeriesReader.readValue(result);

        } catch (URISyntaxException | IOException e) {
            throw new NeoloadClientException(CALL_TO_NEOLOAD_FAILED, e);
        }
    }

    public GetTestExecutionResponse getTestExecution(String testExecutionId) {

        String uri = String.format("%s/test-executions/%s", baseUrl, testExecutionId);

        try {
            URIBuilder uriBuilder = new URIBuilder(uri);
            String result = executeGet(uriBuilder);

            return getTestExecutionsResponseReader.readValue(result);
        } catch (URISyntaxException | IOException e) {
            throw new NeoloadClientException(CALL_TO_NEOLOAD_FAILED, e);
        }
    }

    public TestResultPage testResultsPage(String workspaceId, List<TestResult.StatusEnum> status, List<String> testIds) {
        notEmpty(workspaceId, "workspaceId");

        String uri = String.format("%s/results", baseUrl);

        try {
            URIBuilder uriBuilder = new URIBuilder(uri);
            uriBuilder.setParameter("workspaceId", workspaceId);
            for (String testId : testIds) {
                uriBuilder.addParameter("testId", testId);
            }
            for (TestResult.StatusEnum s : status) {
                uriBuilder.addParameter("status", s.getValue());
            }
            uriBuilder.addParameter("pageNumber", "0");
            uriBuilder.addParameter("pageSize", "25");
            uriBuilder.addParameter("sort", "-startDate");

            String result = executeGet(uriBuilder);

            return testResultPageReader.readValue(result);

        } catch (URISyntaxException | IOException e) {
            throw new NeoloadClientException(CALL_TO_NEOLOAD_FAILED, e);
        }
    }

    public Test getTest(String testId) {
        String uri = String.format("%s/tests/%s", baseUrl, testId);

        try {
            URIBuilder uriBuilder = new URIBuilder(uri);
            String result = executeGet(uriBuilder);

            return testReader.readValue(result);
        } catch (URISyntaxException | IOException e) {
            throw new NeoloadClientException(CALL_TO_NEOLOAD_FAILED, e);
        }
    }

    public GetResultElementValuesResponse getResultElementsValues(String resultId, ElementsValuesFilter.ElementTypeEnum elementType) {
        String uri = String.format("%s/results/%s/elements/values", baseUrl, resultId);

        try {
            URIBuilder uriBuilder = new URIBuilder(uri);
            uriBuilder.setParameter("elementType", elementType.getValue());
            uriBuilder.setParameter("sort", "-name");
            uriBuilder.setParameter("pageNumber", "0");
            uriBuilder.setParameter("pageSize", "100");

            String result = executeGet(uriBuilder);

            return getResultElementValuesResponseReader.readValue(result);
        } catch (URISyntaxException | IOException e) {
            throw new NeoloadClientException(CALL_TO_NEOLOAD_FAILED, e);
        }
    }

    public ElementTimeSeries getResultElementTimeSeries(String resultId, String elementId, String requestToken) {
        String uri = String.format("%s/results/%s/elements/%s/timeseries", baseUrl, resultId, elementId);

        try {
            URIBuilder uriBuilder = new URIBuilder(uri);
            for (StatisticsEnum value : StatisticsEnum.values()) {
                if (value != StatisticsEnum.PERCENTILES) {
                    uriBuilder.addParameter("statistics", value.getValue());
                }
            }
            uriBuilder.addParameter("statistics", "count");
            if (requestToken != null) {
                uriBuilder.addParameter("requestToken", requestToken);
            }

            String result = executeGet(uriBuilder);

            return elementTimeSeriesReader.readValue(result);
        } catch (URISyntaxException | IOException e) {
            throw new NeoloadClientException(CALL_TO_NEOLOAD_FAILED, e);
        }
    }

    public EventPage getResultEventsForErrors(String resultId) {
        String uri = String.format("%s/results/%s/events", baseUrl, resultId);

        try {
            URIBuilder uriBuilder = new URIBuilder(uri);
            uriBuilder.addParameter("pageNumber", "0");
            // TODO make paging active to make this more efficient
            uriBuilder.addParameter("pageSize", "200");
            uriBuilder.addParameter("sort", "+offset");
            uriBuilder.addParameter("types", "ERROR");

            String result = executeGet(uriBuilder);

            return eventPageReader.readValue(result);
        } catch (URISyntaxException | IOException e) {
            throw new NeoloadClientException(CALL_TO_NEOLOAD_FAILED, e);
        }
    }

    private String executeGet(URIBuilder uriBuilder) throws URISyntaxException, IOException {
        HttpGet get = new HttpGet(uriBuilder.build());
        get.setHeader("accountToken", accountToken);
        get.setHeader("accept", "application/json");

        HttpResponse response = executeRequest(get);
        String result = responseToString(response);
        logger.debug(result);
        return result;
    }

    private String executePost(URIBuilder uriBuilder, TestExecutionInput input) throws URISyntaxException, IOException {
        HttpPost post = new HttpPost(uriBuilder.build());
        post.setHeader("accountToken", accountToken);
        post.setHeader("accept",  "application/json");
        post.setHeader("Content-Type", "application/json");
        String requestBody = objectMapper.writeValueAsString(input);
        post.setEntity(new StringEntity(requestBody));

        HttpResponse response = executeRequest(post);
        String result = responseToString(response);
        logger.debug(result);
        return result;
    }

    private String executePatch(URIBuilder uriBuilder, String requestBody) throws URISyntaxException, IOException {
        HttpPatch patch = new HttpPatch(uriBuilder.build());
        patch.setHeader("accountToken", accountToken);
        patch.setHeader("accept", "application/json");
        patch.setHeader("content-type", "application/json");
        patch.setEntity(new StringEntity(requestBody));

        HttpResponse response = executeRequest(patch);
        String result = responseToString(response);
        logger.debug(result);
        return result;
    }

    private static String responseToString(HttpResponse response) throws IOException {
        StringBuilder result = new StringBuilder(1024);
        try (BufferedReader rd = new BufferedReader(
                new InputStreamReader(response.getEntity().getContent()))) {

            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
        }
        return result.toString();
    }

    private void executeDelete(URIBuilder uriBuilder) throws URISyntaxException, IOException {
        HttpDelete delete = new HttpDelete(uriBuilder.build());
        delete.setHeader("accountToken", accountToken);
        delete.setHeader("accept", "*/*");
        HttpResponse response = executeRequest(delete);
        if (response.getStatusLine().getStatusCode() != 202) {
            throw new NeoloadClientException("cancel test run failed with status code: " + response.getStatusLine().getStatusCode());
        }
    }

    private HttpResponse executeRequest(HttpUriRequest request) throws IOException {
        HttpResponse response = httpClient.execute(request);
        int statusCode = response.getStatusLine().getStatusCode();
        if (statusCode < 200 || statusCode > 299) {
            String result = responseToString(response);
            throw new NeoloadClientException(String.format("Unexpected status code: %d for request: %s. Contents: %s", statusCode, request, result));
        }
        return response;
    }

    private static void checkBaseUrl(String baseUrl) {
        try {
            new URI(baseUrl);
        } catch (URISyntaxException e) {
            throw new NeoloadClientException("Invalid base url provided: " + baseUrl, e);
        }
    }

    private String removeLastSlashIfPresent(String url) {
        return url.endsWith("/") ? url.substring(0, url.length() - 1) : url;
    }

    private void notEmpty(String field, String name) {
        if (field == null || field.isEmpty()) {
            throw new NeoloadClientException(name + " is null or empty");
        }
    }

    public ErrorEvent getResultEvent(String resultId, String eventId) {
        String uri = String.format("%s/results/%s/events/%s", baseUrl, resultId, eventId);

        try {
            URIBuilder uriBuilder = new URIBuilder(uri);

            String result = executeGet(uriBuilder);

            return errorEventReader.readValue(result);
        } catch (URISyntaxException | IOException e) {
            throw new NeoloadClientException(CALL_TO_NEOLOAD_FAILED, e);
        }
    }

    public EventContent getResultEventContents(String resultId, String contentId) {
        notEmpty(contentId, "contentId");
        String uri = String.format("%s/results/%s/events/contents/%s",
                baseUrl, resultId, URLEncoder.encode(contentId, StandardCharsets.UTF_8));

        try {
            URIBuilder uriBuilder = new URIBuilder(uri);

            String result = executeGet(uriBuilder);

            return eventContentReader.readValue(result);
        } catch (URISyntaxException | IOException e) {
            throw new NeoloadClientException(CALL_TO_NEOLOAD_FAILED, e);
        }
    }

    public Project getProject(String testId) {
        String uri = String.format("%s/tests/%s/project", baseUrl, testId);

        try {
            URIBuilder uriBuilder = new URIBuilder(uri);

            String result = executeGet(uriBuilder);

            return projectReader.readValue(result);
        } catch (URISyntaxException | IOException e) {
            throw new NeoloadClientException(CALL_TO_NEOLOAD_FAILED, e);
        }
    }

    public void sendTracingHeader(String testId, String testRunId) {
        String uri = String.format("%s/tests/%s", baseUrl, testId);

        try {
            URIBuilder uriBuilder = new URIBuilder(uri);
            PatchTestInput patchTestInput = new PatchTestInput();
            patchTestInput.controllerEnvironmentVariables(Map.of(TRACING_HEADER_NAME, testRunId));
            patchTestInput.controllerZoneId("defaultzone");
            String requestBody = objectMapper.writeValueAsString(patchTestInput);
            executePatch(uriBuilder, requestBody);
            logger.info("sent tracing header '" + TRACING_HEADER_NAME + ": " + testRunId + "'");
        } catch (URISyntaxException | IOException e) {
            throw new NeoloadClientException(CALL_TO_NEOLOAD_FAILED, e);
        }
    }
}
