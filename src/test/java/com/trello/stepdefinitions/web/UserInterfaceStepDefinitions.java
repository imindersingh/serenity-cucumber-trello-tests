package com.trello.stepdefinitions.web;

import com.trello.web.actions.CreateCard;
import com.trello.web.actions.EditCard;
import com.trello.web.components.Board;
import com.trello.web.components.BoardList;
import com.trello.web.components.CardDetailsForm;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.ensure.Ensure;

public class UserInterfaceStepDefinitions {

    @Then("{actor} should be presented with {string}")
    public void shouldBePresentedWithHeadingOnBoard(final Actor actor, final String term) {
        actor.attemptsTo(
                Ensure.that(Board.BOARD_TITLE).hasText(term)
        );
    }

    @When("{actor} adds a card on the To Do list with title {string}")
    public void addsACardOnTheToDoList(final Actor actor, final String title) {
        actor.attemptsTo(
                CreateCard.onToDoList(title)
        );
    }

    @Then("{actor} can see card with title {string} is added to the bottom of the To Do list")
    public void canSeeCardIsAddedToTheBottomOfTheToDoList(final Actor actor, final String title) {
        actor.attemptsTo(
                Ensure.that(BoardList.CARD_TITLE).hasText(title)
        );
    }

    @When("{actor} updates the card's description to {string}")
    public void updatesTheCardSDescriptionTo(final Actor actor, final String description) {
        actor.attemptsTo(
                EditCard.detailsWith(description)
        );
    }

    @Then("{actor} can see {string} has been added to the card's description")
    public void canSeeHasBeenAddedToTheCardSDescription(final Actor actor, final String description) {
        actor.attemptsTo(
                Ensure.that(CardDetailsForm.DESCRIPTION_TEXT).hasText(description)
        );
    }
}
