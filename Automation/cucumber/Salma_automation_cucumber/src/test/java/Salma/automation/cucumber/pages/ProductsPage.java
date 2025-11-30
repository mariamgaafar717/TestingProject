package Salma.automation.cucumber.pages;

import Salma.automation.cucumber.base.BasePage;
import org.openqa.selenium.By;

public class ProductsPage extends BasePage {

 // product-level add buttons on listing
 private final By firstAddBtn = By.xpath("(//div[contains(@class,'productinfo')]/a[contains(@class,'add-to-cart')])[1]");
 private final By secondAddBtn = By.xpath("(//div[contains(@class,'productinfo')]/a[contains(@class,'add-to-cart')])[2]");

 // quantity input inside product details
 private final By quantityInput = By.id("quantity");

 // add-to-cart inside product details (normalize-space variants)
 private final By addToCartDetailsBtn = By.xpath("//button[normalize-space()='Add to Cart' or normalize-space()='Add to cart' or contains(@class,'add-to-cart')]");

 // modal content that appears after adding to cart
 private final By modal = By.xpath("//div[contains(@class,'modal-content') or contains(@class,'cart-modal') or @id='cartModal']");

 private final By viewCartInModal = By.xpath("//a[normalize-space()='View Cart']");
 private final By continueShopping = By.xpath("//button[contains(normalize-space(),'Continue') or contains(text(),'Continue Shopping')]");

 public ProductsPage() {
  super();
 }

 public void addFirstProduct() {
  scrollBottom();
  jsClick(firstAddBtn);
  waitVisible(modal);
 }

 public void addSecondProduct() {
  scrollBottom();
  jsClick(secondAddBtn);
  waitVisible(modal);
 }

 public void clickViewCart() {
  waitVisible(modal);
  jsClick(viewCartInModal);
 }

 // Robust method to open first product, change qty to 4 and add to cart
 public void setQuantityToFourAndAdd() {

  // 1. Open first product details page (click the "View Product" link)
  jsClick(By.xpath("(//a[contains(text(),'View Product') or contains(.,'View Product')])[1]"));

  // 2. Wait for quantity box & set quantity = 4
  waitVisible(quantityInput);
  clear(quantityInput);
  type(quantityInput, "4");

  // 3. Ensure Add-to-cart is visible (scroll into view) and click it with JS
  scrollIntoView(addToCartDetailsBtn);
  jsClick(addToCartDetailsBtn);

  // 4. Wait for modal (correct one)
  waitVisible(modal);

  // 5. Continue shopping to return to product listing
  try {
   jsClick(continueShopping);
  } catch (Exception ignored) {
   // if continue not available, just proceed
  }
 }
}