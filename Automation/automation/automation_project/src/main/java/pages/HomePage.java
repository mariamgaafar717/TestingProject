package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver){

        this.driver=driver;
    }
    //Locators
    private By locateproductpage=By.cssSelector(".material-icons.card_travel");
//    private By locatesignuppage=By.linkText(" Signup / Login");
    private By locatesignuppage=By.linkText("Signup / Login");

    //Actions
    public ProductsPage clickproductspage(){
        driver.findElement(locateproductpage).click();

        return new ProductsPage(driver) ;
    }

    public SignPage clicksignpage(){
        driver.findElement(locatesignuppage).click();
        return new SignPage(driver);
    }

}
