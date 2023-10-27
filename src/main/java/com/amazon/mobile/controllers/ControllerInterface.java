package com.amazon.mobile.controllers;


import java.net.MalformedURLException;

public interface ControllerInterface {
    void startSession(String udid, String deviceName, String platformVersion, int systemPort) throws MalformedURLException;
}
