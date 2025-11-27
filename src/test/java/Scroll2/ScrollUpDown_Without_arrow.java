package Scroll2;

import Base.baseTests;
import Pages.HomePagee;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ScrollUpDown_Without_arrow extends baseTests {
    @Test
    public void scrollWithoutArrow()
    {
        //scroll down to bottom
        homePagee.scrollToBottom();
        //Verify Subscription is Visible
        String ActualResult = HomePagee.GetSubscription();
        String ExpectedResult =  "Subscription" ;
        Assert.assertTrue(ActualResult.equalsIgnoreCase(ExpectedResult));

        // scroll up to top
      homePagee.scrollToTop();

      //verify that page is scrolled up
        String actualResult = HomePagee.VerifythatPageScrolledUp();
        String expectedResult = "Full-Fledged practice website for Automation Engineers" ;
        Assert.assertTrue(actualResult.contains(expectedResult));

    }





}
