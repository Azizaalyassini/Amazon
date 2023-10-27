package com.amazon.web.controllers;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.events.WebDriverListener;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.time.Duration;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public class WebDriverEventHandler implements WebDriverListener {

    // This class acts as a listener for WebDriver events and overrides the methods to handle various WebDriver operations.

    @Override
    public void beforeAnyCall(Object target, Method method, Object[] args) {
        // Pre-operation logic for any WebDriver call.
    }

    @Override
    public void afterAnyCall(Object target, Method method, Object[] args, Object result) {
        // Post-operation logic for any WebDriver call.
    }

    @Override
    public void onError(Object target, Method method, Object[] args, InvocationTargetException e) {
        // Handling errors that occur during WebDriver operations.
    }

    // Methods for handling WebDriver operations...

    @Override
    public void beforeClick(WebElement element) {
        // Execute logic before clicking on a WebElement.
    }

    @Override
    public void afterClick(WebElement element) {
        // Execute logic after clicking on a WebElement.
    }

    @Override
    public void beforeFindElement(WebDriver driver, By locator) {
        // Execute logic before finding a WebElement by a locator.
    }

    @Override
    public void afterFindElement(WebDriver driver, By locator, WebElement result) {
        // Execute logic after finding a WebElement by a locator.
    }

    // ... (similarly, there are other before/after methods for various WebDriver operations)

    public boolean waitLoaderToBeInvisible() {
        // Custom logic to wait for a loader element to become invisible.
        boolean isElementPresent = false;
        WebDriverWait wait = new WebDriverWait(ThreadLocalDriver.getTLDriver(), Duration.ofSeconds(1));
        try {
            wait.until(ExpectedConditions.visibilityOf(ThreadLocalDriver.getTLDriver().findElement(By.xpath("//mat-progress-spinner"))));
            isElementPresent = ThreadLocalDriver.getTLDriver().findElement(By.xpath("//mat-progress-spinner")).isDisplayed();
        } catch (Exception e) {
            // Handle exceptions that may occur during waiting.
        }
        return isElementPresent;
    }
}
