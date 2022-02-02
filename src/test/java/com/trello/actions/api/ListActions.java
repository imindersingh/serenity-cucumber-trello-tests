package com.trello.actions.api;

import com.trello.model.ListFactory;
import com.trello.requests.Requests;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

public class ListActions {
    public static Task getCardsOnList(final String listName) {
        String listId = ListFactory.getList(listName).id();
        return Task.where("{0} Gets all cards on {listName} list",
                Get.resource(String.format("/lists/%s/cards", listId))
                        .with(request -> request.spec(Requests.request())
                                .queryParams("fields", "id")));
    }
}
