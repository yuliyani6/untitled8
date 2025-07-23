Feature: Login to SauceDemo

  Scenario: Login with valid credentials
    Given User is on login page
    When User enters valid username and password
    Then User is redirected to the products page