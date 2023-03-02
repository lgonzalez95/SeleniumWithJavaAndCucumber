Feature: Actions that the users can perform from their profile

  Scenario: Log out from the system
    Given I'm logged in the system
    When I log out from the system
    Then I'm taken to the login page