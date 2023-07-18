package com.automation.training.tests.config;

import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;

public class CustomListener implements ITestListener {

    private static final Logger LOGGER = Logger.getLogger(CustomListener.class);
    @Override
    public void onFinish(ITestContext testContext) {
        LOGGER.info("PASSED TEST CASES");
        testContext.getPassedTests().getAllResults()
                .forEach(result -> {LOGGER.info(result.getName());});

        LOGGER.info("FAILED TEST CASES");
        testContext.getFailedTests().getAllResults()
                .forEach(result -> {LOGGER.info(result.getName());});

        LOGGER.info(
                "Test completed on: " + testContext.getEndDate().toString());
    }

}
