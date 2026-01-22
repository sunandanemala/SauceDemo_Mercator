package Utility;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BrowserDriver {
    public static WebDriver driver;
public static WebDriver getDriver(){
    if(driver == null){
        try{
            System.out.println("Setting up ChromeDriver...");
            ChromeOptions options = new ChromeOptions();
            Map<String, Object> prefs = new HashMap<>();
            prefs.put("credentials_enable_service", false);
            prefs.put("password_manager_enabled", false);
            options.setExperimentalOption("prefs", prefs);
            prefs.put("profile.password_manager_leak_detection", false);

            options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));
            options.setExperimentalOption("useAutomationExtension", false);
            options.addArguments("--disable-blink-features=AutomationControlled");
            options.addArguments("--remote-allow-origins=*");
            options.addArguments("--start-maximized");
            options.addArguments("--disable-web-security");
            options.addArguments("--disable-save-password-bubble");
            options.addArguments("--disable-password-generation");
            options.addArguments("--disable-features=VizDisplayCompositor,PasswordLeakDetection");
            options.addArguments("--disable-password-manager-reauthentication");
            System.out.println("Creating ChromeDriver instance...");
            driver = new ChromeDriver(options);
            System.out.println("Driver created: " + driver);

            // Remove webdriver property to enable javascript to run the application
            ((JavascriptExecutor) driver).executeScript("Object.defineProperty(navigator, 'webdriver', {get: () => undefined})");
        } catch (Exception e) {
            System.out.println("Error creating driver: " + e.getMessage());
            e.printStackTrace();
        }
        }
    return driver;
}
public static void quitDriver(){
    if(driver != null){
        driver.quit();
        driver = null;
    }
}
}
