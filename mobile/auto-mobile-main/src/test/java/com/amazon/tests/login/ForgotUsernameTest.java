package com.amazon.tests.login;

import com.amazon.mobile.controllers.BaseTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ForgotUsernameTest extends BaseTest {

    @Test
    public void OpenForgotUsernamePageAndGoBack() {
        logStep("Click - Forgot Username link");
        screens.getLoginScreen().openForgotUserNameScreen();
        logStep("Click - Back button");
        screens.getNavigationScreen().clickBackButton();
        logStep("Verify - Login page is displayed");
        assertTrue(screens.getLoginScreen().checkLoginButtonIsDisplayed());
    }

    @Test
    public void OpenContactUsPageAndGoBack() {
        logStep("Click - Forgot Username link");
        screens.getLoginScreen().openForgotUserNameScreen();
        logStep("Click - Contact Us link");
        screens.getNavigationScreen().openContactUsScreen();
        logStep("Click - Back button");
        screens.getNavigationScreen().clickBackButton();
        logStep("Verify - Forgot Username page is displayed");
        assertTrue(screens.getForgotUserNameScreen().checkForgotUsernameTitleIsDisplayed());
    }

    @Test
    @Parameters({"phoneNumber", "last4Digits", "password", "mobileErrorMessage", "last4DigitsErrorMessage", "passwordErrorMessage"})
    public void FillForgotUsernameFormWithInvalidData(String phoneNumber, String last4Digits, String password, String mobileErrorMessage, String last4DigitsErrorMessage, String passwordErrorMessage) {
        logStep("Click - Forgot Username link");
        screens.getLoginScreen().openForgotUserNameScreen();
        logStep("Fill the Username Form with invalid data and click on Send button");
        screens.getForgotUserNameScreen().fillForgotUsernameFormAndClickSendButton(phoneNumber, last4Digits, password);
        logStep("Verify - Error messages are displayed");
        assertTrue(screens.getErrorScreen().getErrorMessageContent(mobileErrorMessage));
        assertTrue(screens.getErrorScreen().getErrorMessageContent(last4DigitsErrorMessage));
        assertTrue(screens.getErrorScreen().getErrorMessageContent(passwordErrorMessage));
    }

    @Test
    @Parameters({"phoneNumber", "last4Digits", "password"})
    public void FillForgotUsernameFormWithValidDataLoginToYourOnlineBank(String phoneNumber, String last4Digits, String password) {
        logStep("Click - Forgot Username link");
        screens.getLoginScreen().openForgotUserNameScreen();
        logStep("Fill the Username Form with valid data and click on Send button");
        screens.getForgotUserNameScreen().fillForgotUsernameFormAndClickSendButton(phoneNumber, last4Digits, password);
        logStep("Click - Login To Your Online Bank Button");
        screens.getForgotUserNameScreen().clickLoginToYourOnlineBankButton();
        logStep("Verify - Login page is displayed");
        assertTrue(screens.getLoginScreen().checkLoginButtonIsDisplayed());
    }

    @Test
    @Parameters({"phoneNumber", "last4Digits", "password"})
    public void FillForgotUsernameFormWithValidDataRedirectToLoginPage(String phoneNumber, String last4Digits, String password) {
        logStep("Click - Forgot Username link");
        screens.getLoginScreen().openForgotUserNameScreen();
        logStep("Fill the Username Form with valid data and click on Send button");
        screens.getForgotUserNameScreen().fillForgotUsernameFormAndClickSendButton(phoneNumber, last4Digits, password);
        logStep("Verify - Login page is displayed");
        assertTrue(screens.getLoginScreen().checkLoginButtonIsDisplayed());
    }
}
