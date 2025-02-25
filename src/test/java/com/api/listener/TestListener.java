package com.api.listener;

import com.api.reports.ExtentReportsManager;
import com.aventstack.extentreports.Status;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
    Logger logger = LogManager.getLogger(TestListener.class);

    public void onTestStart(ITestResult result) {
        logger.info(result.getMethod().getMethodName() + " : Test started...!!");
        ExtentReportsManager.startTest(result.getMethod().getMethodName());
    }

    public void onTestSuccess(ITestResult result) {
        logger.info(result.getMethod().getMethodName() + " : Test Passed...!!");
        ExtentReportsManager.getTest().log(Status.PASS, "Test Passed : " + result.getName());
    }

    public void onTestFailure(ITestResult result) {
        logger.info(result.getMethod().getMethodName() + " : Test Failed...!!");
        ExtentReportsManager.getTest().log(Status.FAIL, "Test Failed : " + result.getName());
    }

    public void onStart(ITestContext context) {
        logger.info("Test suite started...!!");
    }

    public void onFinish(ITestContext context) {
        logger.info("Test suite finished...!!");
        ExtentReportsManager.endTest();
    }
}
