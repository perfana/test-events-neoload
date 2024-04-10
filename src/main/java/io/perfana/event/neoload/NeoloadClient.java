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
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import io.perfana.event.neoload.model.*;
import io.perfana.event.neoload.model.UserPathElement.StatisticsEnum;
import io.perfana.eventscheduler.api.EventLogger;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
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
import java.time.Duration;
import java.util.List;

public class NeoloadClient {

    public static final List<String> ALL_TIME_SERIES = List.of(
            "requestAvgDuration",
            "requestCountPerSecond",
            "requestErrors",
            "userLoad");

    private final ObjectMapper objectMapper = new ObjectMapper()
            .registerModule(new JavaTimeModule())
            .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
            .setSerializationInclusion(JsonInclude.Include.NON_NULL);

    private final ObjectReader currentUserReader = objectMapper.readerFor(CurrentUser.class);
    private final ObjectReader testPageReader = objectMapper.readerFor(TestPage.class);
    private final ObjectReader testExecutionReader = objectMapper.readerFor(TestExecution.class);
    private final ObjectReader resultTimeSeriesReader = objectMapper.readerFor(ResultTimeseries.class);
    private final ObjectReader getTestExecutionsResponseReader = objectMapper.readerFor(GetTestExecutionResponse.class);
    private final ObjectReader testResultPageReader = objectMapper.readerFor(TestResultPage.class);
    private final ObjectReader testReader = objectMapper.readerFor(Test.class);
    private final ObjectReader getResultElementValuesResponseReader = objectMapper.readerFor(GetResultElementValuesResponse.class);
    private final ObjectReader elementTimeSeriesReader = objectMapper.readerFor(ElementTimeSeries.class);

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

    private HttpClient createHttpClient(boolean useProxy) {

        RequestConfig requestConfig = RequestConfig.custom()
            .setConnectionRequestTimeout(1_000)
            .setConnectTimeout(4_000)
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

    private HttpResponse executeRequest(HttpUriRequest request) throws IOException {
        HttpResponse response = httpClient.execute(request);
        int statusCode = response.getStatusLine().getStatusCode();
        if (statusCode < 200 || statusCode > 299) {
            String result = responseToString(response);
            throw new NeoloadClientException(String.format("Unexpected status code: %d for request: %s. Contents: %s", statusCode, request, result));
        }
        return response;
    }

    public CurrentUser me() {

        String uri = String.format("%s/me", baseUrl);

        try {
            URIBuilder uriBuilder = new URIBuilder(uri);

            HttpGet get = new HttpGet(uriBuilder.build());
            get.setHeader("accountToken", accountToken);
            get.setHeader("accept", "application/json");
            HttpResponse response = executeRequest(get);
            String result = responseToString(response);
            logger.debug(result);

            return currentUserReader.readValue(result);

        } catch (URISyntaxException | IOException e) {
            throw new NeoloadClientException("call to Neoload failed", e);
        }
    }

    public void cancelTestExecution(String testExecutionId) {

        String uri = String.format("%s/test-executions/%s", baseUrl, testExecutionId);

        try {
            URIBuilder uriBuilder = new URIBuilder(uri);

            HttpDelete delete = new HttpDelete(uriBuilder.build());
            delete.setHeader("accountToken", accountToken);
            delete.setHeader("accept", "*/*");
            HttpResponse response = executeRequest(delete);
            if (response.getStatusLine().getStatusCode() != 202) {
                throw new NeoloadClientException("cancel test run failed with status code: " + response.getStatusLine().getStatusCode());
            }

        } catch (URISyntaxException | IOException e) {
            throw new NeoloadClientException("call to Neoload failed", e);
        }
    }

    public TestExecution startRun(TestExecutionInput input) {
        String uri = String.format("%s/test-executions", baseUrl);

        try {
            URIBuilder uriBuilder = new URIBuilder(uri);

            HttpPost post = new HttpPost(uriBuilder.build());
            post.setHeader("accountToken", accountToken);
            post.setHeader("accept", "application/json");
            post.setHeader("Content-Type", "application/json");
            String requestBody = objectMapper.writeValueAsString(input);
            post.setEntity(new StringEntity(requestBody));

            HttpResponse response = executeRequest(post);
            String result = responseToString(response);
            logger.debug(result);

            return testExecutionReader.readValue(result);

        } catch (URISyntaxException | IOException e) {
            throw new NeoloadClientException("call to Neoload failed", e);
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

            HttpGet get = new HttpGet(uriBuilder.build());
            get.setHeader("accountToken", accountToken);
            get.setHeader("accept", "application/json");

            HttpResponse response = executeRequest(get);
            String result = responseToString(response);
            logger.debug(result);

            return testPageReader.readValue(result);

        } catch (URISyntaxException | IOException e) {
            throw new NeoloadClientException("call to Neoload failed", e);
        }
    }

    /**
     * Get results as the test progresses.
     *
     * @param testId the test run id
     * @param nextRequestToken is null for first call, get from ResultTimeseries for subsequent calls.
     * @return results based on PT10M timewindow, use nextRequestToken to fetch next data.
     */
    public ResultTimeseries resultsTimeSeries(String testId, String nextRequestToken) {
        return resultsTimeSeries(testId, ALL_TIME_SERIES, nextRequestToken);
    }

    /**
     * Start scraping live data.
     */
    public ResultTimeseries resultsTimeSeries(String testId, List<String> series, String nextRequestToken) {
        notEmpty(testId, "testId");

        String uri = String.format("%s/results/%s/timeseries", baseUrl, testId);

        try {
            URIBuilder uriBuilder = new URIBuilder(uri);
            for (String s : series) { uriBuilder.addParameter("series", s); }
            if (nextRequestToken != null) {
                uriBuilder.addParameter("nextRequestToken", nextRequestToken);
            }
            uriBuilder.addParameter("fixedWindowDuration", Duration.ofMinutes(10).toString());

            HttpGet get = new HttpGet(uriBuilder.build());
            get.setHeader("accountToken", accountToken);
            get.setHeader("accept", "application/json");

            HttpResponse response = executeRequest(get);
            String result = responseToString(response);
            logger.debug(result);

            return resultTimeSeriesReader.readValue(result);

        } catch (URISyntaxException | IOException e) {
            throw new NeoloadClientException("call to Neoload failed", e);
        }
    }

    public GetTestExecutionResponse getTestExecution(String testExecutionId) {

        String uri = String.format("%s/test-executions/%s", baseUrl, testExecutionId);

        try {
            URIBuilder uriBuilder = new URIBuilder(uri);
            HttpGet get = new HttpGet(uriBuilder.build());
            get.setHeader("accountToken", accountToken);
            get.setHeader("accept", "application/json");

            HttpResponse response = executeRequest(get);
            String result = responseToString(response);
            logger.debug(result);

            return getTestExecutionsResponseReader.readValue(result);
        } catch (URISyntaxException | IOException e) {
            throw new NeoloadClientException("call to Neoload failed", e);
        }
    }

    public TestResultPage results(String workspaceId, List<TestResult.StatusEnum> status, List<String> testIds) {
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

            HttpGet get = new HttpGet(uriBuilder.build());
            get.setHeader("accountToken", accountToken);
            get.setHeader("accept", "application/json");

            HttpResponse response = executeRequest(get);
            String result = responseToString(response);
            logger.debug(result);

            return testResultPageReader.readValue(result);

        } catch (URISyntaxException | IOException e) {
            throw new NeoloadClientException("call to Neoload failed", e);
        }
    }

