package com.amazon.tests.login;

import com.amazon.mobile.controllers.BaseTest;
import com.amazon.mobile.utils.ActionHelper;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {


    @Test
    @Parameters({"userName"})
    public void loginToSystem(String userName) {
        logStep("Login To System With " + userName + " Username");
        screens.getLoginScreen().loginToSystem(userName);
        logStep("Open profile menu");
        screens.getNavigationScreen().openProfileMenu();
        logStep("Click logout");
        screens.getProfileMenuScreen().clickLogout();
    }

    @Test
    @Parameters({"userName", "password", "userNameErrorMessage", "passwordErrorMessage", "invalidCredentialErrorMessage"})
    public void loginNegativeCases(@Optional("") String userName, @Optional("") String password, @Optional("") String userNameErrorMessage, @Optional("") String passwordErrorMessage, @Optional("") String invalidCredentialErrorMessage) {
        logStep("Try To Login Without Username and password");
        if (!userName.equals("")) {
            userName="test"+ ActionHelper.generateTimeStamp();
        }
        screens.getLoginScreen().fillUserNameTextField(userName);
        screens.getLoginScreen().fillPasswordTextField(password);
        screens.getLoginScreen().clickOnLoginButton();
        if (userName.equals("")) {
            logStep("Check If Username Error Message Is Displayed");
            assertTrue(screens.getErrorScreen().getErrorMessageContent(userNameErrorMessage));
        }
        if (password.equals("")) {
            logStep("Check If Password Error Message Is Displayed");
            assertTrue(screens.getErrorScreen().getErrorMessageContent(passwordErrorMessage));
        }
        if (!password.equals("") && !userName.equals("")) {
            logStep("Check If Invalid Credentials Is Displayed");
            assertEquals(screens.getAlertScreen().getAlertPopUpContent(), invalidCredentialErrorMessage);
        }

    }

    @Test
    @Parameters({"userName"})
    public void loginWithCaptcha(String userName) {
        logStep("Login To System With incorrect details");
        screens.getLoginScreen().loginToSystem(userName);
        logStep("Login To System With correct details " + userName + " Username");
        screens.getLoginScreen().loginToSystem(userName);
        logStep("Enter Captcha");
        logStep("Open profile menu");
        screens.getNavigationScreen().openProfileMenu();
        logStep("Click logout");
        screens.getProfileMenuScreen().clickLogout();
    }
}
