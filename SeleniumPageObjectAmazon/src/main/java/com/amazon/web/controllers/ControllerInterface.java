package com.amazon.web.controllers;

// This is an interface that defines a contract for classes that manage WebDriver sessions.
public interface ControllerInterface {
    // This method is responsible for starting a WebDriver session, and it should be implemented by concrete controller classes.
    void startSession();
}
