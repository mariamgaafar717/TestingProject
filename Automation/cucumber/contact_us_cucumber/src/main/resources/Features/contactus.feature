Feature: Contact Us Feature

  @Contact_US_Scenario
  Scenario: contact us Scenario
    Given user in home  page click on contact us button and assert it
    When user enter his information data and click on submit button and alert
    Then assert message success and go home page and assert it correctly