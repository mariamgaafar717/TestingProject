Feature: TC11 - Subscription in Cart Page

  Scenario: Verify subscription in cart page
    Given user opens home page
    When user navigates to cart page
    And user enters email to subscribe in cart footer
    Then subscription should be successful