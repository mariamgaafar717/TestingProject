package Signup;

import Base_Test.base_test;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class signup extends base_test {
    public SignupPage signupPage;
    public Login_Signup_Page loginSignupPage;
    public Created_Account_Page createdAccountPage;
    public Delete_Account_Page deleteAccountPage;

    @Test
    public void signup(){
     loginSignupPage = homePage.Signup_login_link_clicl();
     loginSignupPage.enter_Name_signup();
     loginSignupPage.enter_Email_signup();
     signupPage=loginSignupPage.clickon_Signup_button();

     //question...
     //String acctualresult=signupPage.check_Enter_Account_word();
     //String expectedresult="Enter Account Information";
     Assert.assertTrue(signupPage.check_Enter_Account_word());

     signupPage.choose_title();
     signupPage.enter_password();
     signupPage.choose_Day();
     signupPage.choose_month();
     signupPage.choose_year();
     signupPage.clickon_newsletter();
     signupPage.clickon_receive_offer();
     signupPage.enter_first_name();
     signupPage.enter_last_name();
     signupPage.enter_company();
     signupPage.enter_addres1();
     signupPage.enter_address2();
     signupPage.enter_country();
     signupPage.enter_state();
     signupPage.enter_city();
     signupPage.enter_zipcode();
     signupPage.enter_mobile_number();
     createdAccountPage = signupPage.clickon_create_account_button();

     //question2-assertion
     //String acctualresult=createdAccountPage.check_on_Account_created_word();
     //String expectedresult="Account Created!";
     Assert.assertTrue(createdAccountPage.check_on_Account_created_word());

     createdAccountPage.clickon_Continue_button();
     homePage.checkConditionword_();
     deleteAccountPage=homePage.click_on_Delete_account_button();

     Assert.assertTrue(deleteAccountPage.check_Account_deleted_word());

     deleteAccountPage.clickon_Continue_button();



    }
}
