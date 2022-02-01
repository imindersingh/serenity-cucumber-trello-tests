Feature: Add Card To Board

  Scenario: Add New Card To List on Board
    Given Sergey is researching things on the internet
    When he looks up "Cucumber"
    Then he should see information about "Cucumber"