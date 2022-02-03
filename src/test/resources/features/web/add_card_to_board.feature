Feature: Web: Add Cards To Board
  Description: Web UI tests that add cards to a trello board

  Background:
    Given Iminder is on the Trello login page
    When he logs in with valid credentials
    When he goes to the testing board

  Scenario: Can successfully add card to board
    When he adds a card on the To Do list with title "new card title"
    Then he can see card with title "new card title" is added to the bottom of the To Do list