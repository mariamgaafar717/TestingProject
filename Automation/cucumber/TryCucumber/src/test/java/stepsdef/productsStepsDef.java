package stepsdef;

import stepsdef.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.HomePage;
import pages.ProductsPage;
import pages.SignPage;

import java.time.Duration;

public class productsStepsDef {
    WebDriver driver = Hooks.getDriver();
    HomePage homepage = new HomePage(driver);
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    private ProductsPage productsPage;
    private SignPage signPage;

    @Given("I am on the home page")
    public void iAmOnTheHomePage() {
        // Already on home page from Hooks setup
    }

    @When("I navigate to the products page")
    public void iNavigateToTheProductsPage() {
        productsPage = homepage.clickproductspage();
        productsPage.clickProductsButton();
    }

    @Then("I should see the {string} page")
    public void iShouldSeeThePage(String expectedPage) {
        Assert.assertTrue(productsPage.isUserOnAllProductsPage(),
                "Not on " + expectedPage + " page");
    }

    @When("I search for {string}")
    public void iSearchFor(String productName) {
        productsPage.enterProductName(productName);
        productsPage.clickSearchButton();
    }

    @Then("I should see {string} heading")
    public void iShouldSeeHeading(String heading) {
        Assert.assertTrue(productsPage.isSearchedProductsVisibleINproductsPage(),
                "'" + heading + "' is not visible");
    }

    @And("all displayed products should be related to {string}")
    public void allDisplayedProductsShouldBeRelatedTo(String searchTerm) {
        Assert.assertTrue(productsPage.areAllProductsRelatedToSearch(searchTerm),
                "Not all products are related to the search");
    }

    @When("I add the searched products to cart")
    public void iAddTheSearchedProductsToCart() {
        productsPage.AddToCartButton();
    }

    @And("I view my cart")
    public void iViewMyCart() {
        productsPage.ClickCartButton();
    }

    @Then("the searched products should be visible in the cart")
    public void theSearchedProductsShouldBeVisibleInTheCart() {
        Assert.assertTrue(productsPage.isSearchedProductsVisibleInCart(),
                "Products are not visible in cart");
    }

    @When("I login with email {string} and password {string}")
    public void iLoginWithEmailAndPassword(String email, String password) {
        // Navigate to sign page
        signPage = homepage.clicksignpage();

        // Add explicit wait if needed
        try {
            Thread.sleep(1000); // Small wait for page to load
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Enter credentials
        signPage.Emailbox_of_login_enter(email);
        signPage.passwordbox_of_login_enter(password);
        signPage.button_of_login();

        // Wait for login to complete
        try {
            Thread.sleep(3000); // Wait for login redirect
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // CRITICAL: Re-initialize HomePage after login because page has refreshed
        homepage = new HomePage(driver);
    }

    @Then("the searched products should still be visible in the cart")
    public void theSearchedProductsShouldStillBeVisibleInTheCart() {
        // Verify products are still there after login
        Assert.assertTrue(productsPage.isSearchedProductsVisibleInCart(),
                "Products are not visible in cart after login");
    }

    @When("I click on view product details")
    public void iClickOnViewProductDetails() {
        productsPage.clickviewproductfortest21();
    }

    @And("I write a review with name {string}, email {string}, and review {string}")
    public void iWriteAReviewWithNameEmailAndReview(String name, String email, String review) {
        productsPage.Writeyourname(name);
        productsPage.Writeyouremail(email);
        productsPage.EnterYouReview(review);
    }

    @And("I submit the review")
    public void iSubmitTheReview() {
        productsPage.clicksubmit();
    }

    @Then("the review should be submitted successfully")
    public void theReviewShouldBeSubmittedSuccessfully() {
        // Add assertion if there's a success message
        // Assert.assertTrue(productsPage.isReviewSuccessMessageVisible(),
        //     "Review submission success message is not visible");
    }
}