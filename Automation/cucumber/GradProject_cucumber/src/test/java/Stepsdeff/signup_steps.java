package Stepsdeff;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import Pages.*;

public class signup_steps {

      WebDriver driver = Hooks.getDriver();
      Pages.HomePagee homePage = new Pages.HomePagee(driver);
      Pages.Login_Signup_Page loginSignupPage;
      Pages.SignupPage signupPage;
      Pages.Delete_Account_Page deleteAccountPage;
      Pages.Created_Account_Page createdAccountPage;

    @Given("user enter name,email,click on signup button and assert signup page")
    public void user_enter_name_email_click_on_signup_button_and_assert_signup_page() {
        loginSignupPage = homePage.Signup_login_link_clicl();
        loginSignupPage.enter_Name_signup();
        loginSignupPage.enter_Email_signup();
        signupPage=loginSignupPage.clickon_Signup_button();
        //question...
        //String acctualresult=signupPage.check_Enter_Account_word();
        //String expectedresult="Enter Account Information";
        Assert.assertTrue(signupPage.check_Enter_Account_word());

    }

    @When("user enter signup data and click on create button")
    public void userEnterSignupDataAndClickOnCreateButton() {
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
        createdAccountPage = signupPage.clickon_create_account_button();

    }

    @And("check created account and click on continue and homepage assert")
    public void checkCreatedAccountAndClickOnContinueAndHomepageAssert() {
        Assert.assertTrue(createdAccountPage.check_on_Account_created_word());

        createdAccountPage.clickon_Continue_button();
        homePage.checkConditionword_();

    }

    @Then("delete account and assert and click on continue button")
    public void deleteAccountAndAssertAndClickOnContinueButton() {
        deleteAccountPage=homePage.click_on_Delete_account_button();

        Assert.assertTrue(deleteAccountPage.check_Account_deleted_word());

        deleteAccountPage.clickon_Continue_button();

    }
}
