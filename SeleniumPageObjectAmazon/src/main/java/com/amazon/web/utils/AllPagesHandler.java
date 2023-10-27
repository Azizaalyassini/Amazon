package com.amazon.web.utils;

import com.amazon.web.controllers.ThreadLocalDriver;
import com.amazon.web.pages.AmazonPages.*;


public class AllPagesHandler {

    public LoginPage getLoginPage() {
        return new LoginPage(ThreadLocalDriver.getTLDriver(), new LoginPageSelectors());
    }
    public HomePage gethomePage(){return  new HomePage(ThreadLocalDriver.getTLDriver(), new HomePageSelectors());}

    public AccountPage getaccountPage(){return new AccountPage(ThreadLocalDriver.getTLDriver(),new AccountPageSelectors());}

    public ProductPage getproductPage(){return new ProductPage(ThreadLocalDriver.getTLDriver(),new ProductPageSelectors());}

    public CheckoutPage getCheckoutPage(){return new CheckoutPage(ThreadLocalDriver.getTLDriver(),new CheckoutPageSelectors());}

    public CartPage getCartPage(){return new CartPage(ThreadLocalDriver.getTLDriver(),new CartPageSelectors());}
}
