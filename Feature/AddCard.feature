Feature: AddCard

  Scenario: Add the funding card to Pay+ Wallet
    Given User launch and sign in to Pay+ app
    Then User enters Email as "pay_automation1@mailinator.com" and Password as "Tesco@2020" to sign in
    And Initiates the BountyAdd card screen either from Pay or from my cards screen.
    When Enter all card details and click on save CTA
    Then Card will be added successfully
    And Added card should be reflected successfully.