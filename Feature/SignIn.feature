Feature: SignIn

  Scenario: Successful SignIn to Pay+ App
    Given User installs Pay+ App and on sign in screen
    Then Page title should be "Sign in." displayed
    When User enters Email as "pay_automation@mailinator.com" and Password as "Tesco@2020"
    And Clicks on Sign in button
    And set the PIN
    And Ignore the store reminder and keep brightness as default
    Then Pay screen should be displayed
    And Close the browser.

