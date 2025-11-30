package Salma.testng.pages;

import Salma.testng.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    private By cartSection = By.id("cart_items");
    private By deleteBtn = By.xpath("//a[contains(@href,'delete')]");
    private By recommendedAdd = By.xpath("//div[@id='recommended-item-carousel']//a[contains(text(),'Add')]");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public boolean isCartDisplayed() {
        try {
            waitVisible(cartSection);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void removeProduct() {
        jsClick(deleteBtn);
    }

    public void addRecommended() {
        jsClick(recommendedAdd);
    }
}
