package io.perfana.event.neoload;

import io.perfana.eventscheduler.api.EventLogger;
import io.perfana.eventscheduler.api.config.TestContext;

public class NeoloadUtils {

    private static final String NEOLOAD_BASE_URL = "https://neoload-v2.saas.neotys.com/v4/";

//    public static PerfanaTestContext createPerfanaTestContext(PerfanaEventContext context, TestContext testContext) {
//
//        return new TestContextBuilder()
//                .setVariables(context.getVariables())
//                .setTags(testContext.getTags())
//                .setAnnotations(testContext.getAnnotations())
//                .setSystemUnderTest(testContext.getSystemUnderTest())
//                .setVersion(testContext.getVersion())
//                .setCIBuildResultsUrl(testContext.getBuildResultsUrl())
//                .setConstantLoadTime(testContext.getConstantLoadTime())
//                .setRampupTime(testContext.getRampupTime())
//                .setTestEnvironment(testContext.getTestEnvironment())
//                .setTestRunId(testContext.getTestRunId())
//                .setWorkload(testContext.getWorkload())
//                .build();
//    }

    public static NeoloadClient createNeoloadClient(NeoloadEventContext eventContext, EventLogger logger) {
        return new NeoloadClient(NEOLOAD_BASE_URL, eventContext.getAccountToken(), logger, eventContext.isUseProxy(), eventContext.getProxyPort());
    }
}
