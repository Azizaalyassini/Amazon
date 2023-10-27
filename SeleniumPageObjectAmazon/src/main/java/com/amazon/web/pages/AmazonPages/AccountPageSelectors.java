package com.amazon.web.pages.AmazonPages;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class AccountPageSelectors {
    // Define and annotate a WebElement representing the your account page title.
    @FindBy(xpath = "//*[@id='a-page']/div[1]/div/div[1]")
    private WebElement yourAccountPageTitle;

}
