package com.amazon.tests.login;

import com.amazon.mobile.controllers.BaseTest;
import com.amazon.mobile.utils.ActionHelper;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ForgotPasswordTest extends BaseTest {

    @Test
    @Parameters({"userName", "last4Digits", "phoneNumber", "successMessage"})
    public void forgotPasswordOnlineBanking(String userName, String last4Digits, String phoneNumber, String successMessage) {
        openForgotPasswordOnlineBanking();
        logStep("Fill Forgot Password Form And Tap on Next");
        screens.getForgotPasswordScreen().forgotPasswordOnlineBanking(userName, phoneNumber, last4Digits);
        logStep("Assert Success Message");
        assertEquals(screens.getForgotPasswordScreen().getForgotPasswordSuccessMessage(), successMessage);
    }

    @Test
    public void forgotPasswordWithEmptyFormOnlineBanking() {
        openForgotPasswordOnlineBanking();
        logStep("Check If Next Button Disabled");
        assertTrue(screens.getForgotPasswordScreen().checkIfNextButtonDisabled());
    }

    @Test
    @Parameters({"userName", "last4Digits", "phoneNumber", "errorMessage"})
    public void forgotPasswordWithInvalidDataOnlineBanking(String userName, String last4Digits, String phoneNumber, String errorMessage) {
        openForgotPasswordOnlineBanking();
        logStep("Fill Forgot Password Form And Tap on Next");
        screens.getForgotPasswordScreen().forgotPasswordOnlineBanking(userName, phoneNumber, last4Digits);
        logStep("Assert Success Message");
        assertEquals(screens.getErrorScreen().getErrorMessage(), errorMessage);
    }

    @Test
    @Parameters({"userName", "phoneNumber", "OTPMessage"})
    public void forgotPasswordDW(String userName, String phoneNumber, String OTPMessage) {
        openToForgotPasswordDW();
        logStep("Fill Forgot Password Form And Tap on Next");
        screens.getForgotPasswordScreen().forgotPasswordDW(userName + ActionHelper.generateTimeStamp(), phoneNumber);
        logStep("Assert OTP Popup");
        assertEquals(screens.getAlertScreen().getAlertPopUpContent(), OTPMessage);
    }

    @Test
    public void forgotPasswordWithEmptyFormDW() {
        openToForgotPasswordDW();
        logStep("Check If Next Button Disabled");
        assertTrue(screens.getForgotPasswordScreen().checkIfNextButtonDisabled());
    }

    @Test
    @Parameters({"userName", "phoneNumber", "OTPMessage"})
    public void checkSendNewCode(String userName, String phoneNumber, String OTPMessage) {
        openToForgotPasswordDW();
        logStep("Fill Forgot Password Form And Tap on Next");
        screens.getForgotPasswordScreen().forgotPasswordDW(userName + ActionHelper.generateTimeStamp(), phoneNumber);
        logStep("Assert OTP Popup");
        assertEquals(screens.getAlertScreen().getAlertPopUpContent(), OTPMessage);
        logStep("Click on Send New Code Button");
        screens.getForgotPasswordScreen().clickOnSendNewCode();
        logStep("Assert OTP Popup");
        assertEquals(screens.getAlertScreen().getAlertPopUpContent(), OTPMessage);
    }

    @Test
    public void checkContactUsScreenFormDW() {
        openToForgotPasswordDW();
        logStep("Open Contact Us Screen");
        screens.getNavigationScreen().openContactUsScreen();
        logStep("Check If Contact Us Screen Opened");
        assertTrue(screens.getContactUsScreen().checkIfCallByPhoneButtonIsDisplayed());
    }

    public void openForgotPasswordOnlineBanking() {
        logStep("Open Forgot Password Screen");
        screens.getLoginScreen().openForgotPasswordScreen();
        logStep("Open Forgot Password Online Banking Screen");
        screens.getForgotPasswordScreen().openOnlineBanking();
    }

    public void openToForgotPasswordDW() {
        logStep("Open Forgot Password Screen");
        screens.getLoginScreen().openForgotPasswordScreen();
        if(System.getProperty("appType").equals("retail")) {
            logStep("Open Forgot Password DW Screen");
            screens.getForgotPasswordScreen().openForgotPasswordDW();
        }
    }
}
