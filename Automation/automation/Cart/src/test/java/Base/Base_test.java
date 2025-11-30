package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.*;

public class Base_test {
    WebDriver driver ;
    public HomePage homePage;
    public Product_detailPage productDetailPage ;
    public SignUpPage signUpPage ;
    public LoginPage loginPage ;
    public CheckOutPage checkOutPage;

    @BeforeClass
    public void setUp()
    {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        productDetailPage = new Product_detailPage(driver);
        signUpPage = new SignUpPage(driver);
        loginPage = new LoginPage(driver);
        checkOutPage = new CheckOutPage(driver);
        goHome();
    }
    @BeforeMethod
    public void goHome()
    {
        driver.get("https://automationexercise.com/");
    }
    @AfterClass
    public void Close_Browser()
    {
        driver.quit();
    }
}

