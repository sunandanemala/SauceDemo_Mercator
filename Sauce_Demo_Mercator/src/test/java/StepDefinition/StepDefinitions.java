package StepDefinition;

import Pages.CartPage;
import Pages.LoginPage;
import Pages.ProductsPage;
import Utility.BrowserDriver;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class StepDefinitions {
    private WebDriver driver;
    private LoginPage loginPage;
    private ProductsPage productsPage;
    private CartPage cartPage;
    private String expectedProductName;
    private double expectedPrice;

    @Given("navigate to Saucedemo application")
    public void navigate_to_saucedemo_application() {
        driver = BrowserDriver.getDriver();
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        cartPage = new Pages.CartPage(driver);
    }

    @And("login with valid credentials")
    public void login_with_valid_credentials() throws InterruptedException {
        //Login with user name: standard_user and password : secret_sauce
        loginPage.login("standard_user", "secret_sauce");
    }

    @When("select the highest price product")
    public void select_the_highest_price_product() throws InterruptedException {
        expectedProductName = productsPage.getHighestPriceProductName();
        expectedPrice = productsPage.getHighestPrice();

        productsPage.selectHighestPriceProduct();
        productsPage.goToCart();

        Thread.sleep(2000);

        // Verify product in cart
        Assert.assertEquals(expectedProductName, cartPage.getItemName());
        Assert.assertEquals(expectedPrice, cartPage.getItemPrice(), 0.01);


    }

    @Then("add the product to the cart")
    public void add_the_product_to_the_cart() {
        BrowserDriver.quitDriver();
    }
}
