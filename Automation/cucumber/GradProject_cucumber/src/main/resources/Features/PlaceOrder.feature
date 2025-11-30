Feature: Place Order Functionality

  @PlaceOrder @RegisterWhileCheckout
  Scenario: Place Order: Register while Checkout
    Given User is on home page
    When User adds product to cart
    And User clicks on cart button
    And User proceeds to checkout
    And User clicks on Register Login button
    # Registration
    And User enters name "Ahmed" and email "Ahmed_Test_BDD@test.com" in Signup
    And User clicks on Signup button
    And User fills Account Details and clicks Create Account
    Then Account created message is visible
    # Continue
    When User clicks Continue button
    Then User is logged in as "Ahmed"
    # Checkout
    When User clicks on cart button
    And User proceeds to checkout
    And User enters comment "All is great" and places order
    # Payment
    And User enters payment details Name "Ahmed", Card "4738650300211862", CVC "848", Month "02", Year "2030"
    And User clicks Pay and Confirm Order
    Then Success message "Congratulations! Your order has been confirmed!" is displayed
    # Delete Account
    When User deletes the account
    Then Account Deleted message is visible


  @PlaceOrder @RegisterBeforeCheckout
  Scenario: Place Order: Register before Checkout
    Given User is on home page
    When User clicks on Signup Login button
    # Registration
    And User enters name "Eman" and email "Eman_Test_BDD@test.com" in Signup
    And User clicks on Signup button
    And User fills Account Details and clicks Create Account
    Then Account created message is visible
    # Continue
    When User clicks Continue button
    Then User is logged in as "Eman"
    # Add Product & Checkout
    When User adds product to cart
    And User clicks on cart button
    And User proceeds to checkout
    # Comment & Pay
    And User enters comment "All is great" and places order
    And User enters payment details Name "Eman", Card "4738650300211862", CVC "848", Month "02", Year "2030"
    And User clicks Pay and Confirm Order
    Then Success message "Congratulations! Your order has been confirmed!" is displayed
    # Delete Account
    When User deletes the account
    Then Account Deleted message is visible