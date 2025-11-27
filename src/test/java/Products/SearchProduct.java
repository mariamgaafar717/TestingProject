package Products;

import Base.baseTests;
import Pages.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchProduct extends baseTests {

    ProductsPage productsPage;

    @Test
    public void verifySearchProduct() {

        // Go to Products Page
        productsPage = homePagee.ClickOnProducts();

        // Verify user is on All Products Page
        Assert.assertTrue(productsPage.isImageDisplayed(), "All products page is not displayed!");

        // Search for a product
        productsPage.searchForProduct("Dress");

        // Verify SEARCHED PRODUCTS section is visible
        Assert.assertTrue(productsPage.isSearchedProductsHeaderVisible(),
                "SEARCHED PRODUCTS header is not visible!");

        // Verify all search results are visible
        Assert.assertTrue(productsPage.areSearchResultsDisplayed(),
                "Search results are not displayed!");
    }
}
