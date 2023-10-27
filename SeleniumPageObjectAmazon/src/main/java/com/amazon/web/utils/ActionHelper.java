package com.amazon.web.utils;

import com.amazon.web.controllers.BaseTest;
import com.amazon.web.controllers.ThreadLocalDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static java.time.Duration.ofSeconds;

public class ActionHelper {
    static WebDriverWait wait;

    public static void saveLoadTime() {
        JavascriptExecutor js = (JavascriptExecutor) ThreadLocalDriver.getTLDriver();
        js.executeScript("return (window.performance.timing.loadEventEnd - window.performance.timing.navigationStart) / 1000");
        double loadTime = (Double) js.executeScript("return (window.performance.timing.loadEventEnd - window.performance.timing.navigationStart) / 1000");
        BaseTest.LOAD_TIME = loadTime;
    }

    public void waitElementToBeVisible(WebElement element, int seconds) {
        wait = new WebDriverWait(ThreadLocalDriver.getTLDriver(), Duration.ofSeconds(seconds));
        wait.pollingEvery(Duration.ofSeconds(1));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitListOfElementsToBeVisible(List<WebElement> elements, int seconds) {
        wait = new WebDriverWait(ThreadLocalDriver.getTLDriver(), Duration.ofSeconds(seconds));
        wait.pollingEvery(Duration.ofSeconds(1));
        wait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    public void waitElementToBeClickable(WebElement element, int seconds) {
        wait = new WebDriverWait(ThreadLocalDriver.getTLDriver(), Duration.ofSeconds(seconds));
        wait.pollingEvery(Duration.ofSeconds(1));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void click(WebElement element) {
        try {
            waitElementToBeClickable(element, 5);
            element.click();
        } catch (Exception e) {
            forceClick(element);
        }
    }

    public void navigateBack() {
        ThreadLocalDriver.getTLDriver().navigate().back();
    }

    public void sendKeys(WebElement element, String text) {
        waitElementToBeVisible(element, 5);
        element.sendKeys(text);
    }


    public void hardClear(WebElement element) {
        waitElementToBeVisible(element, 5);
        element.sendKeys(Keys.chord(Keys.CONTROL + "a"));
        element.sendKeys(Keys.DELETE);
    }

    public void openNewTab(WebElement element){
        element.sendKeys(Keys.CONTROL +"t");

    }

    public void sendKeysWithClear(WebElement element, String text) {
        waitElementToBeVisible(element, 5);
        element.clear();
        element.sendKeys(text);
    }

    public boolean isDisplayed(WebElement element) {
        waitElementToBeVisible(element, 5);
        return element.isDisplayed();
    }

    public String getText(WebElement element) {
        waitElementToBeVisible(element, 5);
        return element.getText();
    }

    public void hoverAnElement(WebElement element) {
        waitElementToBeVisible(element, 5);
        Actions action = new Actions(ThreadLocalDriver.getTLDriver());
        action.moveToElement(element).build().perform();
    }

    public boolean isElementExist(WebElement element, int numberOfSeconds) {
        boolean isElementPresent = false;
        wait = new WebDriverWait(ThreadLocalDriver.getTLDriver(), Duration.ofSeconds(numberOfSeconds));
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            isElementPresent = element.isDisplayed();
        } catch (Exception e) {

        }

        return isElementPresent;
    }

    public void forceClick(WebElement element) {
        waitElementToBeClickable(element, 5);
        JavascriptExecutor executor = (JavascriptExecutor) ThreadLocalDriver.getTLDriver();
        executor.executeScript("arguments[0].click();", element);

    }

    public void chooseFirstFromList(List<WebElement> elements) {
        waitListOfElementsToBeVisible(elements, 5);
        forceClick(elements.get(1));
    }

    public void staticWait(int numberOfSeconds) {
        try {
            Thread.sleep(numberOfSeconds * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void uploadFile(WebElement element, String fileName, FileType fileType) {
        switch (fileType) {
            case GIF:
                element.sendKeys(System.getProperty("user.dir") + "/src/test/resources/UploadFile/" + fileName + ".gif");
                break;
            case JPG:
                element.sendKeys(System.getProperty("user.dir") + "/src/test/resources/UploadFile/" + fileName + ".jpg");
                break;
            case PNG:
                element.sendKeys(System.getProperty("user.dir") + "/src/test/resources/UploadFile/" + fileName + ".png");
                break;
            case TXT:
                element.sendKeys(System.getProperty("user.dir") + "/src/test/resources/UploadFile/" + fileName + ".txt");
                break;
        }
    }

    public void switchToTabByIndex(int tabIndex) {
        ArrayList<String> taps = new ArrayList<String>(ThreadLocalDriver.getTLDriver().getWindowHandles());
        ThreadLocalDriver.getTLDriver().switchTo().window(taps.get(tabIndex));
    }

    public int countTabs() {
        ArrayList<String> allTaps = new ArrayList<String>(ThreadLocalDriver.getTLDriver().getWindowHandles());
        String parentTab = allTaps.get(0);
        // Calculate the number of child tabs
        int childTabsCount = allTaps.size() - 1;
        return childTabsCount;
    }

    public void closeTap() {
        ThreadLocalDriver.getTLDriver().close();
    }

    public boolean isFileDownloaded_Ext(String fileName, String ext) {
        String path = System.getProperty("user.home") + "/downloads/";
        boolean flag = false;
        File dir = new File(path);
        File[] files = dir.listFiles();
        if (files == null || files.length == 0) {
            flag = false;
        }

        for (int i = 1; i < files.length; i++) {
            if (files[i].getName().contains(ext) && files[i].getName().contains(fileName)) {
                flag = true;
            }
        }
        return flag;
    }

    public boolean deleteDownloadedFile(String fileName, String ext) {
        String path = System.getProperty("user.home") + "/downloads/";
        boolean flag = false;
        File dir = new File(path);
        File[] files = dir.listFiles();
        if (files == null || files.length == 0) {
            flag = false;
        }

        for (int i = 1; i < files.length; i++) {
            if (files[i].getName().contains(ext) && files[i].getName().contains(fileName)) {
                files[i].delete();
                flag = true;
            }
        }
        return flag;
    }

    public void chooseFromListByText(List<WebElement> elements, String option) {
        waitListOfElementsToBeVisible(elements, 5);
        for (int i = 0; i < elements.size(); i++) {
            if (getText(elements.get(i)).trim().equals(option)) {
                click(elements.get(i));
                return;
            }
        }
    }

    public String getTextFromList(List<WebElement> elements, int index) {
        staticWait(1);
        return getText(elements.get(index));
    }

    public int getTextIndexFromList(List<WebElement> elements, String option) {
        waitListOfElementsToBeVisible(elements, 5);
        for (int i = 0; i < elements.size(); i++) {
            if (getText(elements.get(i)).trim().equals(option)) {
                return i;
            }
        }
        return 0;
    }


    public void chooseFromListByIndex(List<WebElement> elements, int index) {
        waitListOfElementsToBeVisible(elements, 5);
        click(elements.get(index));
    }

    public boolean checkIfElementExistInTheList(List<WebElement> elements, String option) {
        waitListOfElementsToBeVisible(elements, 5);
        for (int i = 0; i < elements.size(); i++) {
            if (getText(elements.get(i)).trim().equals(option)) {
                return true;
            }
        }
        return false;

    }

    public static String generateTimeStamp() {
        String dateFormat = "MMddHHmmss";
        DateFormat dateForm = new SimpleDateFormat(dateFormat);
        Date date = new Date();
        return dateForm.format(date);
    }

    public WebElement getLastElementFromList(List<WebElement> elements) {
        waitListOfElementsToBeVisible(elements, 5);
        return elements.get(elements.size() - 1);
    }

    public void waitSpinnerToBeInvisible(int seconds) {
        int timeOut = 0;
        wait = new WebDriverWait(ThreadLocalDriver.getTLDriver(), ofSeconds(seconds));
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'spinner-wrapper') or contains(@class,'spinner-layer')]")));
            while (ThreadLocalDriver.getTLDriver().findElements(By.xpath("//div[contains(@class,'spinner-wrapper') or contains(@class,'spinner-layer')]")).size() != 0) {
                if (timeOut > 30) {
                    break;
                }
                staticWait(1);
                timeOut++;
            }
        } catch (Exception e) {
        }
        staticWait(1);
    }


}

