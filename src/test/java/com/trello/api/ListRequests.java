package com.trello.api;

import com.trello.model.Board;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

public class ListRequests {

    public static Task getCardsOnList(final String listName) {
        return Task.where("{0} Gets all cards on {listName} list",
                Get.resource(String.format("/lists/%s/cards", Board.getListIdByName(listName)))
                        .with(request -> request.spec(Requests.request())
                                .queryParams("fields", "id")));
    }
}
