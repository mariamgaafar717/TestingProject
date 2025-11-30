package Delete_Account;

import Base_Test.base_test;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Login_Signup_Page;

public class delete_account extends base_test {

    Login_Signup_Page loginSignupPage;

    @Test
    public void delete_account_button(){
        loginSignupPage =homePage.Signup_login_link_clicl();
        loginSignupPage.Emailbox_of_login_enter("abdelrahmansalem609@gmail.com");
        loginSignupPage.passwordbox_of_login_enter("12345");
        loginSignupPage.button_of_login();
        homePage.click_on_Delete_account_button();

        /*String acctualresult=loginSignupPage.Check_login_from_logout_word();
        String expectedresult="Login to your account";
        Assert.assertTrue(acctualresult.contains(expectedresult));*/
    }
}

