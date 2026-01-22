package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage {
    private WebDriver driver;

    // Locators
    private By itemName = By.className("inventory_item_name");
    private By itemPrice = By.className("inventory_item_price");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }
//getting the item name from the cart
    public String getItemName() {
        return driver.findElement(itemName).getText();
    }

    public double getItemPrice() {
        String priceText = driver.findElement(itemPrice).getText().substring(1);
        return Double.parseDouble(priceText);
    }
}
