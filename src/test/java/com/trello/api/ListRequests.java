package com.trello.api;

import com.trello.model.BoardList;
import com.trello.model.Board;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

import java.util.stream.Collectors;

public class ListRequests {

    private static Board board;

    public static Task getCardsOnList(final String listName) {
        String listId = Board.list.
                stream()
                .filter(r -> r.getName().equalsIgnoreCase(listName))
                .map(BoardList::getId)
                .collect(Collectors.joining());
        return Task.where("{0} Gets all cards on {listName} list",
                Get.resource(String.format("/lists/%s/cards", listId))
                        .with(request -> request.spec(Requests.request())
                                .queryParams("fields", "id")));
    }
}
