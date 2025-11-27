package Scroll;

import Base.baseTests;
import Pages.HomePagee;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ScrollupScrolldown extends baseTests {

    @Test
    public void Scroll() throws InterruptedException {

        homePagee.scrollToBottom();
        Thread.sleep(3000);
        //Verify that SUBSCRIPTION is Visible
     //Assertion
        String ActualResult = HomePagee.GetSubscription();
         String ExpectedResult =  "Subscription" ;
        Assert.assertTrue(ActualResult.equalsIgnoreCase(ExpectedResult));

     // click on arrow to move Upward
     homePagee.ClickOnArrow();

     //Verify that Page Scrolled Up
        String actualResult = HomePagee.VerifythatPageScrolledUp();
        String expectedResult = "Full-Fledged practice website for Automation Engineers" ;
        Assert.assertTrue(actualResult.contains(expectedResult));

    }
}
