package com.trello.stepdefinitions.web;

import com.trello.web.actions.Login;
import com.trello.web.components.TrelloWorkspace;
import com.trello.web.navigation.NavigateTo;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.ensure.Ensure;

public class LoginStepDefinitions {

    @Given("{actor} is successfully logged in and is on the testing board")
    public void successfullyLoggedIn(final Actor actor) {
        onTheTrelloLoginPage(actor);
        loginWithValidCredentials(actor);
        navigatesToBoard(actor);
    }

    @Given("{actor} is on the Trello login page")
    public void onTheTrelloLoginPage(final Actor actor) {
        actor.wasAbleTo(NavigateTo.theTrelloLoginPage());
    }

    @When("{actor} logs in with valid credentials")
    public void loginWithValidCredentials(final Actor actor) {
        actor.attemptsTo(
                Login.with("bddtrellotesting@mailinator.com", "Greenfishbowl246!")
        );
    }

    @When("{actor} goes to the testing board")
    public void navigatesToBoard(final Actor actor) {
        actor.attemptsTo(
                TrelloWorkspace.goToBoard()
        );
    }

    @Then("{actor} should be presented with {string} on workspaces")
    public void shouldBePresentedWithHeadingOnWorkspaces(final Actor actor, final String heading) {
        actor.attemptsTo(
                Ensure.that(TrelloWorkspace.HEADING).hasText(heading)
        );
    }
}
