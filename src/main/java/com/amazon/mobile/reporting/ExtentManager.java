package com.amazon.mobile.reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
    public static final ExtentReports extentReports = new ExtentReports();

    public synchronized static ExtentReports createExtentReports() {
        ExtentSparkReporter reporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/Reports/cr2-mobile-report" + System.currentTimeMillis() + ".html");
        reporter.config().setReportName("CR2 Mobile Automation Report");
        extentReports.attachReporter(reporter);
        extentReports.setSystemInfo("Author", "CR2");
        extentReports.setSystemInfo("DeviceName", "Samsung Galaxy S12");
        extentReports.setSystemInfo("DeviceVersion", "10");
        extentReports.setSystemInfo("Platform", System.getProperty("platform"));
        return extentReports;
    }
}