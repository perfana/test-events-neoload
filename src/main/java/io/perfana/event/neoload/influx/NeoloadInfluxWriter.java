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
import io.perfana.event.neoload.model.ResultElementValue;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class NeoloadInfluxWriter {
    private final InfluxWriter writer;

    public NeoloadInfluxWriter(InfluxWriter writer) {
        this.writer = writer;
    }

    public void uploadResultsTimeSeriesToInfluxDB(
            List<Point> points,
            Instant startTime,
            Map<String, String> tags) {

        for (Point point : points) {
            Instant timestamp = startTime.plus(Duration.parse(point.getOffset()));

            Map<String, Number> fields = new HashMap<>();
            fields.computeIfAbsent("requestAvgDuration", v -> point.getRequestAvgDuration());
            fields.computeIfAbsent("requestErrors", v -> point.getRequestErrors());
            fields.computeIfAbsent("userLoad", v -> point.getUserLoad());
            fields.computeIfAbsent("requestCountPerSecond", v -> point.getRequestCountPerSecond());

            writer.writeMetricPoint(timestamp, "resultTimeSeries", fields, tags);
        }
    }

    public void uploadElementPointsTimeSeriesToInfluxDB(
            List<ElementPoint> points,
            Instant startTime,
            Map<String, String> tags) {

        for (ElementPoint point : points) {
            Instant timestamp = startTime.plus(Duration.parse(point.getOffset()));

            Function<String, Double> calculatePassed =
                    v -> doubleValueOrZero(point.getCount()) - doubleValueOrZero(point.getErrors());

            Map<String, Number> fields = new HashMap<>();
            fields.computeIfAbsent("avgDuration", v -> point.getAvgDuration());
            fields.computeIfAbsent("minDuration", v -> point.getMinDuration());
            fields.computeIfAbsent("maxDuration", v -> point.getMaxDuration());
            fields.computeIfAbsent("avgTtfb", v -> point.getAvgTtfb());
            fields.computeIfAbsent("minTtfb", v -> point.getMinTtfb());
            fields.computeIfAbsent("maxTtfb", v -> point.getMaxTtfb());
            fields.computeIfAbsent("count", v -> point.getCount());
            fields.computeIfAbsent("throughput", v -> point.getThroughput());
            fields.computeIfAbsent("elementsPerSecond", v -> point.getElementsPerSecond());
            fields.computeIfAbsent("errors", v -> point.getErrors());
            fields.computeIfAbsent("errorRate", v -> point.getErrorRate());
            fields.computeIfAbsent("errorsPerSecond", v -> point.getErrorsPerSecond());
            fields.computeIfAbsent("passed", calculatePassed);

            writer.writeMetricPoint(timestamp, "elementTimeSeries", fields, tags);
        }
    }

    public void uploadResultElementsToInfluxDB(
            ResultElementValue value,
            Instant timestamp,
            Map<String, String> tags) {

        Function<String, Double> calculatePassed =
                v -> doubleValueOrZero(value.getCount()) - doubleValueOrZero(value.getErrors());

        Map<String, Number> fields = new HashMap<>();
        fields.computeIfAbsent("perc50", v -> doubleValueOrNull(value.getPerc50()));
        fields.computeIfAbsent("perc90", v -> doubleValueOrNull(value.getPerc90()));
        fields.computeIfAbsent("perc95", v -> doubleValueOrNull(value.getPerc95()));
        fields.computeIfAbsent("perc99", v -> doubleValueOrNull(value.getPerc99()));
        fields.computeIfAbsent("minDuration", v -> doubleValueOrNull(value.getMinDuration()));
        fields.computeIfAbsent("maxDuration", v -> doubleValueOrNull(value.getMaxDuration()));
        fields.computeIfAbsent("avgDuration", v -> doubleValueOrNull(value.getAvgDuration()));
        fields.computeIfAbsent("errors", v -> doubleValueOrNull(value.getErrors()));
        fields.computeIfAbsent("errorRate", v -> doubleValueOrNull(value.getErrorRate()));
        fields.computeIfAbsent("count", v -> doubleValueOrNull(value.getCount()));
        fields.computeIfAbsent("passed", calculatePassed);

        String parent = value.getParent();
        if (parent != null) {
            tags.put("parent", parent);
        }
        else {
            tags.remove("parent");
        }

        writer.writeMetricPoint(timestamp, "elementValues", fields, tags);
    }

    private Double doubleValueOrNull(BigDecimal value) {
        return value == null ? null : value.doubleValue();
    }

    private double doubleValueOrZero(BigDecimal value) {
        return value == null ? 0.0 : value.doubleValue();
    }

    private double doubleValueOrZero(Long value) {
        return value == null ? 0.0 : value.doubleValue();
    }
}
