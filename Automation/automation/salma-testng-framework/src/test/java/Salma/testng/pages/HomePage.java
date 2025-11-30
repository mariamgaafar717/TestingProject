package Salma.testng.pages;

import Salma.testng.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private By productsBtn = By.xpath("//a[contains(text(),'Products')]");
    private By cartBtn = By.xpath("//a[contains(@href,'/view_cart')]");
    private By subscribeInput = By.id("susbscribe_email");
    private By subscribeBtn = By.id("subscribe");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void open(String url) {
        driver.get(url);
    }

    public void goToProducts() {
        click(productsBtn);
    }

    public void goToCart() {
        click(cartBtn);
    }

    public void scrollToBottom() {
        scrollBottom();
    }

    public void subscribeFooter(String email) {
        type(subscribeInput, email);
        click(subscribeBtn);
    }
}
