package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentDonePage {
    WebDriver driver ;
    public PaymentDonePage(WebDriver driver) {
        this.driver = driver ;
    }
    //Locators
   private By successMsg = By.xpath("//p[contains(text(),'Congratulations! Your order has been confirmed!')]");
   private By deleteAccount = By.xpath("//a[@href=\"/delete_account\"]");



    //Actions
public String GetMsg()
{
   return driver.findElement(successMsg).getText();
}
public DeleteAccountPage ClickOnDeleteAccountButton()
{
    driver.findElement(deleteAccount).click();
    return new DeleteAccountPage(driver);
}






}
