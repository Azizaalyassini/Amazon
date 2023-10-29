package com.amazon.tests.login;

import com.amazon.mobile.controllers.BaseTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class ShowAndHidePasswordTest extends BaseTest {
    @Test
    @Parameters({"password"})
    public void checkTheEyeIconForLoginScreen(String password) {
        logStep("Fill password text field");
        screens.getLoginScreen().fillPasswordTextField(password);
        logStep("Tap on show password button");
        screens.getShowHidePasswordScreen().tapOnShowPassword();
        logStep("Check if show hide password appears");
        assertTrue(screens.getShowHidePasswordScreen().checkIfHidePasswordIsDisplayed());
    }

    @Test
    @Parameters({"password"})
    public void checkTheEyeIconForForgotUsername(String password) {
        logStep("Navigate to Forgot Username screen");
        screens.getLoginScreen().openForgotUserNameScreen();
        logStep("Fill password to make eye icon to display");
        screens.getForgotUserNameScreen().fillPasswordTextField(password);
        logStep("Tap on show password button");
        screens.getShowHidePasswordScreen().tapOnShowPassword();
        logStep("Check if show hide password appears");
        assertTrue(screens.getShowHidePasswordScreen().checkIfHidePasswordIsDisplayed());
    }

    @Test
    @Parameters({"firstName", "lastName", "email", "confirmEmail", "mobileNumber", "password"})
    public void checkTheEyeIconForOpenDigitalWallet(String firstName, String lastName, String email, String confirmEmail, String mobileNumber, String password) {
        logStep("Navigate open Digital Wallet screen");
        screens.getLoginScreen().navigateToOpenDWScreen();
        logStep("open digital wallet form");
        screens.getOpenDWScreen().navigateToOpenDW();
        logStep("Fill all the fields and tap Next");
        screens.getOpenDWScreen().fillUserDetailsForm(firstName, lastName, email, confirmEmail, mobileNumber);
        logStep("Fill the password field");
        screens.getOpenDWScreen().fillPassword(password);
        logStep("Tap on show password button");
        screens.getShowHidePasswordScreen().tapOnShowPassword();
        logStep("Check if show hide password appears");
        assertTrue(screens.getShowHidePasswordScreen().checkIfHidePasswordIsDisplayed());
    }

    @Test
    @Parameters({"yourName", "cardNumber", "code", "password"})
    public void checkTheEyeIconForYourBankCard(String yourName, String cardNumber, String code, String password) {
        logStep("Navigate to Get Online Bank Access");
        screens.getLoginScreen().navigateToGetOnlineBankAccess();
        logStep("Open Your Bank Card");
        screens.getGetOnlineBankAccessScreen().openYourBankCardScreen();
        logStep("Fill Your details card screen");
        screens.getYourBankCardScreen().fillCardDetailsFormThenNext(yourName, cardNumber, code);
        logStep("Fill the password field");
        screens.getYourBankCardScreen().fillPassword(password);
        logStep("Tap on show password button");
        screens.getShowHidePasswordScreen().tapOnShowPassword();
        logStep("Check if show hide password appears");
        assertTrue(screens.getShowHidePasswordScreen().checkIfHidePasswordIsDisplayed());
    }

    @Test
    @Parameters({"accountName", "accountNumber", "code", "password"})
    public void checkTheEyeIconForYourBankAccount(String accountName, String accountNumber, String code, String password) {
        logStep("Navigate to Get Online Bank Access");
        screens.getLoginScreen().navigateToGetOnlineBankAccess();
        logStep("Open Your Bank Account");
        screens.getGetOnlineBankAccessScreen().openYourBankAccountScreen();
        logStep("Fill Your details account screen");
        screens.getYourBankAccountScreen().fillAccountDetailsForm(accountName, accountNumber, code);
        logStep("Fill the password field");
        screens.getYourBankAccountScreen().fillPassword(password);
        logStep("Tap on show password button");
        screens.getShowHidePasswordScreen().tapOnShowPassword();
        logStep("Check if show hide password appears");
        assertTrue(screens.getShowHidePasswordScreen().checkIfHidePasswordIsDisplayed());
    }

    @Test
    @Parameters({"code"})
    public void checkTheEyeIconForPassportRegistration(String code) {
        logStep("Navigate to Get Online Bank Access");
        screens.getLoginScreen().navigateToGetOnlineBankAccess();
        logStep("Open Passport screen");
        screens.getGetOnlineBankAccessScreen().openPassportScreen();
        logStep("Fill The secret code text field");
        screens.getPassportScreen().fillSecretCode(code);
        logStep("Tap on show password button");
        screens.getShowHidePasswordScreen().tapOnShowPassword();
        logStep("Check if show hide password appears");
        assertTrue(screens.getShowHidePasswordScreen().checkIfHidePasswordIsDisplayed());
    }

    @Test
    @Parameters({"firstName", "lastName", "email", "confirmEmail", "mobileNumber", "password"})
    public void checkTheEyeIconForOpenAccount(String firstName, String lastName, String email, String confirmEmail, String mobileNumber, String password) {
        logStep("Navigate to Get Online Bank Access");
        screens.getLoginScreen().navigateToGetOnlineBankAccess();
        logStep("Open open an account screen");
        screens.getGetOnlineBankAccessScreen().openOpenAnAccountScreen();
        logStep("Fill your details screen");
        screens.getOpenAccountScreen().fillUserDetailsScreen(firstName, lastName, email, confirmEmail, mobileNumber);
        logStep("Fill the password field");
        screens.getOpenAccountScreen().fillPassword(password);
        logStep("Tap on show password button");
        screens.getShowHidePasswordScreen().tapOnShowPassword();
        logStep("Check if show hide password appears");
        assertTrue(screens.getShowHidePasswordScreen().checkIfHidePasswordIsDisplayed());
    }

    @Test
    @Parameters({"userName", "tabTitle", "password"})
    public void checkEyeIconForChangeThePasswordSettings(String userName, String tabTitle, String password) {
        logStep("Login To System With " + userName + " Username");
        screens.getLoginScreen().loginToSystem(userName);
        logStep("Click on close Button");
        screens.getDigitalWalletAdScreen().clickOnCloseModalButton();
        logStep("Navigate to Login And Password from Settings");
        navigateToLoginAndPasswordSettings(tabTitle);
        logStep("fill the current password field");
        screens.getLoginAndPasswordScreen().fillCurrentPassword(password);
        logStep("Tap on show password button");
        screens.getShowHidePasswordScreen().tapOnShowPassword();
        logStep("Check if show hide password appears");
        assertTrue(screens.getShowHidePasswordScreen().checkIfHidePasswordIsDisplayed());
        logStep("fill the new password field");
        screens.getLoginAndPasswordScreen().fillNewPassword(password);
        logStep("Tap on show password button");
        screens.getShowHidePasswordScreen().tapOnShowPassword();
        logStep("Check if show hide password appears");
        assertTrue(screens.getShowHidePasswordScreen().checkIfHidePasswordIsDisplayed());
        logStep("fill the confirm password field");
        screens.getLoginAndPasswordScreen().fillConfirmNewPassword(password);
        logStep("Tap on show password button");
        screens.getShowHidePasswordScreen().tapOnShowPassword();
        logStep("Check if show hide password appears");
        assertTrue(screens.getShowHidePasswordScreen().checkIfHidePasswordIsDisplayed());
    }

    public void navigateToLoginAndPasswordSettings(String tabTitle) {
        logStep("Open profile menu");
        screens.getNavigationScreen().openProfileMenu();
        logStep("Open setting menu");
        screens.getProfileMenuScreen().clickSettings();
        logStep("Go to Login and password");
        screens.getSettingMenuScreen().swipeToTab(tabTitle);
    }
}
