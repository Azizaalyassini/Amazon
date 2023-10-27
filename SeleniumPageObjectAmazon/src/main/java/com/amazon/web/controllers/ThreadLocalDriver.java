package com.amazon.web.controllers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;

public class ThreadLocalDriver {

    // ThreadLocal is used to store a separate WebDriver instance per thread.
    private static final ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    // Get the WebDriver instance associated with the current thread.
    public synchronized static WebDriver getTLDriver() {
        return tlDriver.get();
    }

    // Set the WebDriver instance for the current thread, and decorate it with event listeners.
    public synchronized static void setTLDriver(WebDriver driver) {
        // Create an instance of WebDriverEventHandler, which is responsible for handling WebDriver events.
        WebDriverListener listener = new WebDriverEventHandler();

        // Decorate the driver with event listeners.
        WebDriver decorated = new EventFiringDecorator(listener).decorate(driver);

        // Set the decorated driver in the ThreadLocal, associating it with the current thread.
        tlDriver.set(decorated);
    }
}
