package Base_Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;

public class base_test {
    public WebDriver driver;
    public HomePage homePage;

    @BeforeClass
    public void setup(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        homePage=new HomePage(driver);
        url();
    }

    @BeforeMethod
    public void url(){
      driver.get("https://automationexercise.com/");
    }

    @AfterClass
    public void end(){

        driver.quit();

    }

}
