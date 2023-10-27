package com.amazon.web.pages.AmazonPages;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class HomePageSelectors {

    // The Amazon logo element on the homepage.
    @FindBy(id="nav-logo-sprites")
    private WebElement amazonLogo;

    // Button to access the account list.
    @FindBy(id="nav-link-accountList")
    private WebElement AccountListButton;

    // The main card on the homepage (e.g., featured deals).
    @FindBy(id="CardInstanceFOPcBLe7YlYM1Utnsc6LDA")
    private WebElement homePageCard;

    // Menu button to access all navigation options.
    @FindBy(id="nav-hamburger-menu")
    private WebElement allMenu;

    // Button to see all menu options.
    @FindBy(xpath = "//*[@id='hmenu-content']/ul[1]/li[11]/a[1]/div")
    private WebElement seeAllButton;

    // Option to access the "Video Games" section in the menu.
    @FindBy(xpath = "//*[@id='hmenu-content']/ul[1]/ul[1]/li[19]/a")
    private WebElement videoGameButton;

    // Specific option within the "Video Games" menu section.
    @FindBy(xpath="//*[@id='hmenu-content']/ul[26]/li[3]/a")
    private WebElement videoGamesListOption;

    // Icon representing the shopping cart.
    @FindBy(id = "nav-cart-count-container")
    private WebElement myCart;
}
