package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ContactUsFormPage {
    WebDriver driver;

    public ContactUsFormPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    private By contactUsButton = By.xpath("//a[@href='/contact_us']");
    private By getInTouchHeading = By.xpath("//h2[text()='Get In Touch']");
    private By nameInput = By.name("name");
    private By emailInput = By.name("email");
    private By subjectInput = By.name("subject");
    private By messageTextarea = By.id("message");
    private By uploadFileInput = By.name("upload_file");
    private By submitButton = By.name("submit");
    private By successMessage = By.cssSelector(".status.alert.alert-success");
    private By homeButton = By.xpath("//a[@href='/']//i[@class='fa fa-home']");

    // Methods
    public void clickContactUs() {
        WebElement element = driver.findElement(contactUsButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    public boolean isGetInTouchVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(getInTouchHeading)).isDisplayed();
    }

    public void enterName(String name) {
        driver.findElement(nameInput).sendKeys(name);
    }

    public void enterEmail(String email) {
        driver.findElement(emailInput).sendKeys(email);
    }

    public void enterSubject(String subject) {
        driver.findElement(subjectInput).sendKeys(subject);
    }

    public void enterMessage(String message) {
        driver.findElement(messageTextarea).sendKeys(message);
    }

    public void uploadFile(String fullFilePath) {
        driver.findElement(uploadFileInput).sendKeys(fullFilePath);
    }

    public void clickSubmit() {
        WebElement element = driver.findElement(submitButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    public void clickOKOnAlert() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
    }

    public boolean isSuccessMessageVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
        return message.getText().contains("Success! Your details have been submitted successfully.");
    }

    public void clickHome() {
        WebElement element = driver.findElement(homeButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    public boolean isHomePageVisible() {
        return driver.getCurrentUrl().equals("https://automationexercise.com/");
    }
}