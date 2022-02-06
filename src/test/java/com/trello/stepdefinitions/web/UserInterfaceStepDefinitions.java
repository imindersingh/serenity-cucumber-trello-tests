package com.trello.stepdefinitions.web;

import com.trello.web.actions.CreateCard;
import com.trello.web.actions.EditCard;
import com.trello.web.components.Board;
import com.trello.web.components.BoardList;
import com.trello.web.components.CardDetailsForm;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.JavaScript;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import net.serenitybdd.screenplay.waits.Wait;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.support.ui.ExpectedConditions;

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
    public void shouldSeeDescriptionHasBeenAddedToCard(final Actor actor, final String description) {
        actor.attemptsTo(
                Wait.until(WebElementQuestion.the(CardDetailsForm.DESCRIPTION_TEXT), WebElementStateMatchers.isVisible())
                        .forNoMoreThan(5).seconds(),
                Ensure.that(CardDetailsForm.DESCRIPTION_TEXT).hasText(description)
        );
    }

    @Then("{actor} closes the card details form")
    public void closesTheCardDetailsForm(final Actor actor) {
        actor.attemptsTo(
                EditCard.closeForm()
        );
    }
}
