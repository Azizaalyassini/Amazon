package com.amazon.mobile.logging;

import org.testng.Reporter;

public class StepsLogging {


    public void logStep(String message) {
        Reporter.log(message);
    }

    public void clearStepsLog() {
        Reporter.clear();
    }
}
