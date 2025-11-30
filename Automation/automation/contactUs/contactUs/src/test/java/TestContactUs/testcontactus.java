package TestContactUs;

import Base.basetest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ContactUsFormPage;



public class testcontactus extends basetest {

    ContactUsFormPage contactPage;
    @Test
    public void testContactUsForm() {
        contactPage = homepage.clickContactUsForm();

        Assert.assertTrue(driver.getCurrentUrl().contains("automationexercise.com"));

        contactPage.clickContactUs();
        Assert.assertTrue(contactPage.isGetInTouchVisible());

        contactPage.enterName("Ahmed Ali");
        contactPage.enterEmail("ahmed.ali@test.com");
        contactPage.enterSubject("Product Inquiry");
        contactPage.enterMessage("Test message");
        contactPage.uploadFile("C:\\Users\\Dell\\Downloads\\Cucumber.pdf");
        //"C:\Users\Dell\Downloads\Cucumber.pdf"

        contactPage.clickSubmit();
        contactPage.clickOKOnAlert();

        Assert.assertTrue(contactPage.isSuccessMessageVisible());

        contactPage.clickHome();
        Assert.assertTrue(contactPage.isHomePageVisible());
    }
}