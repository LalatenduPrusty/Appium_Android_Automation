Feature: SignIn

  @sanity
  Scenario: Successful SignIn to Pay+ App with single user
    Given User installs Pay+ App and on sign in screen
    Then Page title should be "Sign in." displayed
    When User enters Email as "be146.1@mailinator.com" and Password as "Tesco@2020"
    And Clicks on Sign in button
    And set the PIN
    And Ignore the store reminder and keep brightness as default
    Then Pay screen should be displayed
    And Close the browser.

  @regression
  Scenario Outline: Successful SignIn to Pay+ App with multiple user Data Driven
    Given User installs Pay+ App and on sign in screen
    Then Page title should be "Sign in." displayed
    When User enters Email as "<email>" and Password as "<password>"
    And Clicks on Sign in button
    And set the PIN
    And Ignore the store reminder and keep brightness as default
    Then Pay screen should be displayed
    And Close the browser.
    Examples:
      | email                          | password   |
      | pay_automation@mailinator.com  | Tesco@2020 |
      | pay_automation1@mailinator.com | Tesco@2020 |
