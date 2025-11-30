package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignPage {
    WebDriver driver;
    public SignPage(WebDriver driver) {
        this.driver=driver;
    }

    //signup locators
    private By name_signup= By.xpath("//input[@type='text']");
    private By email_signup= By.xpath("//input[@data-qa='signup-email']");
    private By signup_button= By.xpath("//button[@data-qa='signup-button']");

    //login locators
    private By emailbox_of_login=By.name("email");
    private By passwordbox_of_login=By.name("password");
    private By button_of_login=By.className("btn-default");


    //Actions

    //login actions
    public void Emailbox_of_login_enter(String email){
        driver.findElement(emailbox_of_login).sendKeys(email);
    }

    public void passwordbox_of_login_enter(String password){
        driver.findElement(passwordbox_of_login).sendKeys(password);
    }

    public void button_of_login(){
        driver.findElement(button_of_login).click();
    }
    //Signup actions
    public void enter_Name_signup(){
        driver.findElement(name_signup).sendKeys("abdo");
    }

    public void enter_Email_signup(){
        driver.findElement(email_signup).sendKeys("abdelrahmansalem609@gmail.com");
    }

    public SignPage clickon_Signup_button(){
        driver.findElement(signup_button).click();
        return new SignPage(driver);
    }


}

