@api
Feature: Edit Card Details
  Description: Tests for PUT /cards/{cardId} service to update card data

  Background:
    When Iminder creates card with name "New Card 1", description "New Card Description" and due date "03-03-2022" on "To Do" list
    Then he should see a successful response status

  Scenario Outline: Edit card's name and description
    When he edits the name to <Name> and description to <Description>
    Then he should see a successful response status
    And he should see the updated <Name> and <Description> in the response body
    Examples:
      | Name                  | Description                      |
      | Updated Card Name 123 | Updating card's descriptions 124 |

  Scenario: Add comment
    When he adds a comment "Adding a new comment! This needs to start on 02-03-2022!" to the card
    Then he should see a successful response status
    And he should see "Adding a new comment! This needs to start on 02-03-2022!" in the response body

  Scenario: Update card status
    When he moves card from ToDo to "Doing" list
    Then he should see a successful response status