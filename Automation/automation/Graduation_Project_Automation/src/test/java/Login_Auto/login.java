package Login_Auto;

import Base_Test.base_test;
import org.apache.hc.core5.reactor.Command;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Login_Signup_Page;

public class login extends base_test
{
    public Login_Signup_Page loginSignupPage;

    @Test(priority = 1)
    public void loginsuccess()
    {
        loginSignupPage=homePage.Signup_login_link_clicl();
        loginSignupPage.Emailbox_of_login_enter("abdosalem3200@gmail.com");
        loginSignupPage.passwordbox_of_login_enter("12345@");
        loginSignupPage.button_of_login();


        /*driver.findElement(By.linkText("Signup / Login")).click();
        driver.findElement(By.name("email")).sendKeys("abdosalem3200@gmail.com");
        driver.findElement(By.name("password")).sendKeys("12345@");
        driver.findElement(By.className("btn-default")).click();*/

        String acctual_result=homePage.checkConditionword_();
        String ecxpected_result= "Logged in as";
        Assert.assertTrue(acctual_result.contains(ecxpected_result));
        homePage.clickon_Logout_button();

    }



    @Test(priority = 2)
    public void loginerror_username()
    {
        loginSignupPage=homePage.Signup_login_link_clicl();
        loginSignupPage.Emailbox_of_login_enter("salemabdo3200@gmail.com");
        loginSignupPage.passwordbox_of_login_enter("12345@");
        loginSignupPage.button_of_login();

        /*driver.findElement(By.linkText("Signup / Login")).click();
        driver.findElement(By.name("email")).sendKeys("salem3200@gmail.com");
        driver.findElement(By.name("password")).sendKeys("12345@");
        driver.findElement(By.className("btn-default")).click();*/

        String acctual_result=loginSignupPage.checkUsernameerrorword();
        String ecxpected_result= "Your email or password is incorrect!";
        Assert.assertTrue(acctual_result.contains(ecxpected_result));

    }


    @Test(priority = 3)
    public void loginerror_password()
    {
        loginSignupPage=homePage.Signup_login_link_clicl();
        loginSignupPage.Emailbox_of_login_enter("abdosalem3200@gmail.com");
        loginSignupPage.passwordbox_of_login_enter("123");
        loginSignupPage.button_of_login();


        /*driver.findElement(By.linkText("Signup / Login")).click();
        driver.findElement(By.name("email")).sendKeys("abdosalem3200@gmail.com");
        driver.findElement(By.name("password")).sendKeys("125@");
        driver.findElement(By.className("btn-default")).click();*/

        String acctual_result=loginSignupPage.checkpassworderrorword(); //same error of password and username
        String ecxpected_result= "Your email or password is incorrect!";
        Assert.assertTrue(acctual_result.contains(ecxpected_result));

    }

}
