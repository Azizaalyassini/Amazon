package com.amazon.mobile.screens.login;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class ForgotPasswordScreenLocators {
    @FindBy(id = "reset-password-by-sms")
    private WebElement onlineBankingButton;
    @FindBy(id = "reset-password-by-card")
    private WebElement digitalWalletButton;
    @FindBy(xpath = "//input[@placeholder='+1 234 567 890']")
    private WebElement phoneNumberTextField;
    @FindBy(xpath = "//input[@placeholder='1234']")
    private WebElement last4DigitsTextField;
    @FindBy(xpath = "//input[@placeholder='John Wick']")
    private WebElement userNameTextField;
    @FindBy(xpath = "//ion-button[contains(text(),'Next')]")
    private WebElement nextButton;
    @FindBy(xpath = "//p[contains(text(),'Your temporary password')]")
    private WebElement successMessage;

    @FindBy(xpath = "//ion-button[contains(text(),'new code')]")
    private WebElement sendNewCode;
}
