Feature: Delete Cards From Trello Board
  Description: Tests covering DELETE /cards/{cardId} service for deleting cards from the board

  Background:
    Given Iminder creates card with name "New Card 1", description "New Card Description" and due date "03-03-2022" on "To Do" list

  Scenario: Delete card from To Do list
    When he attempts to delete the card
    Then he should see a successful response status
    And he should see that the card is not on the "To Do" list anymore
