package Salma.testng.base;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected JavascriptExecutor js;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        this.js = (JavascriptExecutor) driver;
    }

    protected WebElement find(By locator) {
        return driver.findElement(locator);
    }

    protected void waitVisible(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected WebElement waitAndGet(By locator) {
        waitVisible(locator);
        return find(locator);
    }

    protected void click(By locator) {
        waitAndGet(locator).click();
    }

    protected void jsClick(By locator) {
        WebElement el = waitAndGet(locator);
        js.executeScript("arguments[0].click();", el);
    }

    protected void type(By locator, String text) {
        WebElement el = waitAndGet(locator);
        el.clear();
        el.sendKeys(text);
    }

    protected void scrollBottom() {
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    protected void clear(By locator) {
        WebElement el = waitAndGet(locator);
        el.clear();
    }

    protected void scrollIntoView(By locator) {
        WebElement el = waitAndGet(locator);
        js.executeScript("arguments[0].scrollIntoView(true);", el);
    }
}
