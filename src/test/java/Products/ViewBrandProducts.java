package Products;

import Base.baseTests;
import Pages.BrandProductsPage;
import Pages.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ViewBrandProducts extends baseTests {
    ProductsPage productsPage;
    BrandProductsPage brandProductsPage;

    @Test
    public void verifyBrandProducts() {

        // Step 1: Go to Products page
        productsPage = homePagee.ClickOnProducts();
        Assert.assertTrue(productsPage.isImageDisplayed(),
                "Products page did NOT load correctly!");

//        // Step 2: Scroll to the Brands section
//        productsPage.scrollToBrandsSection();

        // Step 3: Click the first brand (Polo)
        brandProductsPage = productsPage.clickOnBrand("Polo");

        Assert.assertTrue(
                brandProductsPage.getBrandTitle().contains("POLO"),
                "Brand header does not contain POLO!"
        );

        // Step 4: Verify Polo products are displayed
        Assert.assertTrue(
                brandProductsPage.areBrandProductsDisplayed(),
                "No products displayed for Polo brand!"
        );

        // Step 5: Click second brand (H&M)
        brandProductsPage = productsPage.clickOnBrand("H&M");

        Assert.assertTrue(
                brandProductsPage.getBrandTitle().contains("H&M"),
                "Brand header does not contain H&M!"
        );

        Assert.assertTrue(
                brandProductsPage.areBrandProductsDisplayed(),
                "No products displayed for H&M brand!"
        );
    }
}
