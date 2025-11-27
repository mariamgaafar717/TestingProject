package HomePage;

import Base.baseTests;
import Pages.HomePagee;
import Pages.TestCasesPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestcasePage extends baseTests {

    @Test
    public void verifyTestCasePage()
    {

      TestCasesPage testCasesPage  =homePagee.ClickONeTestCaseButton();

    //Verify that user is navigated to test cases page successfully
    // assertion
        String ActualResult2 = TestCasesPage.GetTestCasesParagraph();
        String ExpectedResult2 = "Test Cases" ;
        Assert.assertTrue(ActualResult2.equalsIgnoreCase(ExpectedResult2));
    }


}

