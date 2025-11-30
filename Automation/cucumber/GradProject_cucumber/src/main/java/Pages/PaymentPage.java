package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentPage {
    WebDriver driver;
    public PaymentPage(WebDriver driver) {
        this.driver = driver ;
    }
    //Locators
    private By nameOnCart = By.className("form-control");
    private By cardNumber = By.cssSelector(".form-control.card-number");
    private By CVC = By.cssSelector(".form-control.card-cvc");
    private By expirationMonth = By.cssSelector(".form-control.card-expiry-month");
    private By expirationYear = By.cssSelector(".form-control.card-expiry-year");
    private By confirmOrderButton = By.cssSelector(".form-control.btn.btn-primary.submit-button");
    //Actions
public void EnterCartName(String cartName)
{
    driver.findElement(nameOnCart).sendKeys(cartName);
}
public void EnterCartNumer(String cartnumber)
{
    driver.findElement(cardNumber).sendKeys(cartnumber);
}
public void EnterCVC(String cvc)
{
    driver.findElement(CVC).sendKeys(cvc);
}
public void EnterExpirationMon(String expMonth)
{
    driver.findElement(expirationMonth).sendKeys(expMonth);
}
public void EnterExpirationYear(String expYear)
{
    driver.findElement(expirationYear).sendKeys(expYear);
}
public PaymentDonePage ClickOnConfirmOrderButton()
{
    driver.findElement(confirmOrderButton).click();
    return new PaymentDonePage(driver);
}





}
