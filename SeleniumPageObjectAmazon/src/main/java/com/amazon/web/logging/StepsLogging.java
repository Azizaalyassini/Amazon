package com.amazon.web.logging;

import org.testng.Reporter;

public class StepsLogging {

    // Log a step or message to the TestNG Reporter. This can be used for test step logging.
    public void logStep(String message) {
        Reporter.log(message);
    }

    // Clear any log entries in the TestNG Reporter. This can be used to reset the logging.
    public void clearStepsLog() {
        Reporter.clear();
    }
}
