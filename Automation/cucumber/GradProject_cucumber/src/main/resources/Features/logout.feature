Feature: Logout Feature

  @Happy_Logout_Scenario
  Scenario: Logout from Account
    Given user enter valid username and password click on login button
    When user click on logout_2 button
    Then user check logout successfully