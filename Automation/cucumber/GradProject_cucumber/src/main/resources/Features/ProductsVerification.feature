Feature: Verify Search, Categories, and Brands functionality

  Background:
    # This step is reused from your existing code
    Given User is on home page and click on Products button

  @SearchProduct
  Scenario: Search Product and verify results
    When User searches for product "Dress"
    Then "SEARCHED PRODUCTS" header is visible
    And The search results are displayed

  @CategoryProduct
  Scenario: View Category Products
    When User clicks on category "Women" and subcategory "Dress"
    Then The category title should be "WOMEN - DRESS"
    And The category products are displayed

  @BrandProduct
  Scenario: View Brand Products
    When User clicks on Brand "Polo"
    Then The Brand Page title should contain "Polo"
    And The Brand products are displayed