package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BrandProductsPage {

    WebDriver driver;

    public BrandProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    private By brandTitle = By.xpath("//h2[@class='title text-center']");
    private By brandProducts = By.xpath("//div[@class='productinfo text-center']");

    public String getBrandTitle() {
        return driver.findElement(brandTitle).getText();
    }

    public boolean areBrandProductsDisplayed() {
        return driver.findElements(brandProducts).size() > 0;
    }
}
