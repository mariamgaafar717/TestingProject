package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }
//Locators
   private By proceedToCheckout = By.xpath("//a[contains(text(),'Proceed To Checkout')]");
    private By RegisterLoginButton = By.xpath("//u[contains(text(),'Register / Login')]");

    //Action
    public CheckOutPage ClickOnProceedToCheckout()
    {
        driver.findElement(proceedToCheckout).click();
        return new CheckOutPage(driver);
    }
    public LoginPage ClickOnRegisterButton()
    {
        driver.findElement(RegisterLoginButton).click();
        return new LoginPage(driver);
    }




}