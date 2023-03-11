@Debug
Feature: Login tests

  Scenario: Login with invalid credentials
    Given I'm on the "LOGIN" page
    When I login with the username "invalidUser" and password "invalidPassword"
    Then I get the following login error "Warning: No match for E-Mail Address and/or Password."

  Scenario: Login with valid credentials and logout
    Given I'm on the "LOGIN" page
    When I login with the username "SYSTEM_USER" and password "SYSTEM_PASSWORD"
    Then My account management options are available on the page
    And When I logout from the system
    Then I'm taken to the logout page
