package com.amazon.web.pages.AmazonPages;

import com.amazon.web.utils.ActionHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage extends ActionHelper {
    CheckoutPageSelectors checkoutPageSelectors;

    public CheckoutPage(WebDriver driver, CheckoutPageSelectors checkoutPageSelectors) {
        this.checkoutPageSelectors = checkoutPageSelectors;
        // Initialize the page elements using PageFactory.
        PageFactory.initElements(driver, checkoutPageSelectors);
    }

    // Check if the checkout page is displayed by verifying the presence of a specific element (ship address).
    public boolean checkIfCartPageIsDisplayed() {
        return isDisplayed(checkoutPageSelectors.getShipAddress());
    }

    // Click on the "Add This Address" button on the checkout page.
    public void clickOnAddThisAddress() {
        click(checkoutPageSelectors.getUseThisAdressButton());
    }

    // Check if the selected address is displayed on the checkout page.
    public boolean checkIfTheSelectedAddressIsDisplayed() {
        return isDisplayed(checkoutPageSelectors.getSelectedAddress());
    }
}
