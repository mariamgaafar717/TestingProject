package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Created_Account_Page {

    WebDriver driver;

    public Created_Account_Page(WebDriver driver) {
        this.driver = driver;
    }

    //locators
    private By account_created_word = By.xpath("//b[contains(text(),'Account Created!')]");
    private By continue_button = By.cssSelector(".btn.btn-primary");

    //actions
    public boolean check_on_Account_created_word(){
     return driver.findElement(account_created_word).isDisplayed();
    }

    public void clickon_Continue_button(){
        driver.findElement(continue_button).click();
    }


}