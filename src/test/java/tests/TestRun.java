package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.CartPage;
import pages.HomePage;
import pages.ProductPage;

public class TestRun extends BaseClass {

    HomePage    home    = new HomePage();
    ProductPage product = new ProductPage();
    CartPage    cart    = new CartPage();


    // Test 1 — Verify Homepage
    @Test(priority = 1)
    public void verifyHomepage() {
        System.out.println("Verifying Homepage...");
        Assert.assertTrue(home.verifyURL());
        Assert.assertTrue(home.verifyLogo());
        System.out.println("Homepage Verified Successfully");
    }


    // Test 2 — Add Oversized T-Shirt
    @Test(priority = 2)
    public void addOversizedTshirt() throws InterruptedException {

        // Click Oversized Tees from nav
        product.clickOversizedTees();
        Thread.sleep(3000); // collection page load

        // Find and click the product
        product.selectProduct1("Confident Ah Irunga Oversized T-Shirt");
        Thread.sleep(2000); // product page load

        // Select size and add to cart
        product.selectSize("L");
        Thread.sleep(1000);
        
        product.clickAddToCart();

        // Close cart popup
        product.closeCartPopup();

        System.out.println("First Product Added Successfully");
    }


    // Test 3 — Add Full Sleeve T-Shirt
    @Test(priority = 3)
    public void addFullSleeveTshirt() throws InterruptedException {

        // Hover Shop dropdown
        product.clickShopDropdown();

        // Select Full Sleeve T-Shirts collection
        product.selectCollection("Full Sleeve T-Shirts");
        Thread.sleep(2000); // collection page load

        // Find and click the product
        product.selectProduct2("Fully Broke Full Sleeve T-Shirt");
        Thread.sleep(2000); // product page load

        // Select size and add to cart
        product.selectSize("L");
        Thread.sleep(1000);
        product.clickAddToCart();

        // Close cart popup
        product.closeCartPopup();

        System.out.println("Second Product Added Successfully");
    }


 // Test 4 — Add Metal Poster via Search
    @Test(priority = 4)
    public void addMetalPoster() throws InterruptedException {

        // Click search icon
        product.clickSearchIcon();
        Thread.sleep(1000);

        // Type product name into search box
        product.searchProduct("Man With A Plan Metal Poster");
        Thread.sleep(2000); // wait for search results to appear

        // Click the product from search results
        product.selectProduct3("Man With A Plan Metal Poster");
        Thread.sleep(2000); // product page load

        // Select size A3
        product.selectSize("A3");
        Thread.sleep(1000);

        // Increase quantity to 2
        product.increaseQuantity();
        Thread.sleep(1000);

        // Add to cart
        product.clickAddToCart();
        Thread.sleep(2000);
        
        System.out.println("Third Product Added to Cart");

        // Reduce quantity back to 1 inside cart popup
        //product.reduceQuantity();
        //Thread.sleep(1000);

        // Click View Cart to load cart page
        product.clickViewCart();
        Thread.sleep(2000);

        System.out.println("Cart Page Loaded");
    }


    // Test 5 — Cart Operations
    @Test(priority = 5)
    public void cartOperations() throws InterruptedException {

        // Remove Full Sleeve T-Shirt
        cart.removeProduct1("Man With A Plan Metal Poster");
        Thread.sleep(4000);

        // Click Checkout
        //cart.clickCheckout();
        //Thread.sleep(8000); // checkout page load

        // Click browser back
        //cart.clickBackButton();
        //Thread.sleep(5000);

        // Click Yes to cancel payment in popup
        //cart.clickYesToCancelPayment();
        //Thread.sleep(4000);

        // Remove Metal Poster
        cart.removeProduct2("Fully Broke Full Sleeve T-Shirt");
        Thread.sleep(5000);

        // Remove Oversized T-Shirt
        cart.removeProduct3("Confident Ah Irunga Oversized T-Shirt");
        Thread.sleep(5000);

        // Click homepage logo
        cart.goToHomepage();
        Thread.sleep(2000);

        // Verify back on homepage
        Assert.assertTrue(cart.verifyHomepage());
        System.out.println("Returned To Homepage Successfully");
    }
}