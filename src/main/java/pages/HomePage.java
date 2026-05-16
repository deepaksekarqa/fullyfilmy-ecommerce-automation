package pages;

import org.openqa.selenium.By;

import base.BaseClass;
import utils.WaitHelper;

public class HomePage {

    private WaitHelper waitHelper;

    private WaitHelper getWaitHelper() {
        if (waitHelper == null) {
            waitHelper = new WaitHelper(BaseClass.driver, 15);
        }
        return waitHelper;
    }

    // Locators
    By homeLogo =
        By.xpath("//img[@alt='Fully Filmy']");

    // Verify URL
    public boolean verifyURL() {
        String actualURL = BaseClass.driver.getCurrentUrl();
        System.out.println("Current URL: " + actualURL);
        return actualURL.contains("fullyfilmy.in");
    }

    // Verify Logo
    public boolean verifyLogo() {
        return getWaitHelper()
                .waitForVisibility(homeLogo)
                .isDisplayed();
    }
}