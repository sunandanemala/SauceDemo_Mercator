package hooks;

import Utility.BrowserDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class hooks {
    @Before
    public void setUp() {
        WebDriver driver = BrowserDriver.getDriver();
        if (driver != null) {
            driver.get("https://www.saucedemo.com/");

            try {
                Thread.sleep(2000); // Wait 2 seconds for page load
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Wait for JS-rendered login page
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-name")));
        } else {
            System.out.println("Driver is null!");
        }
    }
}

