package stepsdef;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks {
    public static WebDriver driver;
    @Before
    public void Setup()
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://automationexercise.com/");
    }
    @After
    public void CloseBrowser()
    {
        driver.quit();
    }
    
    public static WebDriver getDriver()
    {
        return driver;
    }

}
