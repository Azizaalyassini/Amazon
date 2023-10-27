package com.amazon.web.pages.AmazonPages;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class CartPageSelectors {
    // Define page elements using the @FindBy annotation

    // Element representing the "Deselect All Items" on the cart page.
    @FindBy(id = "deselect-all")
    private WebElement deselectAllItem;

    // Element representing the "Proceed to Retail Checkout" button on the cart page.
    @FindBy(name = "proceedToRetailCheckout")
    private WebElement proceedToCheckout;
}
