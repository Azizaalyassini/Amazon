package com.amazon.web.tests.user.login;

import com.amazon.web.controllers.BaseTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {


    @Test
    @Parameters({"email", "password", "text","maximumPrice"})
    public void addVideoGamesToTheCart(String email, String password,String text,int maximumPrice) {
        logger.logStep("Login To System With Valid Username & Password");
        pages.getLoginPage().loginToSystem(email, password);
        logger.logStep("Make sure that we are on home page");
        assertTrue(pages.getaccountPage().checkIfAccountPageTitleIsDisplayed());
        logger.logStep("Open VideoGames Page");
        pages.gethomePage().openVideoGames();
        logger.logStep("Check if video Games page is displayed");
        assertEquals(pages.getproductPage().checkIfVideoGamePageIsDisplayed(),text);
        logger.logStep("Click On playstation filter");
        pages.getproductPage().clickOnXboxCheckBoxFilter();
        logger.logStep("sort the product based on price from High to low");
        pages.getproductPage().sortProductFromTheHighestPriceToTheLowestPrice();
        logger.logStep("Filter product to view less only product that less than 15k");
        pages.getproductPage().clickOnAllProductInTheList();
        logger.logStep("Add iteam to the cart and make sure it's added");
        pages.getproductPage().moveToProductAndAddToCart();
        logger.logStep("click On cart");
        pages.gethomePage().clickOnCart();
        assertTrue(pages.getCartPage().checkIfCartPageIsDisplayed());
        logger.logStep("Click on proceed tp payment");
        pages.getCartPage().clickOnProceedToPayment();
        logger.logStep("Check if the checkoutPage is displayed");
        assertTrue(pages.getCheckoutPage().checkIfCartPageIsDisplayed());
        logger.logStep("Choose address");
        pages.getCheckoutPage().clickOnAddThisAddress();
        assertTrue(pages.getCheckoutPage().checkIfTheSelectedAddressIsDisplayed());
    }
}
