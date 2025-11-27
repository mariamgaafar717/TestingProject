package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePagee {

    static WebDriver driver ;
    WebDriverWait wait ;
    public HomePagee(WebDriver driver) {

        this.driver = driver;

    }
    //Locators

    private static By homePageParagraph = By.xpath("//h2[contains(text(),'Full-Fledged practice' )]");
    private  By testCaseButton = By.className("test_cases_list");
    private By productsButton = By.xpath("//a[@href='/products']");
    private By Arrow = By.id("scrollUp");
    private static By scrollUp = By.xpath("//h2[contains(text(),'Full-Fledged practice' )]");
    private By footerSection = By.id("footer");
    private static By SubscriptionBox = By.xpath("//h2[contains(text(),'Subscription')]");
    private By ValidationMessage = By.xpath("//*[contains(text(),'You have been successfully subscribed!')]");
    private By email = By.id("susbscribe_email");
    private By SubscribeButton = By.id("subscribe");
    //Actions
    public static String getParagraph()
    {
       String paragraph = driver.findElement(homePageParagraph).getText();
       return paragraph ;

    }
public TestCasesPage ClickONeTestCaseButton()
{
    driver.findElement(testCaseButton).click();
    return new TestCasesPage(driver);
}
    public ProductsPage ClickOnProducts() {
        driver.findElement(productsButton).click();

        // Handle iframe ads
        try {
            // Wait a bit for ad to load
            Thread.sleep(1500);

            // Switch to iframe if it exists
            driver.switchTo().frame("aswift_5");
            driver.switchTo().frame("ad_iframe");

            // Try to close the ad
            WebElement closeBtn = driver.findElement(By.id("dismiss-button"));
            if (closeBtn.isDisplayed()) {
                closeBtn.click();
            }

            // Return to main page DOM
            driver.switchTo().defaultContent();

        } catch (Exception e) {
            driver.switchTo().defaultContent();  // always return to main DOM
        }

        return new ProductsPage(driver);
    }

public void scrollToBottom() {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }
    // Scroll down to footer
    public void scrollToFooter() {
        WebElement footer = driver.findElement(footerSection);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", footer);
    }
public static String GetSubscription()
{
     String h2 = driver.findElement(SubscriptionBox).getText();
     return h2 ;

}
public void EnterEmail(String Email)
{
    driver.findElement(email).sendKeys(Email);
}
public void ClickOnSubscribeButton()
{
    driver.findElement(SubscribeButton).click();
}
    // Explicit Wait to verify success message
    public String waitForValidationMessage() {

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(ValidationMessage));
      return driver.findElement(ValidationMessage).getText();
    }
public void  ClickOnArrow()
{
    driver.findElement(Arrow).click();
}

public static String VerifythatPageScrolledUp()
{
    String text = driver.findElement(scrollUp).getText();
    return text ;
}

    // Scroll Up to Top Action
    public void scrollToTop() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 0);");
    }



}
