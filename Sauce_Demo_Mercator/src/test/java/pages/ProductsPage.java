package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductsPage {
    private WebDriver driver;

    // Locators
    private By priceElements = By.className("inventory_item_price");
    private By addToCartButtons = By.xpath("//button[contains(text(),'Add to cart')]");
    private By productCards = By.className("inventory_item");
    private By productNames = By.className("inventory_item_name");
    private By cartLink = By.className("shopping_cart_link");

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectHighestPriceProduct() {
        List<WebElement> prices = driver.findElements(priceElements);
        List<WebElement> buttons = driver.findElements(addToCartButtons);

        double highestPrice = 0;
        int highestIndex = 0;
//Selecting the highest price product and clicking in add to cart button
        for (int i = 0; i < prices.size(); i++) {
            String priceText = prices.get(i).getText().replace("$", "");
            double price = Double.parseDouble(priceText);

            if (price > highestPrice) {
                highestPrice = price;
                highestIndex = i;
            }
        }

        buttons.get(highestIndex).click();
    }
// getting the highest price product name
    public String getHighestPriceProductName() {
        List<WebElement> prices = driver.findElements(priceElements);
        List<WebElement> cards = driver.findElements(productCards);

        double highestPrice = 0;
        int highestIndex = 0;

        for (int i = 0; i < prices.size(); i++) {
            String priceText = prices.get(i).getText().replace("$", "");
            double price = Double.parseDouble(priceText);

            if (price > highestPrice) {
                highestPrice = price;
                highestIndex = i;
            }
        }

        return cards.get(highestIndex).findElement(productNames).getText();
    }
//getting the highest price in the product page
    public double getHighestPrice() {
        List<WebElement> prices = driver.findElements(priceElements);
        double highestPrice = 0;

        for (WebElement priceElement : prices) {
            String priceText = priceElement.getText().replace("$", "");
            double price = Double.parseDouble(priceText);

            if (price > highestPrice) {
                highestPrice = price;
            }
        }

        return highestPrice;
    }

    public void goToCart() {
        driver.findElement(cartLink).click();
    }
}
