package Salma.testng.tests;

import Salma.testng.base.BaseTest;
import Salma.testng.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC17_SubscribeFooterTest extends BaseTest {

    @Test
    public void tc17() {
        HomePage home = new HomePage(driver);

        home.open("https://automationexercise.com");
        home.scrollToBottom();

        String email = "salma" + System.currentTimeMillis() + "@test.com";
        home.subscribeFooter(email);

        Assert.assertTrue(driver.getPageSource().toLowerCase().contains("success"));
    }
}
