# test-events-neoload

Events to start and stop Neoload tests.

This event plugin starts a Neoload test for the given LoadTest id.

The plugin sends live load test metrics to InfluxDB for analysis.

## events
The `beforeTest` and `abortTest` event are implemented.

The `beforeTest` starts the load test and polls the Neoload server.

## messages
This is a `readyForStartParticipant`, so only when this event plugin sends a `Go!` message
on the `eventMessageBus` the event scheduler can progress to the `startTest` event. 
When the Neoload test reaches the `RUNNING` state, the `Go!` message is sent.

## properties for Neoload:
* `neoloadAccountToken` the API SAAS token for Neoload API v4
* `neoloadTestId` the test id
* `influxUrl` the url to send InfluxDB data
* `influxDatabase`the name of the InfluxDB database (default: neoload)
* `influxUser` the InfluxDB user (optional, default none)
* `influxPassword` the InfluxDB password (optional, default none)
* `pollingPeriodInSeconds` seconds between check if test is in STARTING state (optional, default 10)
* `pollingMaxDurationInSeconds` max duration to check if test gets to STARTING state (optional, default 300)
* `useProxy` activate proxy, for example to use with [mitmproxy](https://mitmproxy.org/) 
* `proxyPort` port to use for proxy, uses localhost (optional, default 8888) 

### notes
* neoloadAccountToken: generate in Neoload UI via Profile > Access Token > Generate new access token
* neoloadTestId: look up in browser url of Neoload UI, go to Test and extract TestId: `https://neoload.saas.neotys.com/#!test-settings/<TestId>/overview`

## variables

The Neoload plugin sends the following variables with a message on the `EventMessageBus`:
* perfana-neoload-testId
* perfana-neoload-testExecutionId
* perfana-neoload-workspaceId

## use with events-*-maven-plugin

You can use the `test-events-neoload` as a plugin of the `events-*-maven-plugin`
by putting the `test-events-neoload` jar on the classpath of the plugin.

Use the `dependencies` element inside the `plugin` element as in the XML snippet below.

For example, with `perfana-test-client` plugin (from [example-pom.xml](src/test/resources/example-pom.xml)):

```xml
<plugins>
    <plugin>
        <groupId>io.perfana</groupId>
        <artifactId>event-scheduler-maven-plugin</artifactId>
        <configuration>
            <eventSchedulerConfig>
                <debugEnabled>true</debugEnabled>
                <schedulerEnabled>true</schedulerEnabled>
                <failOnError>true</failOnError>
                <continueOnEventCheckFailure>true</continueOnEventCheckFailure>
                <testConfig>
                    <systemUnderTest>${systemUnderTest}</systemUnderTest>
                    <version>${version}</version>
                    <workload>${workload}</workload>
                    <testEnvironment>${testEnvironment}</testEnvironment>
                    <testRunId>${testRunId}</testRunId>
                    <buildResultsUrl>${buildResultsUrl}</buildResultsUrl>
                    <rampupTimeInSeconds>${rampupTimeInSeconds}</rampupTimeInSeconds>
                    <constantLoadTimeInSeconds>${constantLoadTimeInSeconds}</constantLoadTimeInSeconds>
                    <annotations>${annotations}</annotations>
                    <tags>${tags}</tags>
                </testConfig>
                <eventConfigs>
                    <eventConfig implementation="io.perfana.event.neoload.NeoloadEventConfig">
                        <name>NeoloadEvent1</name>
                        <neoloadAccountToken>a8579071ea254f929273c4a7dc382cd0153b745762903ab5</neoloadAccountToken>
                        <neoloadTestId>c2b85681-66b3-4142-8bf2-46208d0d2b2a</neoloadTestId>
                        <neoloadWorkspaceId>5e3acde2e860a132744ca916</neoloadWorkspaceId>
                        <influxUrl>http://localhost:8086</influxUrl>
                        <influxDatabase>neoload</influxDatabase>
                    </eventConfig>
                    <eventConfig implementation="io.perfana.event.PerfanaEventConfig">
                        <name>PerfanaEvent1</name>
                        <perfanaUrl>http://localhost:8888</perfanaUrl>
                        <assertResultsEnabled>false</assertResultsEnabled>
                        <variables>
                            <_var1>my_value</_var1>
                        </variables>
                    </eventConfig>
                </eventConfigs>
            </eventSchedulerConfig>
        </configuration>
        <dependencies>
            <dependency>
                <groupId>io.perfana</groupId>
                <artifactId>test-events-neoload</artifactId>
                <version>${test-events-neoload.version}</version>
            </dependency>
            <dependency>
                <groupId>io.perfana</groupId>
                <artifactId>perfana-java-client</artifactId>
                <version>${perfana-java-client.version}</version>
            </dependency>
        </dependencies>
    </plugin>
</plugins>
```

Try this by calling:

    mvn -f src/test/resources/example-pom.xml event-scheduler:test

## Todo

* create lookups for the project and test ids based on names

## References

Works with the Perfana event-scheduler framework: 
* https://github.com/perfana/event-scheduler
* https://github.com/perfana/event-Scheduler-maven-plugin
