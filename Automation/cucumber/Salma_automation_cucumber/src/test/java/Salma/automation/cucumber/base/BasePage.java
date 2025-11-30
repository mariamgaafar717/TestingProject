package Salma.automation.cucumber.base;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

 protected WebDriver driver;
 protected WebDriverWait wait;
 protected JavascriptExecutor js;

 // No-arg constructor (Option B): initialize driver from DriverFactory
 public BasePage() {
  this.driver = DriverFactory.getDriver();
  this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
  this.js = (JavascriptExecutor) driver;
 }

 // Wait until element is visible and return it
 public WebElement waitVisible(By locator) {
  return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
 }

 // Click using JS (By locator)
 public void jsClick(By locator) {
  WebElement el = waitVisible(locator);
  try {
   js.executeScript("arguments[0].click();", el);
  } catch (JavascriptException je) {
   // fallback to normal click if JS fails
   el.click();
  }
 }

 // Normal click (with wait)
 public void click(By locator) {
  WebElement el = waitVisible(locator);
  el.click();
 }

 // Scroll to bottom of page
 public void scrollBottom() {
  js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
 }

 // Scroll element into view
 public void scrollIntoView(By locator) {
  WebElement el = waitVisible(locator);
  js.executeScript("arguments[0].scrollIntoView(true);", el);
 }

 // Type text into input (waits first)
 public void type(By locator, String text) {
  WebElement el = waitVisible(locator);
  el.clear();
  el.sendKeys(text);
 }

 // Clear input (waits first)
 public void clear(By locator) {
  WebElement el = waitVisible(locator);
  el.clear();
 }

 // Helper: attempt to close/remove common overlays/ads that break tests
 public void removeAds() {
  try {
   // attempt some common overlay removals - harmless if not present
   js.executeScript(
           "const selectors=['iframe[src*=\"ads\"]','div[role=\"dialog\"] .close, .popup .close', '#dismiss', '.modal-backdrop','.newsletter-modal'];" +
                   "selectors.forEach(s=>{document.querySelectorAll(s).forEach(e=>e.remove());});"
   );
  } catch (Exception ignored) {}
 }

 // Safe get page source (helper usage)
 public String getPageSourceLower() {
  return driver.getPageSource().toLowerCase();
 }
}