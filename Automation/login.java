package Login_Auto;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class login
{

    @Test
    public void loginsuccess()
    {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://automationexercise.com/");


        driver.findElement(By.linkText("Signup / Login")).click();
        driver.findElement(By.name("email")).sendKeys("abdosalem3200@gmail.com");
        driver.findElement(By.name("password")).sendKeys("12345@");
        driver.findElement(By.className("btn-default")).click();

        String acctual_result=driver.findElement(By.id("slider-carousel")).getText();
        String ecxpected_result= "Automation";
        Assert.assertTrue(acctual_result.contains(ecxpected_result));
        driver.quit();

    }



    @Test
    public void loginerror_username()
    {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://automationexercise.com/");


        driver.findElement(By.linkText("Signup / Login")).click();
        driver.findElement(By.name("email")).sendKeys("salem3200@gmail.com");
        driver.findElement(By.name("password")).sendKeys("12345@");
        driver.findElement(By.className("btn-default")).click();

        String acctual_result=driver.findElement(By.tagName("p")).getText();
        String ecxpected_result= "Your email or password is incorrect!";
        Assert.assertTrue(acctual_result.contains(ecxpected_result));
        driver.quit();

    }


    @Test
    public void loginerror_password()
    {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://automationexercise.com/");


        driver.findElement(By.linkText("Signup / Login")).click();
        driver.findElement(By.name("email")).sendKeys("abdosalem3200@gmail.com");
        driver.findElement(By.name("password")).sendKeys("125@");
        driver.findElement(By.className("btn-default")).click();

        String acctual_result=driver.findElement(By.tagName("p")).getText();
        String ecxpected_result= "Your email or password is incorrect!";
        Assert.assertTrue(acctual_result.contains(ecxpected_result));
        driver.quit();

    }







}
