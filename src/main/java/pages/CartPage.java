package pages;

import org.openqa.selenium.By;

import base.BaseClass;
import utils.WaitHelper;

public class CartPage {

    private WaitHelper waitHelper;

    private WaitHelper getWaitHelper() {
        if (waitHelper == null) {
            waitHelper = new WaitHelper(BaseClass.driver, 15);
        }
        return waitHelper;
    }

    // ==============================
    // LOCATORS
    // ==============================

    By checkoutButton =
        By.xpath("//button[@class='button']");

    By cancelPaymentYesButton =
        By.xpath("//button[@class='yes-btn svelte-hks3kw']");

    By homepageLogo =
        By.xpath("//img[@class='header__sticky-logo bee-d-none bee-d-none']");


    // ==============================
    // ACTION METHODS
    // ==============================

    // Remove product dynamically by name
    public void removeProduct1(String productName) {
        By removeButton = By.xpath(
            "(//a[@data-cart-remove])[1]");
        getWaitHelper().safeClick(removeButton);
        System.out.println("Removed Product: " + productName);
    }
    
    public void removeProduct2(String productName) {
        By removeButton = By.xpath(
            "(//a[@data-cart-remove])[1]");
        getWaitHelper().safeClick(removeButton);
        System.out.println("Removed Product: " + productName);
    }
    
    public void removeProduct3(String productName) {
        By removeButton = By.xpath(
            "(//a[@data-cart-remove])");
        getWaitHelper().safeClick(removeButton);
        System.out.println("Removed Product: " + productName);
    }

    // Click Checkout
    public void clickCheckout() {

        getWaitHelper().jsClick(checkoutButton);

        System.out.println("Clicked Checkout");
    }

    // Browser Back
    public void clickBackButton() {
        BaseClass.driver.navigate().back();
        System.out.println("Clicked Browser Back Button");
    }

    // Cancel Payment Popup — Yes
    public void clickYesToCancelPayment() {
        getWaitHelper().jsClick(cancelPaymentYesButton);
        System.out.println("Cancelled Payment Popup");
    }

    // Click Homepage Logo
    
    public void goToHomepage() {

        BaseClass.driver.get(
            "https://fullyfilmy.in/");

        System.out.println(
            "Navigated To Homepage");
    }

    // Verify back on homepage
    public boolean verifyHomepage() {
        String actualURL = BaseClass.driver.getCurrentUrl();
        return actualURL.equals("https://fullyfilmy.in/");
    }
}