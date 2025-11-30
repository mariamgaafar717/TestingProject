Feature: TC22 - Add Recommended Item

  Scenario: Add from recommended items
    Given user opens home page
    When user scrolls to recommended items and adds one to cart
    Then user should see it in cart
