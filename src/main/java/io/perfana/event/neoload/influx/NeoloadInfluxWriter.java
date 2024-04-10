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

import io.perfana.event.neoload.model.ElementPoint;
import io.perfana.event.neoload.model.Point;

import java.time.Duration;
import java.time.Instant;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NeoloadInfluxWriter {
    private final InfluxWriter writer;

    public NeoloadInfluxWriter(InfluxWriter writer) {
        this.writer = writer;
    }

    public void uploadTimeSeriesToInfluxDB(
            List<Point> points,
            Instant startTime,
            Map<String, String> tags) {

        for (Point point : points) {
            Instant timestamp = startTime.plus(Duration.parse(point.getOffset()));

            Double requestAvgDuration = point.getRequestAvgDuration();
            Double requestCountPerSecond = point.getRequestCountPerSecond();
            Long requestErrors = point.getRequestErrors();
            Long userLoad = point.getUserLoad();

            writeToInfluxIfNotNull(timestamp, "requestAvgDuration", "durationMs", requestAvgDuration, tags);
            writeToInfluxIfNotNull(timestamp, "requestCountPerSecond", "rate", requestCountPerSecond, tags);
            writeToInfluxIfNotNull(timestamp, "requestErrors", "count", requestErrors, tags);
            writeToInfluxIfNotNull(timestamp, "userLoad", "count", userLoad, tags);
        }
    }

    public void uploadElementPointsTimeSeriesToInfluxDB(
            String transactionName,
            List<ElementPoint> points,
            Instant startTime,
            Map<String, String> tags) {

        Map<String, String> extendedTags = new HashMap<>(tags);
        extendedTags.put("transaction", transactionName);

        for (ElementPoint point : points) {
            Instant timestamp = startTime.plus(Duration.parse(point.getOffset()));

            Double avgDuration = point.getAvgDuration();
            Double minDuration = point.getMinDuration();
            Double maxDuration = point.getMaxDuration();
            Double avgTtfb = point.getAvgTtfb();
            Double minTtfb = point.getMinTtfb();
            Double maxTtfb = point.getMaxTtfb();
            Long count = point.getCount();
            Double throughput = point.getThroughput();
            Double elementsPerSecond = point.getElementsPerSecond();
            Long errors = point.getErrors();
            Double errorRate = point.getErrorRate();
            Double errorsPerSecond = point.getErrorsPerSecond();

            writeToInfluxIfNotNull(timestamp, "avgDuration", "durationMs", avgDuration, extendedTags);
            writeToInfluxIfNotNull(timestamp, "minDuration", "durationMs", minDuration, extendedTags);
            writeToInfluxIfNotNull(timestamp, "maxDuration", "durationMs", maxDuration, extendedTags);
            writeToInfluxIfNotNull(timestamp, "avgTtfb", "durationMs", avgTtfb, extendedTags);
            writeToInfluxIfNotNull(timestamp, "minTtfb", "durationMs", minTtfb, extendedTags);
            writeToInfluxIfNotNull(timestamp, "maxTtfb", "durationMs", maxTtfb, extendedTags);
            writeToInfluxIfNotNull(timestamp, "count", "count", count, extendedTags);
            writeToInfluxIfNotNull(timestamp, "throughput", "bytesPerSecond", throughput, extendedTags);
            writeToInfluxIfNotNull(timestamp, "elementsPerSecond", "rate", elementsPerSecond, extendedTags);
            writeToInfluxIfNotNull(timestamp, "errors", "count", errors, extendedTags);
            writeToInfluxIfNotNull(timestamp, "errorRate", "percentage", errorRate, extendedTags);
            writeToInfluxIfNotNull(timestamp, "errorsPerSecond", "rate", errorsPerSecond, extendedTags);
        }
    }

    private void writeToInfluxIfNotNull(Instant timestamp, String key, String field, Number value, Map<String, String> extendedTags) {
        if (value != null) {
            writeToInflux(timestamp, key, field, String.valueOf(value), extendedTags);
        }
    }

    private void writeToInflux(Instant timestamp, String key, String field, String fieldValue, Map<String, String> tags) {
        writer.writeMetricPoint(timestamp,
                key,
                field,
                fieldValue,
                tags,
                Collections.emptyMap());
    }
}
