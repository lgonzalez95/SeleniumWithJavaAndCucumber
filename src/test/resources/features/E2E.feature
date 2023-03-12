@Debug
Feature: Checkout process of an order

  Scenario: Placing an order for a guest customer
    Given I'm on the "HOME" page
    And I add the following products to the cart:
      | Product Name |
      | iPod Nano    |
      | HP LP3065    |
    And I click the checkout button from the header bar
#    And I continue my order as a "Guest Checkout"
#    And I enter the following billing details
#    And I accept the payment methods term and conditions
#    Then I cannot continue with my order since the following error occurs "Warning: Payment method required!"