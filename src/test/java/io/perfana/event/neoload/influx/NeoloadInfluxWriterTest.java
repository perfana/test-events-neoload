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
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

class NeoloadInfluxWriterTest {

    @Test
    void testUploadResultsTimeSeriesToInfluxDB() {

        AtomicInteger counter = new AtomicInteger();

        InfluxWriter writer = new InfluxWriter() {
            @Override
            public boolean isHealthy() {
                return true;
            }

            @Override
            public void writeMetricPoint(Instant timestamp, String key, Map<String, Number> inputFields, Map<String, String> inputTags) {
                if (counter.incrementAndGet() == 1) {
                    Assertions.assertEquals(Instant.parse("2024-01-01T00:00:01.0Z"), timestamp);
                    Assertions.assertEquals("resultTimeSeries", key);
                    Assertions.assertEquals(Collections.singletonMap("application", "test"), inputTags);
                    Assertions.assertEquals(Double.valueOf("1.0"), inputFields.get("requestAvgDuration"));
                }
            }

            @Override
            public void close() throws Exception {
            }
        };

        NeoloadInfluxWriter neoloadInfluxWriter = new NeoloadInfluxWriter(writer);

        Point point = new Point();
        point.setOffset("PT1S");
        point.setRequestAvgDuration(1.0);

        neoloadInfluxWriter.uploadResultsTimeSeriesToInfluxDB(Collections.singletonList(point), Instant.parse("2024-01-01T00:00:00.00Z"), Collections.singletonMap("application", "test"));
    }

}