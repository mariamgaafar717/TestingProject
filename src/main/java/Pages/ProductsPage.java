package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductsPage {

    static WebDriver driver;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    // ------------------- LOCATORS -------------------

    // All Products page image check
    private By sale_image_check = By.id("sale_image");

    // View Product
    private By viewProductButton = By.xpath("//a[@href='/product_details/1']");


    // ------- TC09: Search Product -------
    private By searchInput = By.id("search_product");
    private By searchButton = By.id("submit_search");
    private By searchedProductsHeader = By.xpath("//h2[contains(text(),'Searched Products')]");
    private By searchResults = By.xpath("//div[@class='productinfo text-center']");


    // ------- TC18: Categories -------
    private By categoryWomen = By.xpath("//a[contains(text(),'Women')]");
    private By categoryWomenDress = By.xpath("//a[contains(text(),'Dress')]");
    private By categoryTitle = By.xpath("//h2[@class='title text-center']");


    // ------- TC19: Brands -------
    private By brandList = By.xpath("//div[@class='brands_products']/h2");
    private By poloBrand = By.xpath("//a[contains(text(),'Polo')]");
    private By brandTitle = By.xpath("//h2[@class='title text-center']");
    private By brandProducts = By.xpath("//div[@class='productinfo text-center']");


    // ------------------- ACTIONS -------------------

    // TC08 - Verify navigation to All Products page
    public boolean isImageDisplayed() {
        return driver.findElement(sale_image_check).isDisplayed();
    }

    public void ScrollToTheProductsList() {
        WebElement firstProduct = driver.findElement(viewProductButton);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", firstProduct);
    }

    public Product_detailPage ClickOnViewProductButton() {
        driver.findElement(viewProductButton).click();
        return new Product_detailPage(driver);
    }


    // ------------------- TC09: Search Product -------------------

    public void searchForProduct(String name) {
        driver.findElement(searchInput).sendKeys(name);
        driver.findElement(searchButton).click();
    }

    public boolean isSearchedProductsHeaderVisible() {
        return driver.findElement(searchedProductsHeader).isDisplayed();
    }

    public boolean areSearchResultsDisplayed() {
        return driver.findElements(searchResults).size() > 0;
    }


    // ------------------- TC18: View Category Products -------------------

    public void clickCategory(String main, String sub) {

        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Scroll to categories section
        js.executeScript("window.scrollBy(0, 800);");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        if (main.equalsIgnoreCase("Women")) {

            // Click Women category
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='#Women']"))).click();
        }

        if (sub.equalsIgnoreCase("Dress")) {

            // Wait for subcategory to appear and click it
            wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//div[@id='Women']//a[contains(text(),'Dress')]")
            )).click();
        }
    }


    public String getCategoryTitle() {
        return driver.findElement(categoryTitle).getText();
    }

    public boolean isCategoryProductsDisplayed() {
        return driver.findElements(searchResults).size() > 0;
    }


    // ------------------- TC19: View Brand Products -------------------

    public BrandProductsPage clickOnBrand(String brandName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        By brandLocator = By.xpath("//ul[contains(@class,'nav nav-pills')]//a[contains(normalize-space(.),'" + brandName + "')]");

        // Wait for element to exist
        WebElement brand = wait.until(ExpectedConditions.presenceOfElementLocated(brandLocator));

        // Scroll and click via JS
        js.executeScript("arguments[0].scrollIntoView({block:'center'});", brand);
        js.executeScript("arguments[0].click();", brand);

        return new BrandProductsPage(driver);
    }



}
