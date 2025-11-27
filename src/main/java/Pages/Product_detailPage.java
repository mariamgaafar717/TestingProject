package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Product_detailPage {
    WebDriver driver ;
    public Product_detailPage(WebDriver driver) {
        this.driver = driver ;
    }

    //Locators
    private By productContainer = By.className("product-information");
    private By productName = By.xpath("//h2[contains(text(),'Blue Top')]");
    private By category = By.xpath("//p[contains(text(),'Category')]");
    private By productPrice = By.xpath("//span[contains(text(),'Rs')]");
    private By availability = By.xpath("//b[contains(text(),'Availability')]");
    private By condition = By.xpath("//b[contains(text(),'Condition')]");
    private By brand = By.xpath("//b[contains(text(),'Brand')]");




    //Actions
    private WebElement getProductContainer() {
        return driver.findElement(productContainer);
    }
    public boolean isProductNameVisible() {
        return getProductContainer().findElement(productName).isDisplayed();
    }

    public boolean isCategoryVisible() {
        return getProductContainer().findElement(category).isDisplayed();
    }

    public boolean isProductPriceVisible() {
        return getProductContainer().findElement(productPrice).isDisplayed();
    }

    public boolean isAvailabilityVisible() {
        return getProductContainer().findElement(availability).isDisplayed();
    }

    public boolean isConditionVisible() {
        return getProductContainer().findElement(condition).isDisplayed();
    }

    public boolean isBrandVisible() {
        return getProductContainer().findElement(brand).isDisplayed();
    }






}
