package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutPage {
    WebDriver driver;
    public CheckOutPage(WebDriver driver) {
        this.driver = driver ;
    }
    //Locators
 private By Comment = By.className("form-control");
 public By placeOrderButton = By.cssSelector(".btn.btn-default.check_out");

    //Actions
    public void WriteComment(String comment)
    {
        driver.findElement(Comment).sendKeys(comment);
    }
    public PaymentPage ClickOnPlaceOrder()
    {
        driver.findElement(placeOrderButton).click();
        return new PaymentPage(driver);
    }
}
