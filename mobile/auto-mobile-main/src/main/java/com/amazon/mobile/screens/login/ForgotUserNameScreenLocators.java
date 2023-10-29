package com.amazon.mobile.screens.login;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class ForgotUserNameScreenLocators {
    @FindBy(xpath = "//ion-title[contains (text(), 'Forgot username')]")
    private WebElement ForgotUsernameTitle;
    @FindBy(id = "mobile")
    private WebElement phoneNumberTextField;
    @FindBy(id = "accountid")
    private WebElement last4DigitsTextField;
    @FindBy(xpath = "//ion-label[contains(text(),' Your password')]//following::input[@type='password']")
    private WebElement passwordTextField;
    @FindBy(id = "btn_forgot_username")
    private WebElement sendButton;
    @FindBy(id = "go-to-login-btn")
    private WebElement loginToYourOnlineBankButton;
}
