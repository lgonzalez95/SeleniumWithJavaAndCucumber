@Debug
Feature: Register account tests

  Scenario: Validation messages are displayed when no values are entered
    Given I'm on the "REGISTER" page
    And I click the continue button
    Then The following validation messages are displayed for the register account fields
      | FieldName  | ValidationMessage                              |
      | First Name | Last Name must be between 1 and 32 characters! |
      | Last Name  | Last Name must be between 1 and 32 characters! |
      | Email      | E-Mail Address does not appear to be valid!    |
      | Telephone  | Telephone must be between 3 and 32 characters! |
      | Password   | Password must be between 4 and 20 characters!  |

  Scenario: New accounts can be registered successfully
    Given I'm on the "REGISTER" page
    And I enter the following personal details:
      | FirstName | LastName | Email      | Telephone    | Password   |
      | John      | Howard   | <HalfUUID> | +17079700000 | <HalfUUID> |
    When I click the continue button
    Then The new user is registered successfully