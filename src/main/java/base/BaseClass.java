package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

    public static WebDriver driver;
    public static WebDriverWait wait;

    @BeforeClass
    public void setup() {
    	WebDriverManager.chromedriver().setup();
        //System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-notifications");

        driver = new ChromeDriver(options);

        driver.manage().timeouts()
                .pageLoadTimeout(Duration.ofSeconds(90));
        driver.manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(5));

        wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        driver.get("https://fullyfilmy.in/");

        System.out.println("Browser Launched Successfully");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
        System.out.println("Browser Closed Successfully");
    }
}