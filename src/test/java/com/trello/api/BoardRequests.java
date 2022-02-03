package com.trello.api;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Delete;
import net.serenitybdd.screenplay.rest.interactions.Post;

public class BoardRequests {
    public static Task deleteBoard() {
        String cardId = SerenityRest.lastResponse().jsonPath().get("id");
        return Task.where("{0} deletes card",
                Delete.from("/cards/" + cardId)
                        .with(request -> request.spec(Requests.request())));
    }

    public static Task createBoard(final String comment) {
        String cardId = SerenityRest.lastResponse().jsonPath().get("id");
        return Task.where("{0} adds comment {comment} to card",
                Post.to("/cards/" + cardId + "/actions/comments")
                        .with(request -> request.spec(Requests.request())
                                .queryParams("text", comment)));
    }
}
