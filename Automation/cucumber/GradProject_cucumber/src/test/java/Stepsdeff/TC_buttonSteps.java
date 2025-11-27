package Stepsdeff;

import Pages.HomePagee;
import Pages.TestCasesPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class TC_buttonSteps {
WebDriver driver = Hooks.getDriver();
HomePagee homePagee = new HomePagee(driver);
TestCasesPage testCasesPage ;
    @Given("User is on home page")
    public String user_is_on_home_page() {
        return homePagee.getParagraph();
    }
    @When("User click on Test case button")
    public void user_click_on_test_case_button() {
      TestCasesPage testCasesPage =homePagee.ClickONeTestCaseButton();
    }
    @Then("User is directed to Test Cases Page")
    public String user_is_directed_to_test_cases_page()  {
       return testCasesPage.GetTestCasesParagraph();
    }


}
