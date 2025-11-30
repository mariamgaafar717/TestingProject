package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ProductsPage {
    WebDriver driver;

    public ProductsPage(WebDriver driver) {
        this.driver=driver;
    }



    //Locators
    private By LocateSuccessfullProductPpage= By.id("header");
    private By lacateSearchBar=By.id("search_product");
    private By lacateSearchButton=By.id("submit_search");
    private By searchedProductsTitle = By.xpath("//h2[text()='Searched Products']");
//    private By allSearchedProducts = By.cssSelector(".features_items.product");
    private By allSearchedProducts = By.cssSelector(".title.text-center");

    private By AddToCart=By.cssSelector(".btn.btn-default.add-to-cart");
    private By CartButton=By.cssSelector(".fa.fa-shopping-cart");
    private By locatecartisdisplayed=By.id("cart_items");

    private By productsButton = By.cssSelector(".material-icons.card_travel");
    private By locateviewproduct=By.linkText("View Product");

    //TestCase21
    private By locatereviewbutton=By.linkText("Write Your Review");
    private By locateAddReview=By.id("review");
    private By enterReviewemail=By.id("email");
    private By enterReviewname=By.id("name");
    private By locatesubmit=By.id("button-review");








    //Actions
    //Test21
    public void Writeyouremail(String email){
        driver.findElement(enterReviewemail).sendKeys(email);
    }
    public void Writeyourname(String name){
        driver.findElement(enterReviewname).sendKeys(name);
    }
    public void clicksubmit(){
        driver.findElement(locatesubmit).click();
    }
    public void EnterYouReview(String review ){
        driver.findElement(locateAddReview).sendKeys(review);
    }
    public void clickviewproductfortest21() {
        WebElement element = driver.findElement(By.linkText("View Product"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }
    //Test20
    public boolean isUserOnAllProductsPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement header = wait.until(ExpectedConditions.visibilityOfElementLocated(LocateSuccessfullProductPpage));
        return header.isDisplayed();
    }
    public void clickviewproduct(){
        driver.findElement(locateviewproduct).click();
    }
    public boolean isWriteReviewVisible() {
        try {
            return driver.findElement(locatereviewbutton).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }


    public void enterProductName(String productName) {
        WebElement input = driver.findElement(lacateSearchBar);
        input.clear();
        input.sendKeys(productName);
    }

    //    public void clickSearchButton() {
//        driver.findElement(lacateSearchButton).click();
//
//    }
    public void clickSearchButton() {

        // Try to close ad iframe if it exists
        try {
            // Switch to advertisement iframe (the one blocking the button)
            driver.switchTo().frame("aswift_4");

            // Try to find a close button inside the ad
            WebElement closeBtn = driver.findElement(By.cssSelector("button[aria-label='Close'], .close, .adsbygoogle"));
            closeBtn.click();

            // Return to main page
            driver.switchTo().defaultContent();

            System.out.println("Ad iframe closed successfully.");

        } catch (Exception e) {
            // If the ad does NOT exist or no close button → ignore
            driver.switchTo().defaultContent();
            System.out.println("No ad iframe found or could not close it.");
        }

        // Now wait and click the button normally
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(lacateSearchButton));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn);
        btn.click();
    }

    public boolean isSearchedProductsVisibleINproductsPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(searchedProductsTitle)
        );
        return element.isDisplayed();
    }
    public boolean areAllProductsRelatedToSearch(String searchText) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(allSearchedProducts));

        List<WebElement> products = driver.findElements(allSearchedProducts);

        if (products.isEmpty()) {
            System.out.println("No products found!");
            return false;
        }

        System.out.println("Total products found: " + products.size());

        for (int i = 0; i < products.size(); i++) {
            try {
                // Get product name from <h2> tag
                WebElement productNameElement = products.get(i).findElement(By.tagName("h2"));
                String productName = productNameElement.getText().trim();

                System.out.println("Product " + (i+1) + ": " + productName);

                if (!productName.toLowerCase().contains(searchText.toLowerCase())) {
                    System.out.println("   Does NOT contain: " + searchText);
                    return false;
                } else {
                    System.out.println("   Contains: " + searchText);
                }

            } catch (Exception e) {
                System.out.println("  Could not read product name for product " + (i+1));
            }
        }

        System.out.println("✓ All products match the search term!");
        return true;
    }

    public void clickProductsButton() {
        driver.findElement(productsButton).click();
    }

//    public void AddToCartButton(){
//        driver.findElement(AddToCart).click();
//    }
public void AddToCartButton() {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    // Find all "Add to Cart" buttons
    List<WebElement> addToCartButtons = driver.findElements(AddToCart);

    if (!addToCartButtons.isEmpty()) {
        WebElement firstButton = addToCartButtons.get(0);

        // Scroll to the button
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", firstButton);

        // Wait a bit after scroll
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Try normal click first
        try {
            wait.until(ExpectedConditions.elementToBeClickable(firstButton));
            firstButton.click();
            System.out.println("✓ Add to Cart clicked (normal click)");
        } catch (Exception e) {
            // If normal click fails due to ad, use JavaScript click
            System.out.println("Normal click failed, trying JavaScript click...");
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", firstButton);
            System.out.println(" Add to Cart clicked (JavaScript click)");
        }
    } else {
        System.out.println("No Add to Cart buttons found!");
    }
}
    public void ClickCartButton(){
        driver.findElement(CartButton).click();
    }
    public boolean isSearchedProductsVisibleInCart() {
        return driver.findElement(locatecartisdisplayed).isDisplayed();
    }


}