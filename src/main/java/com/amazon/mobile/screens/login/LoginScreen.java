package com.amazon.mobile.screens.login;

import com.amazon.mobile.utils.ActionHelper;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class LoginScreen extends ActionHelper {
    LoginScreenLocators loginScreenLocators;

    public LoginScreen(AppiumDriver driver, LoginScreenLocators loginScreenLocators) {
        this.loginScreenLocators = loginScreenLocators;
        PageFactory.initElements(new AppiumFieldDecorator(driver), loginScreenLocators);
    }

    public boolean checkLoginButtonIsDisplayed() {
        return isDisplayed(loginScreenLocators.getLoginButton(), 10);
    }

    public void fillUserNameTextField(String userName) {
        sendKeys(loginScreenLocators.getUserNameTextField(), userName);
    }

    public void fillPasswordTextField(String password) {
        sendKeys(loginScreenLocators.getPasswordTextField(), password);
    }

    public void clickOnLoginButton() {
        click(loginScreenLocators.getLoginButton());
        waitSpinnerToBeInvisible(2);
    }

    public void loginToSystem(String userName) {
        fillUserNameTextField(getUserCredentials(userName).get("userName").toString());
        fillPasswordTextField(getUserCredentials(userName).get("password").toString());
        clickOnLoginButton();
    }

    public void skipSplashScreen() {
        waitElementToBeVisible(loginScreenLocators.getSplashScreen(), 7);
        click(loginScreenLocators.getSplashScreen());
    }

    public void clickOnContactUsButton() {
        click(loginScreenLocators.getContactUsButton());
    }

    public void clickOnMoreButton() {
        click(loginScreenLocators.getMoreButton());
    }

    public void openBankNewsScreen() {
        click(loginScreenLocators.getBankNewsButton());
    }

    public boolean checkIfUserNameTextFieldIsDisplayed() {
        return isDisplayed(loginScreenLocators.getUserNameTextField(), 5);
    }

    public void openForgotPasswordScreen() {
        click(loginScreenLocators.getForgotPasswordButton());
    }

    public void openForgotUserNameScreen() {
        click(loginScreenLocators.getForgotUserNameButton());
    }

    public void navigateToOpenDWScreen() {
        click(loginScreenLocators.getOpenDWButton());
    }

    public void skip() {
        if (isDisplayed(loginScreenLocators.getSplashScreen(), 7)) {
            click(loginScreenLocators.getSplashScreen());
        }
    }


    public void navigateToGetOnlineBankAccess() {
        click(loginScreenLocators.getGetOnlineBankAccessButton());
    }

}
