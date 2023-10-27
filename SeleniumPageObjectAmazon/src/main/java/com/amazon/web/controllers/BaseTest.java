package com.amazon.web.controllers;

import com.amazon.web.logging.StepsLogging;
import com.amazon.web.reporting.ReportingManager;
import com.amazon.web.utils.ActionHelper;
import com.amazon.web.utils.AllPagesHandler;
import org.testng.ITestResult;
import org.testng.annotations.*;

public class BaseTest {
    public static double LOAD_TIME;
    public AllPagesHandler pages;
    public StepsLogging logger;
    ReportingManager reportingManager;

    @BeforeSuite
    public void beforeSuite() {
        // Check if a test execution identifier is provided as a system property
        if (System.getProperty("testExecId") != null) {
            // Initialize the reporting manager and generate an access token
            reportingManager = new ReportingManager();
            reportingManager.generateAccessToken();
        }
    }

    @BeforeMethod
    public void beforeMethod() {
        // Get the browser type from the system property and start a new session
        ControllerInterface controllerInterface = ControllerFactory.getDriver(System.getProperty("browser")).orElseThrow(
                () -> new IllegalArgumentException("Invalid Browser, Please Use(chrome, firefox, edge)"));
        controllerInterface.startSession();

        // Initialize the pages handler, navigate to Amazon sign-in page, maximize the window, and save load time
        pages = new AllPagesHandler();
        ThreadLocalDriver.getTLDriver().get("https://www.amazon.com/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.com%2F%3Fref_%3Dnav_ya_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=usflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");
        ThreadLocalDriver.getTLDriver().manage().window().maximize();
        ActionHelper.saveLoadTime();
        logger = new StepsLogging();
    }

    @AfterMethod
    @Parameters({"testId"})
    public void afterMethod(@Optional("") String testId, ITestResult iTestResult) {
        // Check if a test execution identifier is provided and a test ID is specified
        if (System.getProperty("testExecId") != null && !testId.equals("")) {
            // Initialize the reporting manager and update the test status
            reportingManager = new ReportingManager();
            reportingManager.updateTestStatus(testId, iTestResult);
        }
        // Quit the WebDriver session
        ThreadLocalDriver.getTLDriver().quit();
    }
}
