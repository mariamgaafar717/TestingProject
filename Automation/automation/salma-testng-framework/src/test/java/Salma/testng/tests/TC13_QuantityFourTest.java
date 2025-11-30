package Salma.testng.tests;

import Salma.testng.base.BaseTest;
import Salma.testng.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC13_QuantityFourTest extends BaseTest {

    @Test
    public void tc13() {
        HomePage home = new HomePage(driver);
        ProductsPage products = new ProductsPage(driver);
        CartPage cart = new CartPage(driver);

        home.open("https://automationexercise.com");
        home.goToProducts();

        products.setQuantityToFourAndAdd();
        products.clickViewCart();

        Assert.assertTrue(driver.getPageSource().contains("4"));
    }
}
