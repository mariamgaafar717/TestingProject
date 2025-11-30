package StepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.ContactUsFormPage;
import pages.HomePage;

public class contactus_steps {

    public WebDriver driver = Hooks.getdriver();
    public HomePage homepage = new HomePage(driver);
    public ContactUsFormPage contactPage;

    @Given("user in home  page click on contact us button and assert it")
    public void user_in_home_page_click_on_contact_us_button_and_assert_it() {

        contactPage = homepage.clickContactUsForm();

        Assert.assertTrue(driver.getCurrentUrl().contains("automationexercise.com"));

        contactPage.clickContactUs();
        Assert.assertTrue(contactPage.isGetInTouchVisible());
    }

    @When("user enter his information data and click on submit button and alert")
    public void userEnterHisInformationDataAndClickOnSubmitButtonAndAlert() {

        contactPage.enterName("Ahmed Ali");
        contactPage.enterEmail("ahmed.ali@test.com");
        contactPage.enterSubject("Product Inquiry");
        contactPage.enterMessage("Test message");
        contactPage.uploadFile("C:\\Users\\Dell\\Downloads\\Cucumber.pdf");

        contactPage.clickSubmit();
        contactPage.clickOKOnAlert();
    }

    @Then("assert message success and go home page and assert it correctly")
    public void assertMessageSuccessAndGoHomePageAndAssertItCorrectly() {

        Assert.assertTrue(contactPage.isSuccessMessageVisible());

        contactPage.clickHome();
        Assert.assertTrue(contactPage.isHomePageVisible());
    }
}
