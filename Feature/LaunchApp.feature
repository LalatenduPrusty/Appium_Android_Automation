Feature: LaunchApp

  Scenario: Successful Launch of Pay+ App
    Given User installs Pay+ App
    When User clicks on install agreement
    And User allows device location
    And user clicks on sign in CTA
    Then Page Sign in page "Sign in." displays
