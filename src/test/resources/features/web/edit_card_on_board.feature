@web
Feature: Web: Edit Cards On Trello Board
  Description: Web UI tests that update card details on a board

  Background:
    Given Iminder is on the Trello login page
    When he logs in with valid credentials
    When he goes to the testing board

  Scenario: Can successfully edit a card
    When he adds a card on the To Do list with title "new card title"
    Then he can see card with title "new card title" is added to the bottom of the To Do list
    When he updates the card's description to "Adding new description"
    Then he can see "Adding new description" has been added to the card's description
    Then he closes the card details form