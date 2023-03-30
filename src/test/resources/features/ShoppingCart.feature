@Debug
Feature: Shopping cart test scenarios

  Scenario: Products added to the cart are displayed in the cart page with their corresponding quantity and price
    Given I'm on the "HOME" page
    And I add the following products to the cart:
      | Product Name |
      | iPod Nano    |
      | HP LP3065    |
    And I click the cart button from the header bar
    Then I'm taken to the "checkout/cart" page
    And The cart contains the following products:
      | Product Name | Model      | Quantity | Unit Price | Total   |
      | iPod Nano    | Product 9  | 1        | $122.00    | $122.00 |
      | HP LP3065    | Product 21 | 1        | $122.00    | $122.00 |
    And The total amount to pay is "$244.00"