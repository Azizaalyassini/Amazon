package com.amazon.mobile.utils;


import com.amazon.mobile.controllers.ThreadLocalDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.imagecomparison.SimilarityMatchingOptions;
import io.appium.java_client.imagecomparison.SimilarityMatchingResult;
import io.appium.java_client.ios.IOSDriver;
import org.codehaus.plexus.util.FileUtils;
import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import static java.time.Duration.ofMillis;
import static java.time.Duration.ofSeconds;
import static java.util.Collections.singletonList;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;


public class ActionHelper {
    UsersHandler usersHandler;
    WebDriverWait wait;

    public static String generateTimeStamp() {
        String dateFormat = "MMddHHmmss";
        DateFormat dateForm = new SimpleDateFormat(dateFormat);
        Date date = new Date();
        return dateForm.format(date);
    }


    public String forceGetText(WebElement element) {
        String elementText = ((JavascriptExecutor) ThreadLocalDriver.getTLDriver()).executeScript("return arguments[0].value", element).toString();
        return elementText;
    }

    public void click(WebElement element) {
        try {
            staticWait(0.5);
            waitElementToBeClickable(element, 10);
            element.click();
        } catch (Exception e) {
            staticWait(1);
            forceClick(element);
        }
    }

    public void moveSliderRight(WebElement element, int distance) {

        Actions action = new Actions(ThreadLocalDriver.getTLDriver());
        action.clickAndHold(element).moveByOffset(distance, 0).release(element).build().perform(); // to move slider backward
    }

    public void sendKeys(WebElement element, String text) {

        try {
            waitElementToBeVisible(element, 5);
            element.sendKeys(text);
        } catch (Exception e) {
            staticWait(1);
            forceSendKey(element, text);
        }
    }

    public void sendKeysWithClear(WebElement element, String text) {
        try {
            waitElementToBeVisible(element, 5);
            element.clear();
            element.sendKeys(text);
        } catch (Exception e) {
            staticWait(1);
            forceSendKeyWithClear(element, text);
        }
    }

    public String getText(WebElement element) {
        try {
            waitElementToBeVisible(element, 4);
            return element.getText();
        } catch (Exception e) {
            return forceGetText(element);
        }

    }

