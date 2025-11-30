package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver=driver;
    }

    //locators
    private By signup_login_link=By.linkText("Signup / Login");
    private By conditionword=By.xpath("//a[contains(text(),' Logged in as ')]");
    private By logout_button=By.cssSelector(".fa.fa-lock");
    private By delete_account_button=By.cssSelector(".fa.fa-trash-o");



    //actions
    public Login_Signup_Page Signup_login_link_clicl(){
        driver.findElement(signup_login_link).click();
        return new Login_Signup_Page(driver);
    }

    public String checkConditionword_(){
        String condition=driver.findElement(conditionword).getText();
        return condition;
    }

    public void clickon_Logout_button(){
        driver.findElement(logout_button).click();
    }

    public Delete_Account_Page click_on_Delete_account_button(){
        driver.findElement(delete_account_button).click();
        return new Delete_Account_Page(driver);
    }

}
