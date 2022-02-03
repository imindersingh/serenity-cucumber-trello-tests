package com.trello.api;

import com.trello.model.Board;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Delete;
import net.serenitybdd.screenplay.rest.interactions.Post;
import net.serenitybdd.screenplay.rest.interactions.Put;

import static com.trello.api.Requests.getCardIdFromLastResponse;

public class CardRequests {

    public static Task createCard(final String name, final String description, final String dueDate, final String listName) {
        return Task.where("{0} Adds card with name {name}, description {description} and due-date {dueDate} on list",
                Post.to("/cards")
                .with(request -> request.spec(Requests.request())
                        .queryParams("idList", Board.getListIdByName(listName))
                        .queryParams("name", name)
                        .queryParams("desc", description)
                        .queryParams("due", dueDate)));
    }

    public static Task editCardDetails(final String name, final String description) {
        return Task.where("{0} edits the card name {name} and description {description}",
                Put.to(String.format("/cards/%s", getCardIdFromLastResponse()))
                        .with(request -> request.spec(Requests.request())
                                .queryParams("idList", Board.getListIdByName("To Do"))
                                .queryParams("name", name)
                                .queryParams("desc", description)));
    }

    public static Task editCardStatus(final String listName) {
        return Task.where("{0} moves card from To Do to {list}",
                Put.to(String.format("/cards/%s", getCardIdFromLastResponse()))
                        .with(request -> request.spec(Requests.request())
                                .queryParams("idList", Board.getListIdByName(listName))));
    }

    public static Task addCommentToCard(final String comment) {
        return Task.where("{0} adds comment {comment} to card",
                Post.to(String.format("/cards/%s/actions/comments", getCardIdFromLastResponse()))
                        .with(request -> request.spec(Requests.request())
                                .queryParams("text", comment)));
    }

    public static Task deleteCard() {
        return Task.where("{0} deletes card",
                Delete.from(String.format("/cards/%s", getCardIdFromLastResponse()))
                        .with(request -> request.spec(Requests.request())));
    }

}
