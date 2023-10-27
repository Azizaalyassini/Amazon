package com.amazon.web.reporting;

import com.amazon.web.controllers.BaseTest;
import com.amazon.web.controllers.ThreadLocalDriver;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import java.util.List;

import static com.amazon.web.reporting.ExtentTestManager.getTest;
import static com.amazon.web.reporting.ExtentTestManager.startTest;

public class TestListener extends BaseTest implements ITestListener {

    // Get the method name associated with the test result.
    private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getTestContext().getCurrentXmlTest().getName();
    }

    @Override
    public void onStart(ITestContext iTestContext) {
        // TestNG listener: This method is called when the test context starts.
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        // TestNG listener: This method is called when the test context finishes.
        ExtentManager.extentReports.flush();
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
        // TestNG listener: This method is called when a test starts.
        startTest(getTestMethodName(iTestResult), "Test Started");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        // TestNG listener: This method is called when a test succeeds.
        ExtentTest testDetails = getTest().createNode("Test Details");
        testDetails.log(Status.PASS, "Test Passed");
        List<String> reporterMessages = Reporter.getOutput(iTestResult);
        ExtentTest testSteps = getTest().createNode("Test Steps");
        for (String reporterMessage : reporterMessages) {
            testSteps.log(Status.PASS, reporterMessage);
        }

        ExtentTest testPerformance = getTest().createNode("Page Load Time");
        testPerformance.log(Status.INFO, "Home Page Load Time: " + LOAD_TIME + "s");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        // TestNG listener: This method is called when a test fails.
        ExtentTest testDetails = getTest().createNode("Test Details");
        TakesScreenshot screenshot = (TakesScreenshot) ThreadLocalDriver.getTLDriver();
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

        ExtentTest testPerformance = getTest().createNode("Page Load Time");
        testPerformance.log(Status.INFO, "Home Page Load Time: " + LOAD_TIME + "s");
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        // TestNG listener: This method is called when a test is skipped.
        getTest().log(Status.SKIP, "Test Skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        // TestNG listener: This method is called when a test fails within the success percentage.
    }
}
