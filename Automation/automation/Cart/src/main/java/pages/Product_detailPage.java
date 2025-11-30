package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Product_detailPage {
    WebDriver driver;
    WebDriverWait wait ;

    public Product_detailPage(WebDriver driver) {
        this.driver = driver;
    }

    //Locators
    private By AddToCart = By.cssSelector(".btn.btn-default.cart");
    private By viewCart = By.xpath("//u[contains(text(),'View Cart')]");

    //Actions
    public void ClickOnAddToCart() {
        driver.findElement(AddToCart).click();
    }

    public CartPage ClickOnViewCart()
    {
        driver.findElement(viewCart).click();
        return new CartPage(driver);
    }
}