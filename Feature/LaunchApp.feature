Feature: LaunchApp

  Scenario: Successful Launch of Pay+ App
    Given User installs Pay+ App
    When User clicks on install agreement
    And User allows device location
    And user cliks on sign in CTA
    Then Page Sign in page "Sign in." displays
    When User enters email as "pay_automation@mailinator.com" and password as "Tesco@2020"
    And enter the PIN
    And confirm PIN
    And accepts on pin saved screen
    Then Pay screen "Please add a payment card" should be displayed
    And Close the app