package PlaceOrder;

import Base.Base_test;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class RegisterWhileCheckout extends Base_test {
    @Test
    public void AddProducts() throws InterruptedException {
        homePage.ScrollToTheProductsList();
        homePage.ClickOnViewProductButton();
        productDetailPage.ClickOnAddToCart();
        Thread.sleep(1500);
        CartPage cartPage = productDetailPage.ClickOnViewCart();
        cartPage.ClickOnProceedToCheckout();
        LoginPage loginPage = cartPage.ClickOnRegisterButton();
        loginPage.EnterName("Ahmed");
        loginPage.EnterEmail("Ahmed24629@gmail.com");
        loginPage.ClickOnSignUpButton();
        //Fill all details in Signup
        Thread.sleep(3000);
        SignUpPage.choose_title();
        SignUpPage.enter_password();
        SignUpPage.choose_Day();
        SignUpPage.choose_month();
        SignUpPage.choose_year();
        SignUpPage.clickon_newsletter();
        SignUpPage.clickon_receive_offer();
        SignUpPage.enter_first_name();
        SignUpPage.enter_last_name();
        SignUpPage.enter_company();
        SignUpPage.enter_addres1();
        SignUpPage.enter_address2();
        SignUpPage.enter_country();
        SignUpPage.enter_state();
        SignUpPage.enter_city();
        SignUpPage.enter_zipcode();
        SignUpPage.enter_mobile_number();
        //create account
        CreatedAccountPage createdAccountPage = SignUpPage.clickCnCreateAccountButton();
        //Verify Account created
        String ActualResult = createdAccountPage.CheckThatAccountCreated();
        String ExpectedResult = "Congratulations! Your new account has been successfully created!";
        Assert.assertTrue(ActualResult.contains(ExpectedResult));
        // click Continue button
        createdAccountPage.ClickOnContinueButton();
        // Verify logged in as username at top
        String actualResult = homePage.CheckLoggedInAsUsername();
        String expectedResult = "Logged in as";
        Assert.assertTrue(actualResult.contains(expectedResult));
        //click cart button
       CartPage cartPage2 =homePage.ClickOnCartButton();
       //click on proceed to checkout
      CheckOutPage checkOutPage = cartPage.ClickOnProceedToCheckout();

      //Enter description and Click on place order
    checkOutPage.WriteComment("All is great");
    PaymentPage paymentPage = checkOutPage.ClickOnPlaceOrder();

    //Payment Details
        paymentPage.EnterCartName("Ahmed");
        paymentPage.EnterCartNumer("4738650300211862");
        paymentPage.EnterCVC("848");
        paymentPage.EnterExpirationMon("2");
        paymentPage.EnterExpirationYear("2030");
    // click on payAndConfirmOrder
        PaymentDonePage paymentDonePage = paymentPage.ClickOnConfirmOrderButton();

        //Verify success Message
    String ActualResult11 = paymentDonePage.GetMsg();
    String ExpectedResult11 = "Congratulations! Your order has been confirmed!";
    Assert.assertTrue(ActualResult11.contains(ExpectedResult11));

    // Click Delete Account button
      DeleteAccountPage deleteAccountPage = paymentDonePage.ClickOnDeleteAccountButton();
     //  Verify ACCOUNT DELETED!
   String ActualResult222 = deleteAccountPage.getDeleteMessage();
   String ExpectedResult222= "Account Deleted!";
   Assert.assertTrue(ActualResult222.equalsIgnoreCase(ExpectedResult222));

        //click Continue button
     HomePage homepage = deleteAccountPage.ClickOnContinueeButton();
    }

}
