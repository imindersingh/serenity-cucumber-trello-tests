package com.trello.stepdefinitions;

import com.trello.api.Requests;
import io.cucumber.java.AfterAll;
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

    @Before(order = 1)
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Before(order = 2)
    public void setBaseUrl() {
        OnStage.aNewActor().whoCan(CallAnApi.at(Requests.getBaseUrl()));
    }

    @Before(order = 3)
    public void setBoard() {
//        OnStage.aNewActor().attemptsTo(
//                BoardRequests.getListsOnBoard(boardId)
//        );
//
//        OnStage.aNewActor().should(
//                seeThatResponse(r -> r
//                        .statusCode(200))
//        );
//
//        JsonPath responseGetList = SerenityRest.lastResponse().jsonPath();
//        String toDoListId = responseGetList.getString("[0].id");
//        String doingListId = responseGetList.getString("[1].id");
//        String doneListId = responseGetList.getString("[2].id");
//
//        List<NewList> list = new ArrayList<>(){
//            {
//                add(new NewList(toDoListId, "To Do", boardId));
//                add(new NewList(doingListId, "Doing", boardId));
//                add(new NewList(doneListId, "Done", boardId));
//            }
//        };
    }

    @AfterAll
    public static void afterAll() {
//        theActorInTheSpotlight().attemptsTo(
//                BoardRequests.deleteBoard(TestingBoard)
//        );
//
//        theActorInTheSpotlight().should(
//                seeThatResponse(response -> response
//                        .statusCode(200))
//        );
//    }

    }
}
