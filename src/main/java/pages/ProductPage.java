package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import base.BaseClass;
import utils.WaitHelper;

public class ProductPage {

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

    By oversizedTees =
        By.xpath("//*[contains(text(),'Oversized Tees')]");

    By addToCartButton =
        By.xpath("//button[@name='add']");

    By closeCartPopup =
        By.xpath("//button[@class='bee-drawer__close']");

    By shopDropdown =
        By.xpath("//a[contains(text(),'Shop')]");

    By searchIcon =
        By.xpath("//span[normalize-space()='Search our store']");

    By searchBox =
        By.xpath("//input[@placeholder='What are you looking for?']");

    By metalPosterCategory =
        By.xpath("//a[normalize-space()='Metal Poster']");

    By quantityIncreaseButton =
        By.xpath("(//button[@data-increase-qty])[1]");

    By quantityDecreaseButton =
    	    By.xpath("(//button[@data-decrease-qty])[1]");

    	By viewCartButton =
    	    By.xpath("//*[contains(text(),'View cart') or contains(text(),'View Cart')]");

    // ==============================
    // ACTION METHODS
    // ==============================

    public void clickOversizedTees() {
        getWaitHelper().safeClick(oversizedTees);
        System.out.println("Clicked Oversized Tees");
    }

 // Single dynamic method — covers nav links AND search result cards
    public void selectProduct1(String productName) {
        // Try anchor tag first, then any element containing the text
        By product = By.xpath(
            "//a[contains(text(),'Confident Ah Irunga Oversized T-Shirt')]");
        getWaitHelper().safeClick(product);
        System.out.println("Selected Product: " + productName);
    }

    public void selectProduct2(String productName) {
        // Try anchor tag first, then any element containing the text
        By product = By.xpath(
            "//a[contains(text(),'Fully Broke Full Sleeve T-Shirt')]");
        getWaitHelper().safeClick(product);
        System.out.println("Selected Product: " + productName);
    }
    
    public void selectProduct3(String productName) {
        // Try anchor tag first, then any element containing the text
        By product = By.xpath(
            "//a[contains(text(),'Man With A Plan Metal Poster')]");
        getWaitHelper().safeClick(product);
        System.out.println("Selected Product: " + productName);
    }
    
    public void selectSize(String size) {
        By productSize = By.xpath(
            "//div[@data-value='" + size + "']");
        getWaitHelper().safeClick(productSize);
        System.out.println("Selected Size: " + size);
    }

    public void clickAddToCart() {
        getWaitHelper().safeClick(addToCartButton);
        System.out.println("Clicked Add To Cart");
    }

    public void closeCartPopup() {
        getWaitHelper().safeClick(closeCartPopup);
        System.out.println("Closed Cart Popup");
    }

    public void clickShopDropdown() {
        Actions action = new Actions(BaseClass.driver);
        action.moveToElement(
            getWaitHelper().waitForVisibility(shopDropdown))
            .perform();
        System.out.println("Hovered On Shop Dropdown");
    }

    public void selectCollection(String collectionName) {
        By collection = By.xpath(
            "//a[normalize-space()='" + collectionName + "']");
        getWaitHelper().safeClick(collection);
        System.out.println("Selected Collection: " + collectionName);
    }

    public void clickSearchIcon() {
        getWaitHelper().safeClick(searchIcon);
        System.out.println("Clicked Search Icon");
    }

    // Click Metal Poster category in search dropdown
    public void clickMetalPosterCategory() {
        getWaitHelper().safeClick(metalPosterCategory);
        System.out.println("Clicked Metal Poster Category");
    }

    public void searchProduct(String productName) {
        getWaitHelper().safeType(searchBox, productName);
        System.out.println("Searched Product: " + productName);
    }

    public void increaseQuantity() {
        getWaitHelper().safeClick(quantityIncreaseButton);
        System.out.println("Increased Product Quantity");
    }

    // Reduce quantity back to 1
    public void reduceQuantity() {
        getWaitHelper().safeClick(quantityDecreaseButton);
        System.out.println("Reduced Product Quantity");
    }
    
    // Click View Cart button in the cart popup
    public void clickViewCart() {
        getWaitHelper().jsClick(viewCartButton);
        System.out.println("Clicked View Cart");
    }
}