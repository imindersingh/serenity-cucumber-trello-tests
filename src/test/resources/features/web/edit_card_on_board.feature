@wip
Feature: Web: Edit Cards On Trello Board

  Background:
    Given Iminder is on the Trello login page
    When he logs in with valid credentials
    Then he should be presented with "Most popular templates" on workspaces
    When he goes to the testing board
    Then he should be presented with "testing board"

  Scenario: Can successfully edit a card
    When he updates the card's description to "Adding new description"
    Then he can see "Adding new description" has been added to the card's description