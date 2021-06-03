Feature: DeleteCard

  Scenario: Delete Card from Pay+ Wallet
    Given User install,launch and navigates to sign in screen
    Then Enters Email as "pay_automation1@mailinator.com" and Password as "Tesco@2020" to sign in
    And Navigates to My cards screen
    When User selects any existing card to delete
    Then Card will be deleted from wallet and displayed with "Add debit or credit card"