Feature: TC13 - Verify Product Quantity in Cart

  Scenario: Increase quantity to 4
    Given user opens home page
    When user goes to products page
    And user increases product quantity to 4 and adds to cart
    Then cart should show quantity 4