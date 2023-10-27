package com.amazon.web.reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
    // Define a static final ExtentReports instance to manage the creation of Extent reports.
    public static final ExtentReports extentReports = new ExtentReports();

    // A synchronized method to create and configure an Extent report.
    public synchronized static ExtentReports createExtentReports() {
        // Create an ExtentSparkReporter instance and specify the location and name of the report file.
        ExtentSparkReporter reporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/Reports/amazon.html");

        // Configure the report name.
        reporter.config().setReportName("Amazon Web Automation Report");

        // Attach the reporter to the ExtentReports instance.
        extentReports.attachReporter(reporter);

        // Set system information that will be included in the report.
        extentReports.setSystemInfo("Author", "Aziza");
        extentReports.setSystemInfo("Browser", System.getProperty("browser").toUpperCase());
        extentReports.setSystemInfo("OS Name", System.getProperty("os.name"));
        extentReports.setSystemInfo("OS Version", System.getProperty("os.version"));

        // Return the configured ExtentReports instance.
        return extentReports;
    }
}
