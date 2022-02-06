@web
Feature: Web: Login

  Scenario: Can successfully login
    Given Iminder is on the Trello login page
    When he logs in with valid credentials
    Then he should be presented with "Most popular templates" on workspaces
    When he goes to the testing board
    Then he should be presented with "testing board"