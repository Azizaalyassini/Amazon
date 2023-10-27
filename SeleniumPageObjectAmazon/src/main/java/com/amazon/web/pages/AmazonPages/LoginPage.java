package com.amazon.web.pages.AmazonPages;

import com.amazon.web.utils.ActionHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends ActionHelper {
    LoginPageSelectors loginPageSelectors;

    public LoginPage(WebDriver driver, LoginPageSelectors loginPageSelectors) {
        this.loginPageSelectors = loginPageSelectors;
        PageFactory.initElements(driver, loginPageSelectors);
    }

    // Fill the email input field on the login page.
    public void fillEmail(String email) {
        sendKeys(loginPageSelectors.getEmail(), email);
    }

    // Fill the password input field on the login page.
    public void fillPassword(String password) {
        sendKeys(loginPageSelectors.getPassword(), password);
    }

    // Click on the "Continue" button on the login page.
    public void clickOnContinueButton() {
        click(loginPageSelectors.getContinueButton());
    }

    // Click on the "Login" button to submit login credentials.
    public void clickOnLoginButton() {
        click(loginPageSelectors.getSignInButton());
    }

    // Fill email, click "Continue," fill password, and click "Login" in one step.
    public void loginToSystem(String email, String password) {
        fillEmail(email);
        clickOnContinueButton();
        fillPassword(password);
        clickOnLoginButton();
    }
}
