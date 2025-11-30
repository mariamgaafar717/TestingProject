package Salma.automation.cucumber.steps;

import Salma.automation.cucumber.base.DriverFactory;
import Salma.automation.cucumber.pages.CartPage;
import Salma.automation.cucumber.pages.HomePage;
import Salma.automation.cucumber.pages.ProductsPage;
import io.cucumber.java.After;
import io.cucumber.java.en.*;
import org.testng.Assert;

public class Steps {

 HomePage home = new HomePage();
 ProductsPage products = new ProductsPage();
 CartPage cart = new CartPage();

 @Given("user opens home page")
 public void openHome() {
  DriverFactory.getDriver(); // ensure driver is started
  home.open("http://automationexercise.com");
 }

 @When("user goes to products page")
 public void goProducts() {
  home.goToProducts();
 }

 @When("user adds two products to cart")
 public void addTwo() {
  products.addFirstProduct();
  products.addSecondProduct();
  products.clickViewCart();
 }

 @Then("user should see products in cart")
 public void verifyCart() {
  Assert.assertTrue(cart.isCartDisplayed(), "Cart section should be visible");
 }

 @When("user increases product quantity to 4 and adds to cart")
 public void qty4() {
  products.setQuantityToFourAndAdd();
  products.clickViewCart();
 }

 @Then("cart should show quantity 4")
 public void verifyQty() {
  // simple page source check for quantity '4' (could be improved to check specific input value)
  Assert.assertTrue(DriverFactory.getDriver().getPageSource().contains(">4<") ||
                  DriverFactory.getDriver().getPageSource().contains("value=\"4\"") ||
                  DriverFactory.getDriver().getPageSource().contains("> 4 <"),
          "Cart should show quantity 4");
 }

 @When("user adds a product to cart and goes to cart")
 public void addAndGo() {
  products.addFirstProduct();
  products.clickViewCart();
 }

 @When("user removes the product")
 public void remove() {
  cart.removeProduct();
 }

 @Then("cart should not contain that product")
 public void verifyRemoved() {
  Assert.assertFalse(DriverFactory.getDriver().getPageSource().contains("Product"));
 }

 @When("user navigates to cart page")
 public void goCart() {
  home.goToCart();
 }

 @When("user enters email to subscribe in cart footer")
 public void subscribe() {
  cart.subscribeFooter("salma+" + System.currentTimeMillis() + "@example.com");
 }

 @When("user scrolls to recommended items and adds one to cart")
 public void addRec() {
  home.scrollToBottom();
  cart.addRecommended();
 }

 @Then("user should see it in cart")
 public void verifyRec() {
  cart.clickViewCart();
  Assert.assertTrue(cart.isCartDisplayed());
 }

 @Then("subscription should be successful")
 public void subscription_should_be_successful() {
  String page = DriverFactory.getDriver().getPageSource().toLowerCase();
  Assert.assertTrue(page.contains("successfully subscribed") || page.contains("successfully sub"), "Subscription success message not found");
 }

 @After
 public void tearDown() {
  // optional: leave the driver running if you want logs; uncomment to quit
  // DriverFactory.quitDriver();
 }
}