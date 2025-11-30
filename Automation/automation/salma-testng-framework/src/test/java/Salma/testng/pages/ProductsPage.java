package Salma.testng.pages;

import Salma.testng.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {

    private By firstAddBtn = By.xpath("(//a[contains(@class,'add-to-cart')])[1]");
    private By secondAddBtn = By.xpath("(//a[contains(@class,'add-to-cart')])[2]");
    private By viewFirstProduct = By.xpath("(//a[contains(text(),'View Product')])[1]");
    private By quantityInput = By.id("quantity");
    private By addToCartDetails = By.xpath("//button[contains(text(),'Add to cart')]");
    private By modal = By.xpath("//div[contains(@class,'modal-content')]");
    private By viewCartBtn = By.xpath("//a[normalize-space()='View Cart']");
    private By continueShopping = By.xpath("//button[contains(text(),'Continue')]");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public void addFirstProductQuick() {
        scrollBottom();
        jsClick(firstAddBtn);
        waitVisible(modal);
    }

    public void addSecondProductQuick() {
        scrollBottom();
        jsClick(secondAddBtn);
        waitVisible(modal);
    }

    public void clickViewCart() {
        waitVisible(modal);
        jsClick(viewCartBtn);
    }

    public void setQuantityToFourAndAdd() {
        jsClick(viewFirstProduct);
        waitVisible(quantityInput);
        clear(quantityInput);
        type(quantityInput, "4");
        scrollIntoView(addToCartDetails);
        jsClick(addToCartDetails);
        waitVisible(modal);
        jsClick(continueShopping);
    }
}
