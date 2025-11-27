package Base;

import Pages.HomePagee;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class baseTests {
   public WebDriver driver ;
   public HomePagee homePagee ;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        gohome();
        homePagee = new HomePagee(driver);
    }

    @BeforeMethod
    public void gohome()
    {
        driver.get("https://automationexercise.com/");
    }

    public void VerifyHomepageVisible()
    {
    String ActualResult = driver.findElement(By.xpath("//h2[contains(text(),'Full-Fledged practice' )]")).getText();
    String ExpectedResult = "Full-Fledged practice website for Automation Engineers" ;
        Assert.assertTrue(ActualResult.contains(ExpectedResult));
    }
    @AfterClass
    public void close()
    {
        driver.quit();
    }


    }




