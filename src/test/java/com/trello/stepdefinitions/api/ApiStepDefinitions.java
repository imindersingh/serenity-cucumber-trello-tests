package com.trello.stepdefinitions.api;

import com.trello.api.CardRequests;
import com.trello.api.ListRequests;
import com.trello.model.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.CoreMatchers.*;

public class ApiStepDefinitions {

    private final Card card = new Card();

    @When("{actor} creates card with name {string}, description {string} and due date {string} on {string} list")
    public void createNewCard(final Actor actor, final String name, final String description, final String dueDate, final String listName) {
        actor.attemptsTo(
                CardRequests.createCard(name, description, dueDate, listName)
        );
        card.setId(SerenityRest.lastResponse().jsonPath().get("id"));
    }

    @When("{actor} edits the name to {} and description to {}")
    public void editCardDetails(final Actor actor, final String name, final String description) {
        actor.attemptsTo(
                CardRequests.editCardDetails(name, description)
        );
    }

    @When("{actor} moves card from ToDo to {string} list")
    public void editCardStatus(final Actor actor, final String list) {
        actor.attemptsTo(
                CardRequests.editCardStatus(list)
        );
    }

    @When("{actor} adds a comment {string} to the card")
    public void addComment(final Actor actor, final String comment) {
        actor.attemptsTo(
                CardRequests.addCommentToCard(comment)
        );
    }

    @When("{actor} attempts to delete the card")
    public void deleteCard(final Actor actor) {
        actor.attemptsTo(
                CardRequests.deleteCard()
        );
    }

    @Then("{actor} should see a successful response status")
    public void shouldSeeSuccessfulResponseStatus(final Actor actor) {
        actor.should(
                seeThatResponse(response -> response.statusCode(200))
        );
    }

    @And("{actor} should see the updated {} and {} in the response body")
    public void shouldSeeCorrectDetailsInResponseBody(final Actor actor, final String name, final String description) {
        actor.should(
                seeThatResponse(response -> response
                        .body("name", equalTo(name))
                        .body("desc", equalTo(description)))
        );
    }

    @Then("{actor} should see {string} in the response body")
    public void shouldSeeCorrectCommentInResponseBody(final Actor actor, final String comment) {
        actor.should(
                seeThatResponse(response -> response
                        .body("data.text", equalTo(comment)))
        );
    }

    @And("{actor} should see the card is added to {string} list")
    public void shouldSeeCardOnList(final Actor actor, final String listName) {
        final String listId = Board.list.
                stream()
                .filter(r -> r.getName().equalsIgnoreCase(listName))
                .map(BoardList::getId)
                .collect(Collectors.joining());
        actor.should(
                seeThatResponse(response -> response
                        .body("idList", equalTo(listId)))
        );
    }

    @And("{actor} should see that the card is not on the {string} list anymore")
    public void shouldNotFindCardOnList(final Actor actor, final String listName) {
        actor.attemptsTo(
                ListRequests.getCardsOnList(listName)
        );
        final Map<String, String> deletedCard = new HashMap<>();
        deletedCard.put("id", card.getId());
        actor.should(
                seeThatResponse(response -> response
                        .statusCode(200)
                        .body("$", not(hasItem(deletedCard)))
                )
        );
    }
}
