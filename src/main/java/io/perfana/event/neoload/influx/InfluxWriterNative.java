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
package io.perfana.event.neoload.influx;

import io.perfana.eventscheduler.api.EventLogger;
import jakarta.validation.constraints.NotNull;

import java.io.IOException;
import java.net.PasswordAuthentication;
import java.net.URI;
import java.net.URLEncoder;
import java.net.Authenticator;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.time.Instant;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

public class InfluxWriterNative implements InfluxWriter {

    private final EventLogger log;

    private final HttpClient httpClient;

    private final List<String> metricsBuffer = new ArrayList<>();

    private final AtomicLong nextFlush = new AtomicLong(System.currentTimeMillis());

    private static final int MAX_BATCH_SIZE = 1_000;
    private static final int MAX_BATCH_AGE_MS = 5_000;

    private final Object bufferLock = new Object();

    private final URI writeUri;

    private final InfluxWriterConfig config;

    public InfluxWriterNative(InfluxWriterConfig config, EventLogger logger) {

        this.log = logger;

        this.config = config;

        this.httpClient = createHttpClient(config);

        Map<String, String> requestParams = initializeRequestParams(config);
        this.writeUri = createWriteUri(config.getUrl(), requestParams);

    }

    private static HttpClient createHttpClient(InfluxWriterConfig config) {
        HttpClient.Builder builder = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .connectTimeout(Duration.ofSeconds(3));

        if ((config.getUsername() != null && !config.getUsername().isBlank())
                && (config.getPassword() != null && !config.getPassword().isBlank())) {
            builder.authenticator(new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(config.getUsername(), config.getPassword().toCharArray());
                }
            });
        }

        return builder.build();
    }

    @Override
    public boolean isHealthy() {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(config.getUrl() + "/health"))
                .build();
        try {
            HttpResponse<String> send = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            int statusCode = send.statusCode();
            if (statusCode == 200) {
                log.info("Influx is healthy.");
                return true;
            }
            else {
                log.info("Influx not healthy. Status code: " + statusCode + " Message: " + send.body());
                return false;
            }
        } catch (IOException e) {
            log.error("Failed to send Influx health request", e);
            return false;
        } catch (InterruptedException e) {
            log.error("Influx health request was interrupted", e);
            Thread.currentThread().interrupt();
            return false;
        }
    }

    @Override
    public void writeMetricPoint(Instant timestamp, String key, Map<String, Object> inputFields, Map<String, String> inputTags) {

        // Line protocol: https://github.com/influxdata/influxdb/blob/master/tsdb/README.md

        long timestampEpochNano = InfluxWriter.toEpochNs(timestamp);

        // tags are sorted alphabetically for better performance in InfluxDB
        SortedMap<String, String> tags = new TreeMap<>();

        for (Map.Entry<String, String> tag : inputTags.entrySet()) {
            String escapedValue = escapeTagForInflux(tag.getValue());
            tags.put(tag.getKey(), escapedValue);
        }

        String generatedTags = tags.entrySet().stream()
                .map(e -> e.getKey() + "=" + e.getValue())
                .collect(Collectors.joining(","));

        String keyAndTags = key + "," + generatedTags;

        Map<String, String> fields = new HashMap<>();
        // note: field String values must be quoted, unlike tags
        if (!inputFields.isEmpty()) {
            for (Map.Entry<String, Object> entry : inputFields.entrySet()) {
                Object value = entry.getValue();
                String escapedValue = escapeFieldForInflux(value);
                fields.put(entry.getKey(), escapedValue);
            }
        }

        String generatedFields = fields.entrySet().stream()
                .map(e -> e.getKey() + "=" + e.getValue())
                .collect(Collectors.joining(","));

        String dataToSend = keyAndTags + " " + generatedFields + " " + timestampEpochNano;
        bufferAndSendToInflux(dataToSend);
    }

    private void bufferAndSendToInflux(String data) {
        log.debug(String.format("Buffering data: %s", data));
        Optional<String> metricsToWrite = addDataToBufferAndReturnAllWhenBufferIsFullThreadSafe(data);
        metricsToWrite.ifPresent(this::sendInfluxData);
    }

    private Optional<String> addDataToBufferAndReturnAllWhenBufferIsFullThreadSafe(String data) {
        synchronized (bufferLock) {
            metricsBuffer.add(data);
            if (bufferIsFullOrExpired()) {
                return flushBuffer();
            }
        }
        return Optional.empty();
    }

    @NotNull
    private Optional<String> flushBuffer() {
        log.debug(String.format("Flushing %d metrics to InfluxDB", metricsBuffer.size()));
        String allData = String.join("\n", metricsBuffer);
        clearBuffer();
        return Optional.of(allData);
    }

    private void clearBuffer() {
        nextFlush.set(System.currentTimeMillis() + MAX_BATCH_AGE_MS);
        metricsBuffer.clear();
    }

    private boolean bufferIsFullOrExpired() {
        return (metricsBuffer.size() > MAX_BATCH_SIZE) || (nextFlush.get() < System.currentTimeMillis());
    }

    private void sendInfluxData(String data) {
        log.debug(String.format("Writing data to InfluxDB: %s", data));

        HttpRequest request = HttpRequest.newBuilder()
                .uri(writeUri)
                .timeout(Duration.ofMinutes(2))
                .header("Content-Type", "application/x-www-form-urlencoded")
                .header("User-agent", "test-events-neoload/1.0")
                .POST(HttpRequest.BodyPublishers.ofString(data))
                .build();

        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            int statusCode = response.statusCode();
            log.debug(String.format("InfluxDB response: %d %s", statusCode, response.body()));
            if (statusCode != 204) {
                log.error(String.format("Failed to send request to InfluxDB: (%d) %s", statusCode, response.body()));
            }
        } catch (IOException e) {
            log.error(String.format("Failed to send request to InfluxDB: (%s) %s", e.getClass().getSimpleName(), e.getMessage()));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error(String.format("Failed to send request to InfluxDB: (%s) %s", e.getClass().getSimpleName(), e.getMessage()));
        }

    }

    @NotNull
    private URI createWriteUri(String baseUrl, Map<String, String> requestParams) {
        String requestParamsString = requestParams.entrySet().stream()
                .map(e -> e.getKey() + "=" + (e.getValue() == null || e.getValue().isEmpty() ? "" : URLEncoder.encode(e.getValue(), StandardCharsets.UTF_8)))
                .collect(Collectors.joining("&"));

        return URI.create(baseUrl + "/write?" + requestParamsString);
    }

    private static Map<String, String> initializeRequestParams(InfluxWriterConfig config) {
        var params = new HashMap<String, String>();
        params.put("db", config.getDatabase());
        params.put("u", config.getUsername());
        params.put("p", config.getPassword());
        params.put("precision", "n");
        return Collections.unmodifiableMap(params);
    }

    @NotNull
    private static String escapeFieldForInflux(Object value) {
        if (value == null) {
            return "\"\"";
        }
        if (value instanceof Number) {
            return value.toString();
        }
        if (value instanceof Boolean) {
            return value.toString();
        }
        String stringValue = value.toString();
        if (stringValue.contains("\"") || stringValue.contains("\\")) {
            return "\"" + escapeSlashesAndDoubleQuotes(value.toString()) + "\"";
        }
        return "\"" + value + "\"";
    }
    @NotNull
    private static String escapeTagForInflux(String value) {
        if (value == null) {
            return "<null>";
        }
        if (value.isBlank()) {
            return "<blank>";
        }
        return value.replace(" ", "\\ ").replace(",", "\\,");
    }

    private static String escapeSlashesAndDoubleQuotes(String text) {
        return text.replace("\"", "\\\"").replace("\\", "\\\\");
    }

    @Override
    public void close() throws Exception {
        flushBuffer().ifPresent(this::sendInfluxData);
    }
}
