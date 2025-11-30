package Salma.testng.tests;

import Salma.testng.base.BaseTest;
import Salma.testng.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC11_AddToCartTest extends BaseTest {

    @Test
    public void tc11() {
        HomePage home = new HomePage(driver);
        ProductsPage products = new ProductsPage(driver);
        CartPage cart = new CartPage(driver);

        home.open("https://automationexercise.com");
        home.goToProducts();

        products.addFirstProductQuick();
        products.clickViewCart();

        Assert.assertTrue(cart.isCartDisplayed());
    }
}
