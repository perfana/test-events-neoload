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

import io.perfana.event.neoload.model.Point;

import java.time.Duration;
import java.time.Instant;
import java.util.Collections;
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

            writeToInflux(timestamp, "requestAvgDuration", "durationMs", String.valueOf(requestAvgDuration), tags);
            writeToInflux(timestamp, "requestCountPerSecond", "rate", String.valueOf(requestCountPerSecond), tags);
            writeToInflux(timestamp, "requestErrors", "count", String.valueOf(requestErrors), tags);
            writeToInflux(timestamp, "userLoad", "count", String.valueOf(userLoad), tags);
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
