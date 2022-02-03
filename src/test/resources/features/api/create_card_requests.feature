Feature: Add Card To Board
  Description: Tests covering POST /cards service for creating new cards to add to a list

  Scenario: Create a new card to the To Do list
    When Iminder creates card with name "New Card 1", description "New Card Description" and due date "03-03-2022" on "To Do" list
    Then he should see a successful response status
    And he should see the card is added to "To Do" list

  Scenario: Can't create a card on a list that does not exist
    When Iminder creates card on a list that does "Does Not Exist"
    Then he should see a bad request response returned
