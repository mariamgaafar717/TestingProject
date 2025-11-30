package Salma.automation.cucumber.pages;

import Salma.automation.cucumber.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CartPage extends BasePage {

 private final By cartSection = By.id("cart_items");
 private final By quantityInput = By.xpath("//input[contains(@class,'cart_quantity_input')]");
 private final By deleteBtn = By.xpath("//a[contains(@href,'delete')]");
 private final By recommendedAdd = By.xpath("//div[@id='recommended-item-carousel']//a[contains(text(),'Add')]");
 private final By subscribeInput = By.id("susbscribe_email");
 private final By subscribeBtn = By.id("subscribe");

 public CartPage() {
  super();
 }

 // returns true if cart section is displayed (safe)
 public boolean isCartDisplayed() {
  try {
   WebElement el = waitVisible(cartSection);
   return el.isDisplayed();
  } catch (Exception e) {
   return false;
  }
 }

 public void setQuantity(String qty) {
  removeAds();
  type(quantityInput, qty);
 }

 public void removeProduct() {
  removeAds();
  click(deleteBtn);
 }

 public void addRecommended() {
  removeAds();
  jsClick(recommendedAdd);
 }

 public void clickViewCart() {
  driver.get("http://automationexercise.com/view_cart");
 }

 public void subscribeFooter(String email) {
  type(subscribeInput, email);
  click(subscribeBtn);
 }
}