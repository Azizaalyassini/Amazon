package com.amazon.mobile.screens.login;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class LoginScreenLocators {
    @FindBy(xpath = "//input[@type='text']")
    private WebElement userNameTextField;

    @FindBy(xpath = "//input[@type='password']")
    private WebElement passwordTextField;

    @FindBy(id = "login-btn")
    private WebElement loginButton;

    @FindBy(xpath = "/html/body/app-root/ion-app")
    private WebElement splashScreen;

    @FindBy(xpath = "//p[contains(text(),'Your Username is')]")
    private WebElement userNameErrorMessage;

    @FindBy(xpath = "//p[contains(text(),'Your Password is')]")
    private WebElement passwordErrorMessage;

    @FindBy(id = "menu-option-contact-us-component")
    private WebElement ContactUsButton;

    @FindBy(xpath = "//p[contains(text(),'More')]")
    private WebElement moreButton;

    @FindBy(xpath = "//p[contains(text(), 'Bank News')]")
    private WebElement bankNewsButton;

    @FindBy(linkText = "Username")
    private WebElement forgotUserNameButton;

    @FindBy(linkText = "Password")
    private WebElement forgotPasswordButton;

    @FindBy(xpath = "//*[contains(text(),'Open Digital Wallet')]")
    private WebElement openDWButton;

    @FindBy(xpath = "//app-splash-screen")
    private WebElement splash;

    @FindBy(id = "register-btn")
    private WebElement getOnlineBankAccessButton;

}