    public void waitElementToBeVisible(WebElement element, int seconds) {
        wait = new WebDriverWait(ThreadLocalDriver.getTLDriver(), ofSeconds(seconds));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitElementToBeClickable(WebElement element, int seconds) {
        wait = new WebDriverWait(ThreadLocalDriver.getTLDriver(), ofSeconds(seconds));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public int getListSize(List<WebElement> listOfElements) {
        return listOfElements.size();
    }

    public void clickModalListItemByLabelText(List<WebElement> listOfItems, String textToFInd) {
        waitListOfElementToBeVisible(listOfItems, 5);
        for (WebElement listItem : listOfItems) {
            if (listItem.getText().contains(textToFInd)) {
                forceClick(listItem);
                break;
            }
        }
    }

    public void clickModalAccountByTextAndCurrency(List<WebElement> listOfItems, String account, String currencySymbol) {
        waitListOfElementToBeVisible(listOfItems, 5);
        for (WebElement listItem : listOfItems) {
            if (getText(listItem).contains(account) && getText(listItem).contains(currencySymbol)) {
                click(listItem);
                waitSpinnerToBeInvisible(10);
                break;
            }
        }
    }

    public void waitListOfElementToBeVisible(List<WebElement> elements, int seconds) {
        int time = 0;
        while (elements.size() == 0 && time < seconds) {
            staticWait(1);
            time++;
        }
    }

    public void waitSpinnerToBeInvisible(int seconds) {
        isLoaderDisplayed(seconds);
        staticWait(1);
    }

    public boolean isDisplayed(WebElement element, int numberOfSeconds) {
        boolean isElementDisplayed = false;
        int counter = 0;
        while (counter < numberOfSeconds) {
            try {
                staticWait(0.5);
                counter++;
                isElementDisplayed = element.isDisplayed();
            } catch (Exception e) {

            }
            if (isElementDisplayed) {
                break;
            }
        }
        return isElementDisplayed;
    }

    public void scrollDownToElement(WebElement element) {
        int counter = 1;
        boolean isElementDisplayed = false;
        while (true) {
            try {
                wait = new WebDriverWait(ThreadLocalDriver.getTLDriver(), ofMillis(500));
                wait.until(ExpectedConditions.visibilityOf(element));
                isElementDisplayed = element.isDisplayed();
            } catch (Exception e) {

            }
            if (isElementDisplayed || counter == 5) {
                break;
            }
            scrollDown();
            counter++;
        }
    }

    public void scrollUpToElement(WebElement element) {
        int counter = 1;
        boolean isElementDisplayed = false;
        while (true) {
            try {
                wait = new WebDriverWait(ThreadLocalDriver.getTLDriver(), ofMillis(500));
                wait.until(ExpectedConditions.visibilityOf(element));
                isElementDisplayed = element.isDisplayed();
            } catch (Exception e) {

            }
            if (isElementDisplayed || counter == 5) {
                break;
            }
            scrollUp();
            counter++;
        }
    }

    public void exceptionalClick(WebElement element) {
        WebDriverWait wait = new WebDriverWait(ThreadLocalDriver.getTLDriver(), Duration.ofSeconds(5));
        wait.until(presenceOfElementLocated(toByVal(element))).click();
    }

    public By toByVal(WebElement we) {
        String[] data = we.toString().split(" -> ")[1].replace("]", "").split(": ");
        String locator = data[0];
        String term = data[1];

        switch (locator) {
            case "xpath":
                return By.xpath(term);
            case "css selector":
                return By.cssSelector(term);
            case "id":
                return By.id(term);
            case "tag name":
                return By.tagName(term);
            case "name":
                return By.name(term);
            case "link text":
                return By.linkText(term);
            case "class name":
                return By.className(term);
        }
        return (By) we;
    }

    private void isLoaderDisplayed(int seconds) {
        int timeOut = 0;
        WebDriverWait wait = new WebDriverWait(ThreadLocalDriver.getTLDriver(), ofSeconds(seconds));
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'global-spinner') or contains(@class,'loading-spinner')]")));
            while (ThreadLocalDriver.getTLDriver().findElements(By.xpath("//div[contains(@class,'global-spinner') or contains(@class,'loading-spinner')]")).size() != 0) {
                if (timeOut > 30) {
                    break;
                }
                staticWait(1);
                timeOut++;
            }
        } catch (Exception e) {
        }
    }


    public int getDeviceWidth() {
        return ThreadLocalDriver.getTLDriver().manage().window().getSize().getWidth();
    }

    public int getDeviceHeight() {
        return ThreadLocalDriver.getTLDriver().manage().window().getSize().getHeight();
    }

    public void scrollDown() {
        changeToNative();
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence sequence = new Sequence(finger, 1);
        sequence.addAction(finger.createPointerMove(ofMillis(0), PointerInput.Origin.viewport(), getDeviceWidth() / 2, (int) (getDeviceHeight() * 0.6)));
        sequence.addAction(finger.createPointerDown(PointerInput.MouseButton.MIDDLE.asArg()));
        sequence.addAction(new Pause(finger, ofMillis(600)));
        sequence.addAction(finger.createPointerMove(ofMillis(600), PointerInput.Origin.viewport(), getDeviceWidth() / 2, (int) (getDeviceHeight() * 0.3)));
        sequence.addAction(finger.createPointerUp(PointerInput.MouseButton.MIDDLE.asArg()));
        ThreadLocalDriver.getTLDriver().perform(singletonList(sequence));
        changeToHybrid();
    }

    public void scrollUp() {
        changeToNative();
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence sequence = new Sequence(finger, 1);
        sequence.addAction(finger.createPointerMove(ofMillis(0), PointerInput.Origin.viewport(), getDeviceWidth() / 2, (int) (getDeviceHeight() * 0.3)));
        sequence.addAction(finger.createPointerDown(PointerInput.MouseButton.MIDDLE.asArg()));
        sequence.addAction(new Pause(finger, ofMillis(600)));
        sequence.addAction(finger.createPointerMove(ofMillis(600), PointerInput.Origin.viewport(), getDeviceWidth() / 2, (int) (getDeviceHeight() * 0.6)));
        sequence.addAction(finger.createPointerUp(PointerInput.MouseButton.MIDDLE.asArg()));
        ThreadLocalDriver.getTLDriver().perform(singletonList(sequence));
        changeToHybrid();
    }

    public String getNumbers(WebElement element) {
        return getText(element).replaceAll("[^0-9\\.]+", "");
    }

    public String getTextSubstring(WebElement elementText, int startIndex, int endIndex) {
        return getText(elementText).substring(startIndex, endIndex);
    }

    public void swipe(double heightPercent, double startXPercent, double endXPercent) {
        double height = 100 / heightPercent;
        double startX = 100 / startXPercent;
        double endX = 100 / endXPercent;
        changeToNative();
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence sequence = new Sequence(finger, 1);
        sequence.addAction(finger.createPointerMove(ofMillis(0), PointerInput.Origin.viewport(), (int) (getDeviceWidth() / startX), (int) (getDeviceHeight() / height)));
        sequence.addAction(finger.createPointerDown(PointerInput.MouseButton.MIDDLE.asArg()));
        sequence.addAction(new Pause(finger, ofMillis(600)));
        sequence.addAction(finger.createPointerMove(ofMillis(600), PointerInput.Origin.viewport(), (int) (getDeviceWidth() / endX), (int) (getDeviceHeight() / height)));
        sequence.addAction(finger.createPointerUp(PointerInput.MouseButton.MIDDLE.asArg()));
        ThreadLocalDriver.getTLDriver().perform(singletonList(sequence));
        changeToHybrid();
    }

    public void changeToNative() {
        if (System.getProperty("platform").toLowerCase().contains("ios")) {
            ((IOSDriver) ThreadLocalDriver.getTLDriver()).context("NATIVE_APP");
        } else {
            ((AndroidDriver) ThreadLocalDriver.getTLDriver()).context("NATIVE_APP");
        }
    }

    public void changeToHybrid() {
        if (System.getProperty("platform").toLowerCase().contains("ios")) {
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
        } else {
            Set<String> availableContexts1 = ((AndroidDriver) ThreadLocalDriver.getTLDriver()).getContextHandles();
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

    public int getTextIndexFromList(List<WebElement> elements, String option) {
        waitListOfElementToBeVisible(elements, 5);
        for (int i = 0; i < elements.size(); i++) {
            if (getText(elements.get(i)).trim().equals(option) && isDisplayed(elements.get(i), 2)) {
                return i;
            }
        }
        return 0;
    }

    public void chooseFromListByIndex(List<WebElement> elements, int index) {
        try {
            forceClick(elements.get(index));
        } catch (Exception e) {
        }
    }

    public void chooseLastElementFromList(List<WebElement> elements) {
        try {
            forceClick(elements.get(elements.size() - 1));
        } catch (Exception e) {
        }
    }

    public void forceClick(WebElement element) {
        JavascriptExecutor executor = ThreadLocalDriver.getTLDriver();
        try {
            waitElementToBeClickable(element, 5);
        } catch (Exception e) {

        }
        executor.executeScript("arguments[0].click();", element);
        staticWait(0.5);
    }

    public boolean checkClassNameContains(WebElement element, String classText) {
        return element.getAttribute("className").contains(classText);
    }

    public boolean checkContainsText(WebElement element, String textToFind) {
        if (isDisplayed(element, 5)) {
            return getText(element).contains(textToFind);
        }
        return false;

    }

    public String getAttributeValue(WebElement element, String attributeName) {
        waitElementToBeVisible(element, 5);
        return element.getAttribute(attributeName);
    }

    public void forceSendKey(WebElement element, String text) {
        JavascriptExecutor js = ThreadLocalDriver.getTLDriver();
        js.executeScript("arguments[0].value = '" + text + "';", element);

    }

    public void forceSendKeyWithClear(WebElement element, String text) {
        try {
            waitElementToBeVisible(element, 5);
        } catch (Exception e) {

        }
        JavascriptExecutor js = ThreadLocalDriver.getTLDriver();
        js.executeScript("arguments[0].value = '';", element);
        js.executeScript("arguments[0].value = '" + text + "';", element);
    }

    public void clickByCoordinate(WebElement element) {
        Actions act = new Actions(ThreadLocalDriver.getTLDriver());
        act.moveToElement(element).click().build().perform();
    }

    public String getTextFromList(List<WebElement> elements, int index) {
        try {
            waitListOfElementToBeVisible(elements, 5);
            return getText(elements.get(index));
        } catch (Exception e) {
        }
        return null;
    }

    public WebElement getLastElementFromList(List<WebElement> elements) {
        staticWait(0.5);
        try {
            waitListOfElementToBeVisible(elements, 5);
            return elements.get(elements.size() - 1);
        } catch (Exception e) {
        }
        return null;
    }

    public JSONObject getUserCredentials(String user) {
        usersHandler = new UsersHandler();
        return usersHandler.getUserDetails(user);
    }

    public void staticWait(double seconds) {
        int secondsToWait = (int) (seconds * 1000);
        try {
            Thread.sleep(secondsToWait);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public WebElement getFirstElementFromList(List<WebElement> elements) {
        staticWait(0.5);
        try {
            waitListOfElementToBeVisible(elements, 5);
            return elements.get((elements.size() + 1) - elements.size());
        } catch (Exception e) {
        }
        return null;
    }

    public boolean checkIfListContainsText(List<WebElement> elements, String textToFind) {
        waitListOfElementToBeVisible(elements, 2);
        for (int i = 0; i < getListSize(elements); i++) {
            if (getText(elements.get(i)).equals(textToFind)) {
                return true;
            }
        }
        return false;
    }

    public void visualCheck(String checkName) throws Exception {
        changeToNative();
        double MATCH_THRESHOLD = 0.99;
        String baselineFilename = System.getProperty("user.dir") + "/Screens/" + checkName + ".png";
        File baselineImg = new File(baselineFilename);
        if (!baselineImg.exists()) {
            System.out.println(String.format("No baseline found for '%s' check; capturing baseline instead of checking", checkName));
            File newBaseline = ThreadLocalDriver.getTLDriver().getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(newBaseline, new File(baselineFilename));
            return;
        }

        SimilarityMatchingOptions opts = new SimilarityMatchingOptions();
        opts.withEnabledVisualization();
        SimilarityMatchingResult res = ThreadLocalDriver.getTLDriver().getImagesSimilarity(baselineImg, ThreadLocalDriver.getTLDriver().getScreenshotAs(OutputType.FILE), opts);

        if (res.getScore() < MATCH_THRESHOLD) {
            File failViz = new File(System.getProperty("user.dir") + "/FailedScreens/FAIL_" + checkName + ".png");
            res.storeVisualization(failViz);
            throw new Exception(
                    String.format("Visual check of '%s' failed; similarity match was only %f, and below the threshold of %f. Visualization written to %s.",
                            checkName, res.getScore(), MATCH_THRESHOLD, failViz.getAbsolutePath()));
        }
        changeToHybrid();
    }

}
