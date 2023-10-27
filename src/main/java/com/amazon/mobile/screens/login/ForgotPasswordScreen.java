package com.amazon.mobile.screens.login;

import com.amazon.mobile.utils.ActionHelper;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class ForgotPasswordScreen extends ActionHelper {
    ForgotPasswordScreenLocators forgotPasswordScreenLocators;

    public ForgotPasswordScreen(AppiumDriver driver, ForgotPasswordScreenLocators forgotPasswordScreenLocators) {
        this.forgotPasswordScreenLocators = forgotPasswordScreenLocators;
        PageFactory.initElements(new AppiumFieldDecorator(driver), forgotPasswordScreenLocators);
    }

    public void openOnlineBanking() {
        click(forgotPasswordScreenLocators.getOnlineBankingButton());
    }

    public void openForgotPasswordDW() {
        click(forgotPasswordScreenLocators.getDigitalWalletButton());
    }

    public void fillPhoneNumberTextField(String phoneNumber) {
        sendKeys(forgotPasswordScreenLocators.getPhoneNumberTextField(), phoneNumber);
    }

    public void fillLast4DigitsTextField(String last4Digits) {
        sendKeys(forgotPasswordScreenLocators.getLast4DigitsTextField(), last4Digits);
    }

    public void fillUserNameTextField(String userName) {
        sendKeys(forgotPasswordScreenLocators.getUserNameTextField(), userName);
    }

    public void clickOnNextButton() {
        click(forgotPasswordScreenLocators.getNextButton());
    }

    public void forgotPasswordOnlineBanking(String userName, String phoneNumber, String last4Digits) {
        fillUserNameTextField(userName);
        fillPhoneNumberTextField(phoneNumber);
        fillLast4DigitsTextField(last4Digits);
        clickOnNextButton();
    }

    public String getForgotPasswordSuccessMessage() {
        return getText(forgotPasswordScreenLocators.getSuccessMessage());
    }

    public boolean checkIfNextButtonDisabled() {
        return Boolean.parseBoolean(getAttributeValue(forgotPasswordScreenLocators.getNextButton(), "disabled"));
    }

    public void clickOnSendNewCode() {
        click(forgotPasswordScreenLocators.getSendNewCode());
    }

    public void forgotPasswordDW(String userName, String phoneNumber) {
        fillUserNameTextField(userName);
        fillPhoneNumberTextField(phoneNumber);
        clickOnNextButton();
    }
}
