package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;



public class basetest {
    public WebDriver driver;

    public HomePage homepage;
    @BeforeClass
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        gohome();

        homepage = new HomePage(driver);

    }
    @BeforeMethod
    public void gohome(){

        driver.get("https://automationexercise.com");
    }

    @AfterClass
    public void closebrowser(){

        driver.quit();
    }

}
