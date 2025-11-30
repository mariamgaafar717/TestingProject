package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Delete_Account_Page {

    WebDriver driver;

    public Delete_Account_Page(WebDriver driver) {
        this.driver=driver;
    }

    //locators
    private By account_deleted_word= By.xpath("//b[contains(text(),'Account Deleted!')]");
    private By continue_button= By.cssSelector(".btn.btn-primary");


    //actions
    public boolean check_Account_deleted_word(){
       return driver.findElement(account_deleted_word).isDisplayed();
    }

    public void clickon_Continue_button(){
        driver.findElement(continue_button).click();
    }
}
