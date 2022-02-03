package com.trello.stepdefinitions;

import com.trello.api.BoardRequests;
import com.trello.api.Requests;
import com.trello.model.Board;
import com.trello.model.BoardList;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.ParameterType;
import io.restassured.path.json.JsonPath;
import net.serenitybdd.core.collect.NewList;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import java.util.ArrayList;
import java.util.List;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

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

    //ToDo - setup step to create board and populate model
    public void setBoard() {
        OnStage.setTheStage(new OnlineCast());
        OnStage.aNewActor().whoCan(CallAnApi.at(Requests.getBaseUrl()));
        OnStage.aNewActor().attemptsTo(
                BoardRequests.createBoard("testing board 12345789")
        );

        OnStage.aNewActor().should(
                seeThatResponse(response -> response
                        .statusCode(200))
        );

        JsonPath response = SerenityRest.lastResponse().jsonPath();
        String boardId = response.get("id");

        OnStage.aNewActor().attemptsTo(
                BoardRequests.getListsOnBoard(boardId)
        );

        OnStage.aNewActor().should(
                seeThatResponse(r -> r
                        .statusCode(200))
        );

        JsonPath responseGetList = SerenityRest.lastResponse().jsonPath();
        String toDoListId = responseGetList.getString("[0].id");
        String doingListId = responseGetList.getString("[1].id");
        String doneListId = responseGetList.getString("[2].id");

        List<BoardList> boardLists = new ArrayList<BoardList>(){
            {
                add(new BoardList(toDoListId, "To Do", boardId));
                add(new BoardList(doingListId, "Doing", boardId));
                add(new BoardList(doneListId, "Done", boardId));
            }
        };

    }

    //ToDo - tear down steps to delete board
    public static void afterAll() {
        theActorInTheSpotlight().attemptsTo(
                BoardRequests.deleteBoard("Board.ID")
        );

        theActorInTheSpotlight().should(
                seeThatResponse(response -> response
                        .statusCode(200))
        );
    }
}
