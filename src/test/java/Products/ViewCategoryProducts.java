package Products;

import Base.baseTests;
import Pages.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ViewCategoryProducts extends baseTests {

    ProductsPage productsPage;

    @Test
    public void verifyCategoryProducts() {

        productsPage = homePagee.ClickOnProducts();

        productsPage.clickCategory("Women", "Dress");

        Assert.assertTrue(productsPage.getCategoryTitle().contains("WOMEN - DRESS"),
                "Category title is incorrect!");

        Assert.assertTrue(productsPage.isCategoryProductsDisplayed(),
                "Category products are NOT visible!");
    }
}
