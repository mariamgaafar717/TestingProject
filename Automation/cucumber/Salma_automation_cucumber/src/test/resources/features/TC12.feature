Feature: TC12 - Add Products in Cart

  Scenario: Add two products to cart
    Given user opens home page
    When user goes to products page
    And user adds two products to cart
    Then user should see products in cart
