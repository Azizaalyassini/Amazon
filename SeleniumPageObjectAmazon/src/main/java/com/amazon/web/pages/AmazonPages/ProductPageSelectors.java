package com.amazon.web.pages.AmazonPages;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@Getter
public class ProductPageSelectors {

    @FindBy(xpath = "//*[contains(text(),'Shop video games for Nintendo, PlayStation, Xbox and more')]")
    private WebElement videoGamePageDescription;

    @FindBy(xpath = "//*[@id='apb-browse-refinements-checkbox_8']")
    private WebElement XboxFilter;

    @FindBy(id="s-result-sort-select")
    private WebElement sortByButton;

    @FindBy(id = "s-result-sort-select_2")
    private WebElement highToLow;

    @FindBy(id = "high-price")
    private WebElement maximumPrice;

    @FindBy(id="a-autoid-1")
    private WebElement goButton;

    @FindBy(css="div.s-result-item")
    private  List<WebElement> result;

    @FindBy(css = "span.a-price-whole")
    private List<WebElement> productPrice;

    @FindBy(xpath="//span[@class='a-size-medium a-color-base a-text-normal']")
    private List<WebElement> productTitle;

    @FindBy(xpath = "//*[@id='submit.add-to-cart']")
    private WebElement addToCart;

    @FindBy(xpath = "//*[@aria-label='Go to next page, page 2']")
    private WebElement nextPage;
}