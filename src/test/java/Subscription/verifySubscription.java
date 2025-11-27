package Subscription;

import Base.baseTests;
import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class verifySubscription extends baseTests {

    @Test
    public void VerifySubscriptionFunctionality() {

        //scroll down to footer
        homePagee.scrollToFooter();
        //Enter Email
       homePagee.EnterEmail("EsraaMohamed@gmail.com");
       // Click on Subscribe button
        homePagee.ClickOnSubscribeButton();
        // Verify Success Msg
        String ActualResult = homePagee.waitForValidationMessage();
        String ExpectedResult ="You have been successfully subscribed!";
        Assert.assertTrue(ActualResult.contains(ExpectedResult));


    }










}
