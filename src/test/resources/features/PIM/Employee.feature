Feature: Employee management

  Background:
    * I'm logged in the system

  Scenario: Add a new employee
    Given I'm on the "ADD_EMPLOYEE" page
    And I enter the following user information
      | FirstName    | MiddleName   | LastName     | EmployeeId |
      | <randomWord> | <randomWord> | <randomWord> | 1          |
    When I click on the save user button
    Then The user is saved successfully

  @Debug
  Scenario: Search for an existing employee
    Given I'm on the "VIEW_EMPLOYEES" page
    And I enter the following employee search criteria
      | FirstName | LastName |
      | Amey      | Meshram  |
    When I click the search button
    Then Results are retrieved matching the following information
      | FirstName | LastName |
      | Amey      | Meshram  |


