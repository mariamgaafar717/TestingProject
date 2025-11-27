package Stepsdeff;

import Pages.HomePagee;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Scroll_Steps {
    WebDriver driver = Hooks.getDriver();
    HomePagee homePagee = new HomePagee(driver);
    @Given("User is on home page and scroll down to bottom")
    public void user_is_on_home_page_and_scroll_down_to_bottom() {
       homePagee.scrollToBottom();
    }
    @When("User Click on Arrow button to move upward")
    public void user_click_on_arrow_button_to_move_upward() {
       homePagee.ClickOnArrow();
    }
    @Then("page is scrolled up and Full-Fledged practice website for Automation Engineers text is visible on screen")
    public void page_is_scrolled_up_and_full_fledged_practice_website_for_automation_engineers_text_is_visible_on_screen() {
      String ActualResult = homePagee.VerifythatPageScrolledUp();
      String ExpectedResult = "Full-Fledged practice website for Automation Engineers";
      Assert.assertTrue(ActualResult.contains(ExpectedResult));

    }


    @When("User scroll up page to top")
    public void userScrollUpPageToTop() {
        homePagee.scrollToTop();
    }
}
