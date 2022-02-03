Feature: Web: Add Cards To Board

  Background:
    Given Iminder is on the Trello login page
    When he logs in with valid credentials
    Then he should be presented with "Most popular templates" on workspaces
    When he goes to the testing board
    Then he should be presented with "testing board"

  Scenario: Can successfully add card to board
    When he adds a card on the To Do list with title "new card title"
    Then he can see card with title "new card title" is added to the bottom of the To Do list