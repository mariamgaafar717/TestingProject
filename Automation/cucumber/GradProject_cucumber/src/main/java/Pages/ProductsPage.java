package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductsPage {
        static WebDriver driver;
    public ProductsPage(WebDriver driver) {
        this.driver = driver ;
    }
   //Locators

    //Verify that user is navigated to all products page
    //@FindBy(id = "sale_image")
    //WebElement productImage;
    private By sale_img_check = By.id("sale_image");
   //click on view product
    private By viewProductButton = By.xpath("//a[@href='/product_details/1']");

    // Actions
    // Verify that user is navigated to products page successfully
    public boolean isImageDisplayed() {
        return driver.findElement(sale_img_check).isDisplayed();
    }

    // scroll to the first product
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

}
