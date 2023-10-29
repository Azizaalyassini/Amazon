package com.amazon.mobile.controllers;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobilePlatform;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Set;

public class AndroidParallelController implements ControllerInterface {

    @Override
    public void startSession(String udid, String deviceName, String platformVersion, int systemPort) throws MalformedURLException {
        String appName;
        if (System.getProperty("appType").equals("agent")) {
            appName = "Agent.apk";
        } else {
            appName = "Retail.apk";
        }
        UiAutomator2Options options = new UiAutomator2Options()
                .setUdid(udid)
                .setPlatformVersion(platformVersion)
                .setDeviceName(deviceName)
                .setPlatformName(MobilePlatform.ANDROID)
                .setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2)
                .setApp(System.getProperty("user.dir") + "/src/test/resources/Builds/" + appName)
                .autoWebview()
                .setChromedriverPort(systemPort)
                .autoGrantPermissions()
                .clearDeviceLogsOnStart();
        options.setCapability("unicodeKeyboard", true);
        ThreadLocalDriver.setTLDriver(new AndroidDriver(new URL("http://localhost:4444/wd/hub"), options));
        changeContext();
    }

    public void changeContext() {
        int timeOut=0;
        Set<String> availableContexts1 = ((AndroidDriver) ThreadLocalDriver.getTLDriver()).getContextHandles();
        while (availableContexts1.size() == 1 && timeOut<10) {
            availableContexts1 = ((AndroidDriver) ThreadLocalDriver.getTLDriver()).getContextHandles();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            timeOut++;
        }
        ArrayList al = new ArrayList();
        al.addAll(availableContexts1);
        ((AndroidDriver) ThreadLocalDriver.getTLDriver()).context("" + al.get(1));
        while (((AndroidDriver) ThreadLocalDriver.getTLDriver()).getContextHandles() == null) {
            try {
                ThreadLocalDriver.getTLDriver().manage().timeouts().wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Set<String> availableContexts;
        availableContexts = ((AndroidDriver) ThreadLocalDriver.getTLDriver()).getContextHandles();
        al.addAll(availableContexts);
        ((AndroidDriver) ThreadLocalDriver.getTLDriver()).context("" + al.get(1));
    }

}
