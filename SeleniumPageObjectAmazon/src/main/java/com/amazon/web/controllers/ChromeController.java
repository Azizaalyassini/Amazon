package com.amazon.web.controllers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeController implements ControllerInterface {
    @Override
    public void startSession() {
        // Create a ChromeOptions instance to configure ChromeDriver capabilities
        ChromeOptions options = new ChromeOptions();

        // Enable various capabilities like network, visual, video, and console logs
        options.setCapability("network", true);
        options.setCapability("visual", true);
        options.setCapability("video", true);
        options.setCapability("console", true);
        options.setCapability(ChromeOptions.CAPABILITY, options);

        // Add an argument to allow remote origins (if needed)
        options.addArguments("--remote-allow-origins=*");

        // Initialize the WebDriver with ChromeDriver using the configured options
        WebDriver driver = new ChromeDriver(options);

        // Set the WebDriver as the ThreadLocalDriver to ensure thread safety
        ThreadLocalDriver.setTLDriver(driver);
    }
}
