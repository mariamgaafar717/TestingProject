package Salma.testng.tests;

import Salma.testng.base.BaseTest;
import Salma.testng.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC12_RemoveFromCartTest extends BaseTest {

    @Test
    public void tc12() {
        HomePage home = new HomePage(driver);
        ProductsPage products = new ProductsPage(driver);
        CartPage cart = new CartPage(driver);

        home.open("https://automationexercise.com");
        home.goToProducts();

        products.addFirstProductQuick();
        products.clickViewCart();

        cart.removeProduct();

        Assert.assertFalse(driver.getPageSource().contains("Product"), "Product was not removed");
    }
}
