package utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitHelper {

    private WebDriver driver;
    private WebDriverWait wait;

    public WaitHelper(WebDriver driver, int timeoutSeconds) {
        this.driver = driver;
        this.wait   = new WebDriverWait(driver,
                          Duration.ofSeconds(timeoutSeconds));
    }

    public WebElement waitForVisibility(By locator) {
        return wait.until(
            ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitForClickable(By locator) {
        return wait.until(
            ExpectedConditions.elementToBeClickable(locator));
    }

    public WebElement waitForPresence(By locator) {
        return wait.until(
            ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void safeClick(By locator) {
        waitForClickable(locator).click();
    }

    public void safeType(By locator, String text) {
        waitForVisibility(locator).sendKeys(text);
    }

    public String getText(By locator) {
        return waitForVisibility(locator).getText();
    }

    public void jsClick(By locator) {
        WebElement element = waitForPresence(locator);
        ((JavascriptExecutor) driver)
            .executeScript("arguments[0].click();", element);
    }

    public void waitForInvisibility(By locator) {
        wait.until(
            ExpectedConditions.invisibilityOfElementLocated(locator));
    }
}