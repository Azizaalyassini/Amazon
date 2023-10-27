package com.amazon.mobile.screens.login;

import com.amazon.mobile.utils.ActionHelper;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class ForgotUserNameScreen extends ActionHelper {
    ForgotUserNameScreenLocators forgotUserNameScreenLocators;

    public ForgotUserNameScreen(AppiumDriver driver, ForgotUserNameScreenLocators forgotUserNameScreenLocators) {
        this.forgotUserNameScreenLocators = forgotUserNameScreenLocators;
        PageFactory.initElements(new AppiumFieldDecorator(driver), forgotUserNameScreenLocators);
    }

    public boolean checkForgotUsernameTitleIsDisplayed() {
        return isDisplayed(forgotUserNameScreenLocators.getForgotUsernameTitle(), 5);
    }

    public void fillPhoneNumberTextField(String phoneNumber) {
        sendKeys(forgotUserNameScreenLocators.getPhoneNumberTextField(), phoneNumber);
    }

    public void fillLast4DigitsTextField(String last4Digits) {
        sendKeys(forgotUserNameScreenLocators.getLast4DigitsTextField(), last4Digits);
    }

    public void fillPasswordTextField(String password) {
        sendKeys(forgotUserNameScreenLocators.getPasswordTextField(), password);
    }

    public void clickOnSendButton() {
        click(forgotUserNameScreenLocators.getSendButton());
    }

    public void fillForgotUsernameFormAndClickSendButton(String phoneNumber, String last4Digits, String password) {
        fillPhoneNumberTextField(phoneNumber);
        fillLast4DigitsTextField(last4Digits);
        fillPasswordTextField(password);
        clickOnSendButton();
    }

    public void clickLoginToYourOnlineBankButton() {
        click(forgotUserNameScreenLocators.getLoginToYourOnlineBankButton());
    }
}
