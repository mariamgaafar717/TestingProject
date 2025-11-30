package products;

import Base.basetest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductsPage;
import pages.SignPage;

public class products_test extends basetest {

    @Test
    public void testSearchAddToCartAndLoginFlow() {
        ProductsPage productspage = homepage.clickproductspage();



        productspage.clickProductsButton();


        Assert.assertTrue(productspage.isUserOnAllProductsPage(), "Not on ALL PRODUCTS page");


        String searchProduct = "Dress";
        productspage.enterProductName(searchProduct);
        productspage.clickSearchButton();


        Assert.assertTrue(productspage.isSearchedProductsVisibleINproductsPage(),
                "'SEARCHED PRODUCTS' is not visible");


        Assert.assertTrue(productspage.areAllProductsRelatedToSearch(searchProduct),
                "Not all products are related to the search");


        productspage.AddToCartButton();


        productspage.ClickCartButton();
        Assert.assertTrue(productspage.isSearchedProductsVisibleInCart(),
                "Products are not visible in cart");

        SignPage signpage=homepage.clicksignpage();

        signpage.Emailbox_of_login_enter("samsomaahmed8@gmail.com");
        signpage.passwordbox_of_login_enter("12345");
        signpage.button_of_login();

        productspage.ClickCartButton();


        Assert.assertTrue(productspage.isSearchedProductsVisibleInCart(),
                "Products are not visible in cart after login");
    }

    @Test
    public void testRviewproduct() {

        ProductsPage productspage = homepage.clickproductspage();
        productspage.clickProductsButton();


        Assert.assertTrue(productspage.isUserOnAllProductsPage(),
                "Not on ALL PRODUCTS page");


        productspage.clickviewproductfortest21();


        productspage.Writeyourname("Sama");
        productspage.Writeyouremail("sammsomaahmed8@gmail.com");
        productspage.EnterYouReview("This product is amazing!");


        productspage.clicksubmit();

    }
}

