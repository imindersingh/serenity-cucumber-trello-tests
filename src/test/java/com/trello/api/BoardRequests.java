package com.trello.api;

import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Delete;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.serenitybdd.screenplay.rest.interactions.Post;

public class BoardRequests {
    public static Task deleteBoard(final String boardId) {
        return Task.where("{0} deletes board",
                Delete.from(String.format("/boards/%s", boardId))
                        .with(request -> request.spec(Requests.request())));
    }

    public static Task createBoard(final String name) {
        return Task.where("{0} creates new board with name {name}",
                Post.to("/boards")
                        .with(request -> request.spec(Requests.request())
                                .queryParams("name", name)));
    }

    public static Task getListsOnBoard(final String boardId) {
        return Task.where("{0} gets list on a board",
                Get.resource(String.format("/boards/%s/lists", boardId))
                        .with(request -> request.spec(Requests.request())));
    }
}
