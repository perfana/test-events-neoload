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
import io.perfana.eventscheduler.api.config.EventContext;

import java.time.Duration;

public class NeoloadEventContext extends EventContext {
    private final String neoloadAccountToken;
    private final String neoloadTestId;
    private final Duration pollingPeriod;
    private final Duration pollingMaxDuration;
    private final Duration sendInfluxDataDelay;
    private final InfluxWriterConfig influxWriterConfig;
    private final boolean useProxy;
    private final int proxyPort;
    private final boolean overrideRuntimeSettings;

    NeoloadEventContext(
        EventContext context,
        String neoloadAccountToken,
        String neoloadTestId,
        Duration pollingPeriod,
        Duration pollingMaxDuration,
        Duration sendInfluxDataDelay,
        InfluxWriterConfig influxWriterConfig,
        boolean overrideRuntimeSettings,
        boolean useProxy,
        int proxyPort) {
            super(context, NeoloadEventFactory.class.getName());
            this.neoloadAccountToken = neoloadAccountToken;
            this.neoloadTestId = neoloadTestId;
            this.pollingPeriod = pollingPeriod;
            this.pollingMaxDuration = pollingMaxDuration;
            this.influxWriterConfig = influxWriterConfig;
            this.sendInfluxDataDelay = sendInfluxDataDelay;
            this.overrideRuntimeSettings = overrideRuntimeSettings;
            this.useProxy = useProxy;
            this.proxyPort = proxyPort;
    }

    public String getAccountToken() {
        return neoloadAccountToken;
    }

    public String getNeoloadTestId() {
        return neoloadTestId;
    }

    public Duration getPollingPeriod() {
        return pollingPeriod;
    }

    public Duration getPollingMaxDuration() {
        return pollingMaxDuration;
    }

    public boolean isUseProxy() {
        return useProxy;
    }

    public int getProxyPort() {
        return proxyPort;
    }

    public InfluxWriterConfig getInfluxWriterConfig() {
        return influxWriterConfig;
    }

    public Duration getSendInfluxDataDelay() {
        return sendInfluxDataDelay;
    }

    public boolean isOverrideRuntimeSettings() {
        return overrideRuntimeSettings;
    }

}
