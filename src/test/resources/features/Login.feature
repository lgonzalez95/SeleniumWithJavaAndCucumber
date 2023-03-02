Feature: Login tests

  Scenario: Login with invalid credentials
    Given I'm on the "LOGIN" page
    When I login with the username "invalidUser" and password "invalidPassword"
    Then I get the following login error "Invalid credentials"
