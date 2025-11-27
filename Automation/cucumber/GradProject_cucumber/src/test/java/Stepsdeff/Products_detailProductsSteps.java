package Stepsdeff;

import Pages.HomePagee;
import Pages.Product_detailPage;
import Pages.ProductsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Products_detailProductsSteps {
    WebDriver driver = Hooks.getDriver();
    HomePagee homePagee = new HomePagee(driver);
    ProductsPage productsPage = new ProductsPage(driver);
    Product_detailPage productDetailPage = new Product_detailPage(driver);
    @Given("User is on home page and click on Products button")
    public void user_is_on_home_page_and_click_on_Products_button() {
     ProductsPage productsPage =homePagee.ClickOnProducts();
    }

    @When("User Scroll to the first product and click on view product button")
    public void userScrollToTheFirstProductAndClickOnViewProductButton() {
        // verify that user is navigated to all products page
        productsPage.isImageDisplayed();
        // scroll to the first product
        productsPage.ScrollToTheProductsList();
        //click on view product button
        Product_detailPage productDetailPage =productsPage.ClickOnViewProductButton();
    }

    @Then("User is  landed to product detail page of the first product")
    public void user_is_landed_to_product_detail_page_of_the_first_product() {
   Assert.assertTrue(productDetailPage.isProductNameVisible());
   Assert.assertTrue(productDetailPage.isProductPriceVisible());
   Assert.assertTrue(productDetailPage.isAvailabilityVisible());
   Assert.assertTrue(productDetailPage.isBrandVisible());
   Assert.assertTrue(productDetailPage.isCategoryVisible());
   Assert.assertTrue(productDetailPage.isBrandVisible());

    }


}
