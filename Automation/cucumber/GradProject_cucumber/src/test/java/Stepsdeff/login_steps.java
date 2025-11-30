package Stepsdeff;

import Stepsdeff.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import Pages.HomePagee;
import Pages.Login_Signup_Page;

public class login_steps {

    WebDriver driver = Hooks.getDriver();;
    HomePagee homePage = new HomePagee(driver);
    Login_Signup_Page loginSignupPage;

    @Given("user enter valid data and click on login button")
    public void user_enter_valid_data_and_click_on_login_button() {
        loginSignupPage = homePage.Signup_login_link_clicl();
        loginSignupPage.Emailbox_of_login_enter("abdosalem3200@gmail.com");
        loginSignupPage.passwordbox_of_login_enter("12345@");
        loginSignupPage.button_of_login();
    }

    @When("user go to home page and check successful login")
    public void user_go_to_home_page_and_check_successful_login() {
        homePage.checkConditionword_();
    }

    @Then("user click on logout button")
    public void user_click_on_logout_button() {
        homePage.clickon_Logout_button();
    }


    @Given("user enter data with invalid username")
    public void userEnterDataWithInvalidUsername() {
     loginSignupPage = homePage.Signup_login_link_clicl();
     loginSignupPage.Emailbox_of_login_enter("salemabdo3200@gmail.com");
     loginSignupPage.passwordbox_of_login_enter("12345@");
    }

    @When("click on to login button")
    public void clickOnToLoginButton() {
        loginSignupPage.button_of_login();
    }

    @Then("user check error message")
    public void userCheckLogoutDone() {
        String acctual_result=loginSignupPage.checkUsernameerrorword();
        String ecxpected_result= "Your email or password is incorrect!";
        Assert.assertTrue(acctual_result.contains(ecxpected_result));
    }

    @Given("user enter data with invalid password")
    public void userEnterDataWithInvalidPassword() {
        loginSignupPage = homePage.Signup_login_link_clicl();
        loginSignupPage.Emailbox_of_login_enter("abdosalem3200@gmail.com");
        loginSignupPage.passwordbox_of_login_enter("123");
    }


}
