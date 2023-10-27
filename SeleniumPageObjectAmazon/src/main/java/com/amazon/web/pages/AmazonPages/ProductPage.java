package com.amazon.web.pages.AmazonPages;

import com.amazon.web.controllers.ThreadLocalDriver;
import com.amazon.web.utils.ActionHelper;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class ProductPage extends ActionHelper {
    ProductPageSelectors productPageSelectors;
    List<String> productURLs = new ArrayList<>();

    public ProductPage(WebDriver driver, ProductPageSelectors productPageSelectors) {
        this.productPageSelectors = productPageSelectors;
        PageFactory.initElements(driver, productPageSelectors);
    }

    public String checkIfVideoGamePageIsDisplayed() {
        // Check if the video game page description is displayed
        waitElementToBeVisible(productPageSelectors.getVideoGamePageDescription(), 5);
        return getText(productPageSelectors.getVideoGamePageDescription());
    }

    public void clickOnXboxCheckBoxFilter() {
        // Click on the Xbox checkbox filter
        waitElementToBeVisible(productPageSelectors.getXboxFilter(), 5);
        click(productPageSelectors.getXboxFilter());
    }

    public void clickOnSortBy() {
        // Click on the "Sort By" button
        waitElementToBeVisible(productPageSelectors.getSortByButton(), 5);
        click(productPageSelectors.getSortByButton());
    }

    public void clickOnHighToLow() {
        // Click on the "High to Low" option for sorting
        click(productPageSelectors.getHighToLow());
    }

    public void sortProductFromTheHighestPriceToTheLowestPrice() {
        // Sort the products from highest to lowest price
        clickOnSortBy();
        clickOnHighToLow();
    }

    public void clickOnAllProductInTheList() {
        // Click on products in the list if their price is less than or equal to 15000
        List<WebElement> productPrice = productPageSelectors.getProductPrice();

        int size = productPrice.size();
        int i;
        for (i = 0; i < size; i++) {
            WebElement productElement = productPrice.get(i);
            int priceValue = Integer.parseInt(productElement.getText().replace(",", ""));
            if (priceValue <= 15000) {
                Actions action = new Actions(ThreadLocalDriver.getTLDriver());
                action.keyDown(Keys.CONTROL).click(productElement).keyUp(Keys.CONTROL).build().perform();
            }
        }
    }

    public void moveToProductAndAddToCart() {
        // Move to the product and add it to the cart
        for (int tab = 1; tab <= countTabs(); tab++) {
            switchToTabByIndex(tab);
            if (isElementExist(productPageSelectors.getAddToCart(), 5)) {
                click(productPageSelectors.getAddToCart());
            }
        }
    }
}
