Feature: TC17 - Remove Product from Cart

  Scenario: Remove product
    Given user opens home page
    When user goes to products page
    And user adds a product to cart and goes to cart
    And user removes the product
    Then cart should not contain that product
