package com.amazon.web.pages.AmazonPages;

import com.amazon.web.utils.ActionHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends ActionHelper {
    HomePageSelectors homePageSelectors;

    public HomePage(WebDriver driver, HomePageSelectors homePageSelectors) {
        this.homePageSelectors = homePageSelectors;
        PageFactory.initElements(driver, homePageSelectors);
    }

    // Click on the Amazon logo to go to the homepage.
    public void clickGoToHomePage() {
        click(homePageSelectors.getAmazonLogo());
    }

    // Click on the "All" menu to expand the navigation menu.
    public void clickOnAllMenu() {
        waitElementToBeVisible(homePageSelectors.getAllMenu(), 5);
        click(homePageSelectors.getAllMenu());
    }

    // Click on the "See More" button to see additional options.
    public void clickOnSeeMore() {
        waitElementToBeVisible(homePageSelectors.getSeeAllButton(), 10);
        forceClick(homePageSelectors.getSeeAllButton());
    }

    // Click on the "Video Games" option in the menu.
    public void clickOnVideoGameOption() {
        waitElementToBeVisible(homePageSelectors.getVideoGameButton(), 10);
        click(homePageSelectors.getVideoGameButton());
    }

    // Click on a specific video game option within the video game list.
    public void clickOnVideoGameOptionInTheVideoGameList() {
        waitElementToBeVisible(homePageSelectors.getVideoGamesListOption(), 10);
        click(homePageSelectors.getVideoGamesListOption());
    }

    // Open the "Video Games" section by clicking through the menu options.
    public void openVideoGames() {
        clickOnAllMenu();
        clickOnSeeMore();
        clickOnVideoGameOption();
        clickOnVideoGameOptionInTheVideoGameList();
    }

    // Click on the shopping cart icon.
    public void clickOnCart() {
        click(homePageSelectors.getMyCart());
    }
}
