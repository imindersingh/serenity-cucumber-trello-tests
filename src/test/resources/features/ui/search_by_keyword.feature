Feature: UI Tests

  Scenario: Searching for a term
    Given Sergey is on the Trello login page
    When he logs in with valid credentials
    Then he should be presented with the "dkjd"

