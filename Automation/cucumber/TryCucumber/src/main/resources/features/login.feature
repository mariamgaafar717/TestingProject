Feature: Products Management
  As a user of the automation exercise website
  I want to search, add products to cart, and write reviews
  So that I can manage my shopping experience

  Scenario: Search for a product add to cart and verify after login
    Given I am on the home page
    When I navigate to the products page
    Then I should see the "ALL PRODUCTS" page
    When I search for "Dress"
    Then I should see "SEARCHED PRODUCTS" heading
    And all displayed products should be related to "Dress"
    When I add the searched products to cart
    And I view my cart
    Then the searched products should be visible in the cart
    When I login with email "samsomaahmed8@gmail.com" and password "12345"
    And I navigate to the products page
    And I view my cart
    Then the searched products should still be visible in the cart

  Scenario: Write a review for a product
    Given I am on the home page
    When I navigate to the products page
    Then I should see the "ALL PRODUCTS" page
    When I click on view product details
    And I write a review with name "Sama", email "sammsomaahmed8@gmail.com", and review "This product is amazing!"
    And I submit the review
    Then the review should be submitted successfully