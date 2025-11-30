Feature: Sign up Feature

  @Signup_Scenario
  Scenario: Sign up with new email
    Given user enter name,email,click on signup button and assert signup page
    When user enter signup data and click on create button
    And check created account and click on continue and homepage assert
    Then delete account and assert and click on continue button