    public Test getTest(String testId) {
        String uri = String.format("%s/tests/%s", baseUrl, testId);

        try {
            URIBuilder uriBuilder = new URIBuilder(uri);
            HttpGet get = new HttpGet(uriBuilder.build());
            get.setHeader("accountToken", accountToken);
            get.setHeader("accept", "application/json");

            HttpResponse response = executeRequest(get);
            String result = responseToString(response);
            logger.debug(result);

            return testReader.readValue(result);
        } catch (URISyntaxException | IOException e) {
            throw new NeoloadClientException("call to Neoload failed", e);
        }
    }

    public GetResultElementValuesResponse getResultElementsValues(String resultId) {
        String uri = String.format("%s/results/%s/elements/values", baseUrl, resultId);

        try {
            URIBuilder uriBuilder = new URIBuilder(uri);
            uriBuilder.setParameter("elementType", ElementsValuesFilter.ElementTypeEnum.TRANSACTION.getValue());
            uriBuilder.setParameter("sort", "-name");
            uriBuilder.setParameter("pageNumber", "0");
            uriBuilder.setParameter("pageSize", "100");

            HttpGet get = new HttpGet(uriBuilder.build());
            get.setHeader("accountToken", accountToken);
            get.setHeader("accept", "application/json");

            HttpResponse response = executeRequest(get);
            String result = responseToString(response);
            logger.debug(result);

            return getResultElementValuesResponseReader.readValue(result);
        } catch (URISyntaxException | IOException e) {
            throw new NeoloadClientException("call to Neoload failed", e);
        }
    }

    public ElementTimeSeries getResultElementTimeSeries(String resultId, String elementId) {
        String uri = String.format("%s/results/%s/elements/%s/timeseries", baseUrl, resultId, elementId);

        try {
            URIBuilder uriBuilder = new URIBuilder(uri);
            for (StatisticsEnum value : StatisticsEnum.values()) {
                if (value != StatisticsEnum.PERCENTILES) {
                    uriBuilder.addParameter("statistics", value.getValue());
                }
            }
            uriBuilder.addParameter("statistics", "count");

            HttpGet get = new HttpGet(uriBuilder.build());
            get.setHeader("accountToken", accountToken);
            get.setHeader("accept", "application/json");

            HttpResponse response = executeRequest(get);
            String result = responseToString(response);
            logger.debug(result);

            return elementTimeSeriesReader.readValue(result);
        } catch (URISyntaxException | IOException e) {
            throw new NeoloadClientException("call to Neoload failed", e);
        }
    }
}
