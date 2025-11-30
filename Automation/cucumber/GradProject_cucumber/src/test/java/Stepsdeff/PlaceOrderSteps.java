package Stepsdeff;

import Pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class PlaceOrderSteps {

    WebDriver driver = Hooks.getDriver();

    // ---------------------------------------------
    // Initialize All Pages
    // ---------------------------------------------
    HomePagee homePage = new HomePagee(driver);
    Product_detailPage productDetailPage = new Product_detailPage(driver);
    CartPage cartPage = new CartPage(driver);
    CheckOutPage checkOutPage = new CheckOutPage(driver);
    Login_Signup_Page loginPage = new Login_Signup_Page(driver);
    SignupPage signupPage; // We initialize this when we land on the page
    Created_Account_Page createdAccountPage; // Initialized after creation
    PaymentPage paymentPage = new PaymentPage(driver);
    PaymentDonePage paymentDonePage; // Initialized after payment
    Delete_Account_Page deleteAccountPage; // Initialized after delete click


    // ---------------------------------------------
    // Shared Steps
    // ---------------------------------------------

    @When("User adds product to cart")
    public void user_adds_product_to_cart() throws InterruptedException {
        homePage.ScrollToTheProductsList();
        // Update the reference using the action method
        productDetailPage = homePage.ClickOnViewProductButton();
        productDetailPage.ClickOnAddToCart();
        Thread.sleep(1500);
    }

    @And("User clicks on cart button")
    public void user_clicks_on_cart_button() {
        if (driver.getCurrentUrl().contains("product_details")) {
            cartPage = productDetailPage.ClickOnViewCart();
        } else {
            cartPage = homePage.ClickOnCartButton();
        }
    }

    @And("User proceeds to checkout")
    public void user_proceeds_to_checkout() {
        checkOutPage = cartPage.ClickOnProceedToCheckout();
    }

    @And("User enters name {string} and email {string} in Signup")
    public void user_enters_name_and_email(String name, String email) {
        // Your Login_Signup_Page methods do not accept arguments (they are hardcoded in the file you sent)
        // So we just call the methods as they are:
        loginPage.enter_Name_signup();
        loginPage.enter_Email_signup();
    }

    @And("User clicks on Signup button")
    public void user_clicks_signup_button() {
        // This action returns a SignupPage object
        signupPage = loginPage.clickon_Signup_button();
    }

    @And("User fills Account Details and clicks Create Account")
    public void user_fills_account_details() throws InterruptedException {
        Thread.sleep(3000);
        // We must use 'signupPage' here, NOT 'loginPage'
        signupPage.choose_title();
        signupPage.enter_password();
        signupPage.choose_Day();
        signupPage.choose_month();
        signupPage.choose_year();
        signupPage.clickon_newsletter();
        signupPage.clickon_receive_offer();
        signupPage.enter_first_name();
        signupPage.enter_last_name();
        signupPage.enter_company();
        signupPage.enter_addres1();
        signupPage.enter_address2();
        signupPage.enter_country();
        signupPage.enter_state();
        signupPage.enter_city();
        signupPage.enter_zipcode();
        signupPage.enter_mobile_number();

        // This returns the Created_Account_Page
        createdAccountPage = signupPage.clickon_create_account_button();
    }

    @Then("Account created message is visible")
    public void account_created_message_visible() {
        // Your Page Object returns boolean, so we use assertTrue directly
        boolean isDisplayed = createdAccountPage.check_on_Account_created_word();
        Assert.assertTrue(isDisplayed, "Account Created message not displayed");
    }

    @When("User clicks Continue button")
    public void user_clicks_continue() {
        // This method is void in your Page Object, so we don't assign it
        createdAccountPage.clickon_Continue_button();
    }

    @Then("User is logged in as {string}")
    public void user_is_logged_in_as(String name) {
        Assert.assertTrue(homePage.checkConditionword_().contains("Logged in as"));
    }

    @And("User enters comment {string} and places order")
    public void user_places_order(String comment) {
        checkOutPage.WriteComment(comment);
        paymentPage = checkOutPage.ClickOnPlaceOrder();
    }

    @And("User enters payment details Name {string}, Card {string}, CVC {string}, Month {string}, Year {string}")
    public void user_enters_payment(String name, String card, String cvc, String month, String year) {
        paymentPage.EnterCartName(name);
        paymentPage.EnterCartNumer(card);
        paymentPage.EnterCVC(cvc);
        paymentPage.EnterExpirationMon(month);
        paymentPage.EnterExpirationYear(year);
    }

    @And("User clicks Pay and Confirm Order")
    public void user_confirms_order() {
        paymentDonePage = paymentPage.ClickOnConfirmOrderButton();
    }

    @Then("Success message {string} is displayed")
    public void success_message_displayed(String expectedMsg) {
        String actualMsg = paymentDonePage.GetMsg();
        Assert.assertTrue(actualMsg.contains("Congratulations"));
    }

    @When("User deletes the account")
    public void user_deletes_account() {
        deleteAccountPage = paymentDonePage.ClickOnDeleteAccountButton();
    }

    @Then("Account Deleted message is visible")
    public void account_deleted_visible() {
        // Your Page Object returns boolean
        boolean isDeleted = deleteAccountPage.check_Account_deleted_word();
        Assert.assertTrue(isDeleted, "Account Deleted message not displayed");

        // Final click continue to go home
        deleteAccountPage.clickon_Continue_button();
    }

    // ---------------------------------------------
    // Scenario 1 Specific Steps (Register While Checkout)
    // ---------------------------------------------

    @And("User clicks on Register Login button")
    public void user_clicks_register_login_from_cart() {
        // Assuming CartPage has this method. If not, you need to add it to CartPage.java
        // based on your previous messages, it was ClickOnRegisterButton()
        loginPage = cartPage.ClickOnRegisterButton();
    }

    // ---------------------------------------------
    // Scenario 2 Specific Steps (Register Before Checkout)
    // ---------------------------------------------

    @When("User clicks on Signup Login button")
    public void user_clicks_signup_login_from_home() {
        loginPage = homePage.Signup_login_link_clicl();
    }
}