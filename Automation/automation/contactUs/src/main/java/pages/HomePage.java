package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;
    public HomePage(WebDriver driver) {
        this.driver=driver;
    }
    //locators
    private By locateContactUs=By.cssSelector(".fa.fa-envelope");

    //Actions
    public ContactUsFormPage clickContactUsForm(){
        driver.findElement(locateContactUs).click();
        return new ContactUsFormPage(driver);
    }
}
