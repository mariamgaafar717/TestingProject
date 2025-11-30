package Salma.testng.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class BaseTest {
    protected WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = DriverFactory.getDriver();
    }

    @AfterClass
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
