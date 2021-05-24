Feature: DeleteCard

  Scenario: Delete Card from Pay+ Wallet
    Given User launch and sign in to Pay+ app
    Then Enters Email as "neoload4@mailinator.com" and Password as "Tesco@20202"
    And Navigates to My cards screen
    When Select any existing card
    And try to delete the card
    Then it removes from the Pay+ wallet successfully

