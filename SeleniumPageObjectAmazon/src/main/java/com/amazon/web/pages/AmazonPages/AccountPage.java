package com.amazon.web.pages.AmazonPages;

import com.amazon.web.utils.ActionHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AccountPage extends ActionHelper {
    AccountPageSelectors accountPageSelectors;

    // Constructor for the AccountPage class.
    public AccountPage(WebDriver driver, AccountPageSelectors accountPageSelectors) {
        // Initialize the AccountPageSelectors and the associated WebDriver.
        this.accountPageSelectors = accountPageSelectors;
        PageFactory.initElements(driver, accountPageSelectors);
    }

    // Check if the account page title is displayed.
    public boolean checkIfAccountPageTitleIsDisplayed() {
        return isDisplayed(accountPageSelectors.getYourAccountPageTitle());
    }
}
