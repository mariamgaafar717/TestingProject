package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreatedAccountPage {
    WebDriver driver ;
    public CreatedAccountPage(WebDriver driver) {
        this.driver = driver;
    }
    //Locators
     private By accountCreated = By.xpath("//p[contains(text(),'Congratulations! Your new account has been successfully created!')]");
  private By ContinueButton = By.xpath("//a[@data-qa='continue-button']");


    //Actions
public HomePage ClickOnContinueButton()
{
    driver.findElement(ContinueButton).click();
    return new HomePage(driver);
}
public String CheckThatAccountCreated()
{
  return driver.findElement(accountCreated).getText();

}







}
