package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver=driver;
    }
    //Locators
    private By viewProductButton = By.xpath("//a[@href='/product_details/1']");
    private By loggedInAs = By.xpath("//a[contains(text(),' Logged in as ')]");
    private By cartButton = By.xpath("//a[@href='/view_cart'][1]");
    private By signUp_LoginButton = By.xpath("//a[@href='/login']");


    //Action
    public void ScrollToTheProductsList()
    {
        WebElement firstProduct = driver.findElement(viewProductButton);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);",firstProduct);
    }
    public Product_detailPage ClickOnViewProductButton()
    {
        driver.findElement(viewProductButton).click();
        return new Product_detailPage(driver);
    }
    public String CheckLoggedInAsUsername()
    {
      return  driver.findElement(loggedInAs).getText();
    }
    public CartPage ClickOnCartButton()
    {
        driver.findElement(cartButton).click();
        return new CartPage(driver);
    }
    public LoginPage ClickOnSignUp_LoginButton()
    {
        driver.findElement(signUp_LoginButton).click();
        return new LoginPage(driver);
    }

}
