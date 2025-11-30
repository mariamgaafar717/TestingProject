Feature: Login Feature

  @Happy_Login_Scenario
  Scenario: Login with valid username and password
    Given user enter valid data and click on login button
    When user go to home page and check successful login
    Then user click on logout button

  @Invalid_Username_Scenario
  Scenario: Login with invalid username
     Given user enter data with invalid username
     When click on to login button
     Then user check error message

  @Invalid_Password_Scenario
  Scenario: Login with invalid password
     Given user enter data with invalid password
     When click on to login button
     Then user check error message
