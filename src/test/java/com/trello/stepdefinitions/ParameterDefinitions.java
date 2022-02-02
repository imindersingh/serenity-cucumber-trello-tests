package com.trello.stepdefinitions;

import com.trello.requests.Requests;
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

//    @Before
//    public void configureBaseUrl() {
//        actor("Sam").whoCan(CallAnApi.at("https://api.trello.com/1"));
//    }

//    @Before void configureBase(){
//        ac
//    }
}
