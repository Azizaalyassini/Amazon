package com.amazon.web.pages.AmazonPages;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class CheckoutPageSelectors {
    // Define page elements using the @FindBy annotation

    // Element representing the shipping address on the checkout page.
    @FindBy(id = "shipaddress")
    private WebElement shipAddress;

    // Element representing the "Add New Address" link.
    @FindBy(id = "add-new-address-popover-link")
    private WebElement addAddress;

    // Element representing the "Auto Fill Address" button.
    @FindBy(id = "address-ui-widgets-DetectLocationButton-announce")
    private WebElement autoFillAddress;

    // Element representing the "Use This Address" button.
    @FindBy(id = "address-ui-widgets-form-submit-button")
    private WebElement useThisAdressButton;

    // Element representing the input field for the first name.
    @FindBy(id = "address-ui-widgets-enterAddressFullName")
    private WebElement firstName;

    // Element representing the input field for the phone number.
    @FindBy(id = "address-ui-widgets-enterAddressPhoneNumber")
    private WebElement phoneNumber;

    // Element representing the "Save Address" button.
    @FindBy(name = "address-ui-widgets-saveOriginalOrSuggestedAddress")
    private WebElement saveAddressButton;

    // Element representing the selected address on the checkout page.
    @FindBy(id = "shipaddress")
    private WebElement selectedAddress;
}
