package com.trello.stepdefinitions;

import com.trello.api.Requests;
import io.cucumber.java.Before;
import io.cucumber.java.ParameterType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

public class ParameterDefinitions {

    @ParameterType(".*")
    public Actor actor(String actorName) {
        return OnStage.theActorCalled(actorName);
    }

    @Before(order=1)
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Before(order=2)
    public void setBaseUrl() {
        OnStage.aNewActor().whoCan(CallAnApi.at(Requests.getBaseUrl()));
    }

//    @Before(order=3)
//    public void createTrelloBoard() {
//        OnStage.aNewActor().attemptsTo();
          //create board
          //Store board id and name in new object
          //get list on the board
          //get name, id and board id and store

//    }
//
//    @After()
//    public void deleteBoard() {
//        theActorInTheSpotlight().attemptsTo()
//    }

}
