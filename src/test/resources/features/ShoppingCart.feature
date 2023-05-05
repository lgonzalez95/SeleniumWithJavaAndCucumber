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
    When I click the "CHECKOUT" button of the "CART" page
    Then I'm taken to the "checkout/checkout" page
    When I continue my checkout as a "Guest Checkout"
    And I enter the following billing details:
      | firstName | lastName | email            | telephone    | company      | address1         | address2 | city         | postCode | country       | regionOrState |
      | John      | Howard   | jhoward@test.com | +17079700000 | Best Company | 5102 Dowdell Ave | Apt #5   | Rohnert Park | 94928    | United States | California    |
    And My billing and delivery addresses "are not" the same
    And I enter the following delivery details
      | firstName | lastName | company      | address1         | address2 | city         | postCode | country       | regionOrState |
      | John      | Howard   | Best Company | 5102 Dowdell Ave | Apt #5   | Rohnert Park | 94928    | United States | California    |
    And I set the delivery method to "Flat Shipping Rate"
#    And I set the payment method to "Cash On Delivery"
#    And I accept the payment method terms and conditions
#    And I confirm the order
#    Then The order is placed successfully


