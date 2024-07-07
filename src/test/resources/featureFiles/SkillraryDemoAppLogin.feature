Feature: Demo App Login

  Scenario: Login with valid inputs
    Given Navigate to skillrary
    When Provided with valid inputs
    And Hit on Login
    Then Admin home page displays

  Scenario: Login with invalid inputs
    Given Navigate to skillrary
    When Provided with invalid inputs
    And Hit on Login
    Then Admin home page displays
