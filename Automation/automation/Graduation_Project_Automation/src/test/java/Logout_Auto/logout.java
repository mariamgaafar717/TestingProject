package Logout_Auto;

import Base_Test.base_test;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Login_Signup_Page;

public class logout extends base_test {
    Login_Signup_Page loginSignupPage;

    @Test
    public void logout_button(){
        loginSignupPage =homePage.Signup_login_link_clicl();
        loginSignupPage.Emailbox_of_login_enter("abdosalem3200@gmail.com");
        loginSignupPage.passwordbox_of_login_enter("12345@");
        loginSignupPage.button_of_login();
        homePage.clickon_Logout_button();


        String acctualresult=loginSignupPage.Check_login_from_logout_word();
        String expectedresult="Login to your account";
        Assert.assertTrue(acctualresult.contains(expectedresult));

    }
}
