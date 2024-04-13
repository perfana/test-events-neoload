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
import io.perfana.eventscheduler.api.config.EventConfig;
import io.perfana.eventscheduler.api.config.EventContext;

import java.time.Duration;

public class NeoloadEventConfig extends EventConfig {
    private String neoloadAccountToken;
    private String neoloadTestId;
    private String influxUrl;
    private String influxUser;
    private String influxPassword;
    private String influxDatabase;
    private String influxRetentionPolicy;
    private int pollingPeriodInSeconds = 10;
    private int pollingMaxDurationInSeconds = 300;
    private int sendInfluxDataDelayInSeconds = 30;
    private boolean useProxy = false;
    private int proxyPort = 8888;

    public NeoloadEventConfig() {
        // default make it wait for test running before starting test
        setReadyForStartParticipant(true);
    }
    public void setNeoloadAccountToken(String neoloadAccountToken) {
        this.neoloadAccountToken = neoloadAccountToken;
    }

    public void setNeoloadTestId(String neoloadTestId) {
        this.neoloadTestId = neoloadTestId;
    }

    public void setUseProxy(boolean useProxy) {
        this.useProxy = useProxy;
    }

    public void setPollingPeriodInSeconds(int pollingPeriodInSeconds) {
        this.pollingPeriodInSeconds = pollingPeriodInSeconds;
    }

    public void setPollingMaxDurationInSeconds(int pollingMaxDurationInSeconds) {
        this.pollingMaxDurationInSeconds = pollingMaxDurationInSeconds;
    }

    public void setProxyPort(int proxyPort) {
        this.proxyPort = proxyPort;
    }

    public void setInfluxUrl(String influxUrl) {
        this.influxUrl = influxUrl;
    }

    public void setInfluxUser(String influxUser) {
        this.influxUser = influxUser;
    }

    public void setInfluxPassword(String influxPassword) {
        this.influxPassword = influxPassword;
    }

    public void setInfluxDatabase(String influxDatabase) {
        this.influxDatabase = influxDatabase;
    }

    public void setInfluxRetentionPolicy(String influxRetentionPolicy) {
        this.influxRetentionPolicy = influxRetentionPolicy;
    }

    private NeoloadEventContext createLoadRunnerCloudEventContext(EventContext context) {
        Duration pollingPeriod = Duration.ofSeconds(this.pollingPeriodInSeconds);
        Duration pollingMaxDuration = Duration.ofSeconds(this.pollingMaxDurationInSeconds);
        Duration sendInfluxDataDelay = Duration.ofSeconds(this.sendInfluxDataDelayInSeconds);

        InfluxWriterConfig influxWriterConfig = new InfluxWriterConfig(
                influxUrl,
                influxDatabase,
                influxUser,
                influxPassword,
                influxRetentionPolicy);

        return new NeoloadEventContext(
                context,
                neoloadAccountToken,
                neoloadTestId,
                pollingPeriod,
                pollingMaxDuration,
                sendInfluxDataDelay,
                influxWriterConfig,
                useProxy,
                proxyPort);
    }

    @Override
    public NeoloadEventContext toContext() {
        EventContext context = super.toContext();
        return createLoadRunnerCloudEventContext(context);
    }
}
