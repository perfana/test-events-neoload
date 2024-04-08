package io.perfana.event.neoload.influx;

import io.perfana.event.neoload.model.Point;
import io.perfana.event.neoload.model.ResultTimeseries;

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
