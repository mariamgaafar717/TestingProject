package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestCasesPage {
 static WebDriver driver;

    public TestCasesPage(WebDriver driver) {
        this.driver = driver ;
    }

   //Locators
private static By testcasesParagraph = By.xpath("//b[contains(text(),'Test')]");

    //Actions
public static String GetTestCasesParagraph()
{
    String TestCasesPara=driver.findElement(testcasesParagraph).getText();
    return TestCasesPara ;

}


}
