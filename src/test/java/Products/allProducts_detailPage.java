package Products;

import Base.baseTests;
import Pages.Product_detailPage;
import Pages.ProductsPage;
import Pages.TestCasesPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class allProducts_detailPage extends baseTests {
    public ProductsPage productsPage;
    public Product_detailPage productDetailPage;

    @Test
    public void verifyAllProducts() {

// Click on products button
      productsPage = homePagee.ClickOnProducts();
        //verify that user is navigated to all products page successfully
       Assert.assertTrue(productsPage.isImageDisplayed());

        // scroll to products section
        productsPage.ScrollToTheProductsList();


        // click On view Product
      productDetailPage = productsPage.ClickOnViewProductButton();
      // Verify that detail page is visible: product name, category, price, availability, condition, brand
           Assert.assertTrue(productDetailPage.isProductNameVisible(), "Product name is not visible!");
            Assert.assertTrue(productDetailPage.isCategoryVisible(), "Product category is not visible!");
            Assert.assertTrue(productDetailPage.isProductPriceVisible(), "Product price is not visible!");
            Assert.assertTrue(productDetailPage.isAvailabilityVisible(), "Product availability is not visible!");
            Assert.assertTrue(productDetailPage.isConditionVisible(), "Product condition is not visible!");
            Assert.assertTrue(productDetailPage.isBrandVisible(), "Product brand is not visible!");

    }


}
