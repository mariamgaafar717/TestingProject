Feature: Verify products and products detail page
  Scenario: Verify that user can navigated successfully to Products and Product detail page
    Given User is on home page and click on Products button
    When  User Scroll to the first product and click on view product button
    Then  User is  landed to product detail page of the first product
