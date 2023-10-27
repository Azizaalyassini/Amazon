package com.amazon.web.controllers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FireFoxController implements ControllerInterface {

    @Override
    public void startSession() {
        // Create an instance of FirefoxOptions to configure Firefox browser settings.
        FirefoxOptions options = new FirefoxOptions();

        // Set various capabilities to enable specific features.
        options.setCapability("network", true);
        options.setCapability("visual", true);
        options.setCapability("video", true);
        options.setCapability("console", true);

        // Note: The following line appears to be incorrect as it references ChromeOptions in a Firefox controller.
        // You might want to replace "ChromeOptions.CAPABILITY" with "FirefoxOptions.CAPABILITY" or remove it if not needed.

        // Create a new FirefoxDriver instance with the configured options.
        WebDriver driver = new FirefoxDriver(options);

        // Set the WebDriver instance in the ThreadLocalDriver for thread-safety.
        ThreadLocalDriver.setTLDriver(driver);
    }
}
