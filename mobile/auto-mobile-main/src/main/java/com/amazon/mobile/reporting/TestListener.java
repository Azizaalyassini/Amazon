package com.amazon.mobile.reporting;


import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.amazon.mobile.controllers.BaseTest;
import com.amazon.mobile.controllers.ThreadLocalDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import java.text.DecimalFormat;
import java.util.List;

import static com.amazon.mobile.reporting.ExtentTestManager.getTest;
import static com.amazon.mobile.reporting.ExtentTestManager.startTest;


public class TestListener extends BaseTest implements ITestListener {


    private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getTestContext().getCurrentXmlTest().getName();
    }

    @Override
    public void onStart(ITestContext iTestContext) {
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        ExtentManager.extentReports.flush();
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
        startTest(getTestMethodName(iTestResult), "Test Started");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        ExtentTest testDetails = getTest().createNode("Test Details");
        testDetails.log(Status.PASS, "Test Passed");
        List<String> reporterMessages = Reporter.getOutput(iTestResult);
        ExtentTest testSteps = getTest().createNode("Test Steps");
        for (String reporterMessage : reporterMessages) {
            testSteps.log(Status.PASS, reporterMessage);
        }

        if (usePerformanceChecker) {
            addPerformanceData();
        }
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        ExtentTest testDetails = getTest().createNode("Test Details");
        TakesScreenshot screenshot = ThreadLocalDriver.getTLDriver();
        String base64Image = screenshot.getScreenshotAs(OutputType.BASE64);
        testDetails.log(Status.FAIL, "Test Failed");
        testDetails.info("Screenshot", MediaEntityBuilder.createScreenCaptureFromBase64String(base64Image).build());
        testDetails.info(iTestResult.getThrowable().toString());
        List<String> reporterMessages = Reporter.getOutput(iTestResult);
        ExtentTest testSteps = getTest().createNode("Test Steps");
        for (int i = 0; i < reporterMessages.size(); i++) {
            if (i != reporterMessages.size() - 1) {
                testSteps.log(Status.PASS, reporterMessages.get(i));
            } else {
                testSteps.log(Status.FAIL, reporterMessages.get(i));
            }
        }
        if (usePerformanceChecker) {
            addPerformanceData();
        }
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        getTest().log(Status.SKIP, "Test Skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
    }

    public void addPerformanceData() {
        DecimalFormat df = new DecimalFormat("0.0");
        double increasedBy;
        MEMORY_AFTER_FINISH = performanceDataCollector.getMemoryInfo();
        ExtentTest performanceData = getTest().createNode("Performance Information");
        performanceData.log(Status.INFO, "Memory Usage On Test Start: " + MEMORY_ON_START);
        performanceData.log(Status.INFO, "Memory Usage After Finish: " + MEMORY_AFTER_FINISH);
        increasedBy = (MEMORY_AFTER_FINISH - MEMORY_ON_START) / MEMORY_ON_START * 100;
        performanceData.log(Status.INFO, "Memory Usage Increased By: " + df.format(increasedBy) + "%");
    }
}