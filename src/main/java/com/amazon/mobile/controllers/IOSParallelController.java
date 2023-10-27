package com.amazon.mobile.controllers;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobilePlatform;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Set;

public class IOSParallelController implements ControllerInterface {

    @Override
    public void startSession(String udid, String deviceName, String platformVersion, int systemPort) throws MalformedURLException {
        String appName;
        if (System.getProperty("appType").equals("agent")) {
            appName = "Agent.ipa";
        } else {
            appName = "Retail.ipa";
        }
        XCUITestOptions options = new XCUITestOptions()
                .autoAcceptAlerts()
                .setUdid(udid)
                .setPlatformVersion(platformVersion)
                .setDeviceName(deviceName)
                .autoWebview()
                .setAutomationName(AutomationName.IOS_XCUI_TEST)
                .setPlatformName(MobilePlatform.IOS)
                .clearSystemFiles()
                .usePrebuiltWda()
                .setWdaLocalPort(systemPort)
                .setApp(System.getProperty("user.dir") + "/src/test/resources/Builds/" + appName);
        ThreadLocalDriver.setTLDriver(new IOSDriver(new URL("http://localhost:4444/wd/hub"), options));
        changeContext();
    }

    public void changeContext() {
        Set<String> availableContexts1 = ((IOSDriver) ThreadLocalDriver.getTLDriver()).getContextHandles();
        while (availableContexts1.size() == 1) {
            availableContexts1 = ((IOSDriver) ThreadLocalDriver.getTLDriver()).getContextHandles();
        }
        ArrayList al = new ArrayList();
        al.addAll(availableContexts1);
        ((IOSDriver) ThreadLocalDriver.getTLDriver()).context("" + al.get(1));
        while (((IOSDriver) ThreadLocalDriver.getTLDriver()).getContextHandles() == null) {
            try {
                ThreadLocalDriver.getTLDriver().manage().timeouts().wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Set<String> availableContexts;
        availableContexts = ((IOSDriver) ThreadLocalDriver.getTLDriver()).getContextHandles();
        al.addAll(availableContexts);
        ((IOSDriver) ThreadLocalDriver.getTLDriver()).context("" + al.get(1));
    }
}
