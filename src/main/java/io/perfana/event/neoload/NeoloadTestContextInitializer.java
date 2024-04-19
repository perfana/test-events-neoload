/*
 *    Copyright 2020-2023  Peter Paul Bakker @ perfana.io, Daniel Moll @ perfana.io
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package io.perfana.event.neoload;

import io.perfana.event.neoload.model.Project;
import io.perfana.event.neoload.model.Scenario;
import io.perfana.eventscheduler.api.EventLogger;
import io.perfana.eventscheduler.api.TestContextInitializer;
import io.perfana.eventscheduler.api.config.TestContext;

import java.time.Duration;
import java.time.format.DateTimeParseException;
import java.util.List;

public class NeoloadTestContextInitializer implements TestContextInitializer {

    private final NeoloadEventContext neoloadEventContext;
    private final EventLogger logger;

    NeoloadTestContextInitializer(NeoloadEventContext context, EventLogger logger) {
        this.neoloadEventContext = context;
        this.logger = logger;
    }

    @Override
    public TestContext extendTestContext(TestContext testContext) {
        if (!neoloadEventContext.isOverrideRuntimeSettings()) {
            logger.info("Neoload runtime settings override is disabled. No override will be done.");
            return testContext;
        }
        else {
            NeoloadClient neoloadClient = NeoloadUtils.createNeoloadClient(neoloadEventContext, logger);
            String testId = neoloadEventContext.getNeoloadTestId();

            Project project;
            try {
                project = neoloadClient.getProject(testId);
                if (project == null) {
                    logger.warn("Neoload project for test id " + testId + " is not found. No override will be done.");
                    return testContext;
                }
            } catch (Exception e) {
                logger.error("Neoload project for test id " + testId + " is not found. No override will be done.", e);
                return testContext;
            }

            List<Scenario> scenarios = project.getScenarios();
            if (scenarios.isEmpty()) {
                logger.error("No scenarios found for test [" + testId + "]. No override will be done.");
                return testContext;
            }

            Scenario scenario = scenarios.get(0);
            String duration = scenario.getDuration();

            String scenarioName = scenario.getName();
            logger.info("Getting the duration from the first scenario (" + scenarioName + "): " + duration);

            Duration durationOverride = null;
            try {
                durationOverride = Duration.parse(duration);
            } catch (DateTimeParseException e) {
                logger.error("Duration cannot be parsed [" + duration + "]. No override will be done.");
                return testContext;
            }

            TestContext contextOverride = testContext.withConstantLoadTime(durationOverride);

            logger.info("Neoload constantLoadTime override: '" + durationOverride + "'." +
                    " Rampup time is from original test context: " + contextOverride.getRampupTime());

            return contextOverride;
        }
    }
}
