package com.amazon.mobile.controllers;

import com.amazon.mobile.logging.StepsLogging;
import com.amazon.mobile.reporting.ReportingManager;
import com.amazon.mobile.utils.AllScreensHandler;
import com.amazon.mobile.utils.DevicesManager;
import com.amazon.mobile.utils.PerformanceDataCollector;
import org.json.simple.parser.ParseException;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.Map;

public class BaseTest extends StepsLogging {
    public static double MEMORY_ON_START, MEMORY_AFTER_FINISH;
    public static PerformanceDataCollector performanceDataCollector;
    public static Map<String, String> dbData;
    static boolean[] testCasesResults;
    static String[] testCasesIDs;
    public AllScreensHandler screens;
    public boolean usePerformanceChecker = Boolean.parseBoolean(System.getProperty("performance"));
    public ReportingManager reportingManager = new ReportingManager();
    DevicesManager devicesManager = new DevicesManager();

    @BeforeMethod
    @Parameters({"mobileName"})
    public void beforeMethod(@Optional("") String mobileName) throws IOException, ParseException {
        if (System.getProperty("device") != null) {
            devicesManager.prepareDeviceInfo(System.getProperty("device"));
        } else {
            devicesManager.prepareDeviceInfo(mobileName);
        }
        String udid = devicesManager.getUdid();
        String deviceName = devicesManager.getDeviceName();
        String platformVersion = devicesManager.getPlatformVersion();
        int systemPort = devicesManager.getSystemPort();
        ControllerInterface controllerInterface = ControllerFactory.getDriver(System.getProperty("platform")).orElseThrow(
                () -> new IllegalArgumentException("Invalid Platform, Please Use(Android, iOS, AndroidParallel, IOSParallel)"));
        controllerInterface.startSession(udid, deviceName, platformVersion, systemPort);
        screens = new AllScreensHandler();
        if (usePerformanceChecker) {
            performanceDataCollector = new PerformanceDataCollector();
            MEMORY_ON_START = performanceDataCollector.getMemoryInfo();
        }
        if (!System.getProperty("appType").equals("agent")) {
            if (System.getProperty("platform").contains("droid")) {
                ThreadLocalDriver.getTLDriver().get("https://localhost/login");
            } else {
                ThreadLocalDriver.getTLDriver().get("ionic://localhost/login");
            }
        }

    }

    @BeforeSuite
    public void beforeSuite(ITestContext iTestContext) {
        if (System.getProperty("testExecId") != null) {
            reportingManager.generateAccessToken();
        }

    }

    @AfterMethod
    @Parameters({"testID"})
    public void afterMethod(@Optional("") String testID, ITestResult iTestResult) {
        if (!testID.equals("") && System.getProperty("testExecId") != null) {
            reportingManager.updateTestStatus(testID, iTestResult);
        }

        ThreadLocalDriver.getTLDriver().quit();
        clearStepsLog();
    }

}
