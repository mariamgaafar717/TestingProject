package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login_Signup_Page {
    WebDriver driver;
    public Login_Signup_Page(WebDriver driver) {
        this.driver=driver;
    }

    //login locators
    private By emailbox_of_login=By.name("email");
    private By passwordbox_of_login=By.name("password");
    private By button_of_login=By.className("btn-default");


    //check locators
    private By usernameerrorword = By.cssSelector("p[style='color: red;']");
    private By passworderrorword = By.cssSelector("p[style='color: red;']");
    private By login_from_logout_word= By.xpath("//h2[contains(text(),'Login to your account')]");


    //signup locators
    private By name_signup= By.xpath("//input[@type='text']");
    private By email_signup= By.xpath("//input[@data-qa='signup-email']");
    private By signup_button= By.xpath("//button[@data-qa='signup-button']");




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




    //check actions
    public String checkUsernameerrorword(){
        String usernameerrormessage = driver.findElement(usernameerrorword).getText();
        return usernameerrormessage;
    }

    public String checkpassworderrorword(){
        String passworderrormessage = driver.findElement(passworderrorword).getText();
        return passworderrormessage;
    }

    public String Check_login_from_logout_word(){
       String message = driver.findElement(login_from_logout_word).getText();
       return message;
    }




    //Signup actions
    public void enter_Name_signup(){
        driver.findElement(name_signup).sendKeys("abdo");
    }

    public void enter_Email_signup(){
        driver.findElement(email_signup).sendKeys("abdelrahmansalem609@gmail.com");
    }

    public SignupPage clickon_Signup_button(){
        driver.findElement(signup_button).click();
        return new SignupPage(driver);
    }
}
