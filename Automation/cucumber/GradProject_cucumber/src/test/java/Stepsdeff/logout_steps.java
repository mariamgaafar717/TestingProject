package Stepsdeff;

import Stepsdeff.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import Pages.HomePagee;
import Pages.Login_Signup_Page;

public class logout_steps {

    WebDriver driver = Hooks.getDriver();
    HomePagee homePage = new HomePagee(driver);
    Login_Signup_Page loginSignupPage;

    @Given("user enter valid username and password click on login button")
    public void user_enter_valid_data_and_click_on_login_button() {
        loginSignupPage = homePage.Signup_login_link_clicl();
        loginSignupPage.Emailbox_of_login_enter("abdosalem3200@gmail.com");
        loginSignupPage.passwordbox_of_login_enter("12345@");
        loginSignupPage.button_of_login();
    }

    @When("user click on logout_2 button")
    public void user_click_on_logout_button() {
        homePage.clickon_Logout_button();
    }

    @Then("user check logout successfully")
    public void userCheckLogoutSuccessfully() {
        String acctualresult=loginSignupPage.Check_login_from_logout_word();
        String expectedresult="Login to your account";
        Assert.assertTrue(acctualresult.contains(expectedresult));

    }
}
