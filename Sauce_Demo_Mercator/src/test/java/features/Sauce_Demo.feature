Feature: Add highest price product to the cart
  Scenario: Select highest price product and add to the cart
    Given navigate to Saucedemo application
    And login with valid credentials
    When select the highest price product
    Then add the product to the cart
