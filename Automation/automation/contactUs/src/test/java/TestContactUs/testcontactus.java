package TestContactUs;

import Base.basetest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ContactUsFormPage;

public class testcontactus extends basetest {

    @Test
    public void testContactUsForm() {
        ContactUsFormPage contactPage = new ContactUsFormPage(driver);

        Assert.assertTrue(driver.getCurrentUrl().contains("automationexercise.com"));

        contactPage.clickContactUs();
        Assert.assertTrue(contactPage.isGetInTouchVisible());

        contactPage.enterName("Ahmed Ali");
        contactPage.enterEmail("ahmed.ali@test.com");
        contactPage.enterSubject("Product Inquiry");
        contactPage.enterMessage("Test message");

        // Use double backslash \\ and no extra quotes
        contactPage.uploadFile("C:\\Users\\dell\\Downloads\\labprobability1.pdf");

        contactPage.clickSubmit();
        contactPage.clickOKOnAlert();

        Assert.assertTrue(contactPage.isSuccessMessageVisible());

        contactPage.clickHome();
        Assert.assertTrue(contactPage.isHomePageVisible());
    }
}