package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DeleteAccountPage {
    WebDriver driver;
    public DeleteAccountPage(WebDriver driver) {
        this.driver = driver ;
    }
    //Locators
   private By deleteMessage = By.xpath("//b[contains(text(),'Account Deleted!')]");
   private By continueeButton = By.cssSelector(".btn.btn-primary");



    //Actions
    public String getDeleteMessage()
    {
      return driver.findElement(deleteMessage).getText();
    }
    public HomePage ClickOnContinueeButton()
    {
        driver.findElement(continueeButton).click();
        return new HomePage(driver);
    }
}
