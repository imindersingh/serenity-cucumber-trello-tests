package com.trello.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.ensure.Ensure;
import com.trello.ui.navigation.NavigateTo;
import com.trello.ui.search.Login;
import com.trello.ui.search.WikipediaArticle;

public class UserInterfaceStepDefinitions {

    @Given("{actor} is on the Trello login page")
    public void onTheTrelloLoginPage(Actor actor) {
        actor.wasAbleTo(NavigateTo.theTrelloLoginPage());
    }

    @When("{actor} logs in with valid credentials")
    public void loginWithValidCredentials(Actor actor) {
        actor.attemptsTo(
                Login.as("bddtrellotesting@mailinator.com", "Greenfishbowl246!")
        );
    }

//    @When("{actor} looks up {string}")
//    public void searchesFor(Actor actor, String term) {
//        actor.attemptsTo(
//                Login.as("bddtrellotesting@mailinator.com", "Greenfishbowl246!")
//        );
//    }

    @Then("{actor} should be presented with the {string}")
    public void should_see_information_about(Actor actor, String term) {
        actor.attemptsTo(
                Ensure.that(WikipediaArticle.HEADING).hasText(term)
        );
    }
}
