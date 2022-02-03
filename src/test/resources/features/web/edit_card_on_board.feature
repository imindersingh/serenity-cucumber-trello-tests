@wip
Feature: Web: Edit Cards On Trello Board
  Description: Web UI tests that update card details on a board

  Background:
    Given Iminder is on the Trello login page
    When he logs in with valid credentials
    When he goes to the testing board

  Scenario: Can successfully edit a card
    When he updates the card's description to "Adding new description"
    Then he can see "Adding new description" has been added to the card's description