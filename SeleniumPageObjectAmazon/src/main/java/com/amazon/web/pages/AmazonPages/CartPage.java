package com.amazon.web.pages.AmazonPages;

import com.amazon.web.utils.ActionHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends ActionHelper {
    CartPageSelectors cartPageSelectors;

    public CartPage(WebDriver driver, CartPageSelectors cartPageSelectors) {
        this.cartPageSelectors = cartPageSelectors;
        // Initialize the page elements using PageFactory.
        PageFactory.initElements(driver, cartPageSelectors);
    }

    // Check if the cart page is displayed by verifying the presence of a specific element.
    public boolean checkIfCartPageIsDisplayed() {
        return isDisplayed(cartPageSelectors.getDeselectAllItem());
    }

    // Click on the "Proceed to Payment" button on the cart page.
    public void clickOnProceedToPayment() {
        click(cartPageSelectors.getProceedToCheckout());
    }
}
