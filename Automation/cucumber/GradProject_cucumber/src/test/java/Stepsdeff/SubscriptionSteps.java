package Stepsdeff;

import Pages.HomePagee;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SubscriptionSteps {
    WebDriver driver = Hooks.getDriver();
    HomePagee homePagee = new HomePagee(driver);
    @Given("User on home page and scroll down to footer")
    public void user_on_home_page_and_scroll_down_to_footer() {
         homePagee.scrollToFooter();
    }

    @When("User enter his email and click on arrow button")
    public void userEnterHisEmailAndClickOnArrowButton() {
        homePagee.EnterEmail("Esraam@gmail.com");
        homePagee.ClickOnSubscribeButton();
    }

    @Then("Verification message appears")
    public void verification_message_appears() {

       String ActualResult = homePagee.waitForValidationMessage();
       String ExpectedResult ="You have been successfully subscribed!";
       Assert.assertTrue(ActualResult.contains(ExpectedResult));



    }



}
