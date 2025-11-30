package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;
    public LoginPage(WebDriver driver)
    {
        this.driver = driver ;
    }
   //Locators
   private By Name = By.name("name");
   private By Email = By.xpath("//input[@data-qa='signup-email']");
   private By signUpButton = By.xpath("//button[@data-qa=\"signup-button\"]");

    //Actions
    public void EnterName(String name)
    {
        driver.findElement(Name).sendKeys(name);
    }
    public void EnterEmail(String email)
    {
        driver.findElement(Email).sendKeys(email);
    }
    public SignUpPage ClickOnSignUpButton()
    {
        driver.findElement(signUpButton).click();
        return new SignUpPage(driver);

    }
}
