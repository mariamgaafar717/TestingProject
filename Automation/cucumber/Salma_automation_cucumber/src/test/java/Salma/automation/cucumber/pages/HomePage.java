package Salma.automation.cucumber.pages;

import Salma.automation.cucumber.base.BasePage;
import org.openqa.selenium.By;

public class HomePage extends BasePage {

 private final By productsBtn = By.xpath("//a[contains(text(),'Products')]");
 private final By cartBtn = By.xpath("//a[contains(@href,'/view_cart')]");
 private final By subscribeInput = By.id("susbscribe_email");
 private final By subscribeBtn = By.id("subscribe");

 public HomePage() {
  super(); // uses no-arg BasePage
 }

 public void open(String url) {
  driver.get(url);
  removeAds();
 }

 public boolean isHomeVisible() {
  return driver.getTitle().contains("Automation");
 }

 public void goToProducts() {
  removeAds();
  click(productsBtn);
 }

 public void goToCart() {
  removeAds();
  click(cartBtn);
 }

 public void scrollToBottom() {
  scrollBottom();
 }

 public void subscribeFooter(String email) {
  removeAds();
  type(subscribeInput, email);
  click(subscribeBtn);
 }
}