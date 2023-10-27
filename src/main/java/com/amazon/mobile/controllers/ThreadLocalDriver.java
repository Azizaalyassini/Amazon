package com.amazon.mobile.controllers;

import io.appium.java_client.AppiumDriver;

public class ThreadLocalDriver {

    private static final ThreadLocal<AppiumDriver> tlDriver = new ThreadLocal<>();

    public synchronized static AppiumDriver getTLDriver() {
        return tlDriver.get();
    }

    public synchronized static void setTLDriver(AppiumDriver driver) {
        tlDriver.set(driver);
    }
}