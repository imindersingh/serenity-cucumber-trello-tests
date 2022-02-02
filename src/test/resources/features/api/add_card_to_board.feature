Feature: Add Card To Board

  Scenario: Add a new card on TODO
    When Sergey creates card with name "New Card 1", description "New Card Description" and due date "03-03-2022" on "To Do" list
    Then he should see a successful response status
    And he should see the card is added to "To Do" list