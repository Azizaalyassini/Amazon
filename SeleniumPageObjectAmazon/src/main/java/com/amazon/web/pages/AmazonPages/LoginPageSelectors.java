package com.amazon.web.pages.AmazonPages;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class LoginPageSelectors {
    // Web elements on the Amazon login page

    @FindBy(id="ap_email")
    private WebElement email;

    @FindBy(id="continue")
    private WebElement continueButton;

    @FindBy(id="ap_password")
    private WebElement password;

    @FindBy(id="signInSubmit")
    private WebElement signInButton;

    @FindBy(id="authportal-main-section")
    private WebElement signInPage;
}
