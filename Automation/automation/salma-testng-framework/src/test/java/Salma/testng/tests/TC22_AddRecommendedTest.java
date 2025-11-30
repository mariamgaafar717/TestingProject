package Salma.testng.tests;

import Salma.testng.base.BaseTest;
import Salma.testng.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC22_AddRecommendedTest extends BaseTest {

    @Test
    public void tc22() {
        HomePage home = new HomePage(driver);
        CartPage cart = new CartPage(driver);

        home.open("https://automationexercise.com");
        home.scrollToBottom();

        cart.addRecommended();

        Assert.assertTrue(driver.getPageSource().contains("View Cart"));
    }
}
