package StepDef;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Hooks {


    public static WebDriver driver;

    @Before
    public void setup(){
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://automationexercise.com/");
    }

    @After
    public void close_browser(){
        driver.quit();
    }

    public static WebDriver getdriver(){
        return driver;
    }
}
