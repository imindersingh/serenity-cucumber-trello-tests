# Serenity Cucumber Trello Tests
Web and Api tests for trello.com using Serenity BDD and Cucumber

## Requirements
- Java 1.8 or higher
- Maven
- Cucumber plugin for IDE
- Lombok plugin for IDE and annotations enabled

### The project directory structure
```Gherkin
src
  + main
    + java                        Trello model
  + test
    + java                        
      + api                       Actions for api requests
      + web                       Actions, components and navigation
      + stepdefinitions
        + api                     Api request step definitions
        + web                     Web step definitions
    + resources
      + features                  Feature files
        + api                     Api features 
        + web                     Web features 
```

## Executing the tests
To run all the tests
```json
$ mvn clean verify
```

To run all API tests
```json
$ mvn clean verify -Dcucumber.filter.tags="@api"

```

To run all web tests
```json
$ mvn clean verify -Dcucumber.filter.tags="@web"

```


## Approach
- I started off by firstly understanding the trello APIs by exploring the documentation and creating requests
- For the purpose of this test, I needed to create a new account on trello to be able to interact with the APIs and the UI so I generated a key and token to use
- Modelled requests in Insomnia before creating the tests
- I haven't used Serenity BDD so I wanted to challenge myself. I initially spent some time understanding the framework and concepts
- I began by creating a basic structure using one of starter repos available
- I created the test steps to understand the flow whilst continuing to explore the APIs and UI to feed into this
- After creating some step implementations to get things working, I refactored to use the screen play pattern as much as possible

## What I managed to achieve
- Created API tests for adding, editing and deleting cards on a board
- Created UI tests for login (this was required for the other test setup) and adding a card. The edit card feature is in wip, given the time I wasn't able to complete it fully. Update: fixed locators, edit card tests are running now.
- For the API tests, modelled actions/requests around the services and their capabilities
- For the UI tests, created actions and components for reusability
- Created some classes to represent trello components such as board, list, cards

## Improvements
- Create additional journey based tests for the APIs:
  - Chain together requests based on user flows
  - Negative tests for the individual services covering validation rules and error handling
- Create journey based tests for the UI. I would personally keep these very end-to-end focused as creating and running them can be costly
- Model the API request and responses into DTOs
- Move the repo secrets such as username, passwords, api key and token into a secret store. We can use something like Keepass for this. The token should not be exposed publicly. For this test I created a new user account with a temp email for testing purposed only.
- Add environment config
- Set up steps and tear down steps for creating and deleting a board
