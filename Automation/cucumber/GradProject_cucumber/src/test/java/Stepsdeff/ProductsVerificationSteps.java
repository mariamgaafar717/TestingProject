package Stepsdeff;

import Pages.BrandProductsPage;
import Pages.ProductsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ProductsVerificationSteps {

    WebDriver driver = Hooks.getDriver();
    ProductsPage productsPage = new ProductsPage(driver);
    BrandProductsPage brandProductsPage;

    // --- Search Steps ---
    @When("User searches for product {string}")
    public void user_searches_for_product(String productName) {
        productsPage.searchForProduct(productName);
    }

    @Then("{string} header is visible")
    public void header_is_visible(String headerText) {
        Assert.assertTrue(productsPage.isSearchedProductsHeaderVisible(), "Header not visible");
    }

    @And("The search results are displayed")
    public void the_search_results_are_displayed() {
        Assert.assertTrue(productsPage.areSearchResultsDisplayed(), "No search results found");
    }

    // --- Category Steps ---
    @When("User clicks on category {string} and subcategory {string}")
    public void user_clicks_on_category_and_subcategory(String main, String sub) {
        productsPage.clickCategory(main, sub);
    }

    @Then("The category title should be {string}")
    public void the_category_title_should_be(String expectedTitle) {
        Assert.assertTrue(productsPage.getCategoryTitle().contains(expectedTitle));
    }

    @And("The category products are displayed")
    public void the_category_products_are_displayed() {
        Assert.assertTrue(productsPage.isCategoryProductsDisplayed());
    }

    // --- Brand Steps ---
    @When("User clicks on Brand {string}")
    public void user_clicks_on_brand(String brandName) {
        brandProductsPage = productsPage.clickOnBrand(brandName);
    }

    @Then("The Brand Page title should contain {string}")
    public void the_brand_page_title_should_contain(String brandName) {
        Assert.assertTrue(brandProductsPage.getBrandTitle().contains(brandName.toUpperCase()));
    }

    @And("The Brand products are displayed")
    public void the_brand_products_are_displayed() {
        Assert.assertTrue(brandProductsPage.areBrandProductsDisplayed());
    }
}