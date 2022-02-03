package com.trello.api;

import com.trello.model.list.List;
import com.trello.model.list.ListFactory;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Delete;
import net.serenitybdd.screenplay.rest.interactions.Post;
import net.serenitybdd.screenplay.rest.interactions.Put;

public class CardRequests {

    public static Task createCard(final String name, final String description, final String dueDate, final String listName) {
        String listId = ListFactory.getList(listName).id();
        return Task.where("{0} Adds card with name {name}, description {description} and due-date {dueDate} on list",
                Post.to("/cards")
                .with(request -> request.spec(Requests.request())
                        .queryParams("idList", listId)
                        .queryParams("name", name)
                        .queryParams("desc", description)
                        .queryParams("due", dueDate)));
    }

    public static Task editCardDetails(final String name, final String description) {
        String cardId = SerenityRest.lastResponse().jsonPath().get("id");
        String listId = ListFactory.getList("To Do").id();
        return Task.where("{0} edits the card name {name} and description {description}",
                Put.to("/cards/" + cardId)
                        .with(request -> request.spec(Requests.request())
                                .queryParams("idList", listId)
                                .queryParams("name", name)
                                .queryParams("desc", description)));
    }

    public static Task editCardStatus(final String listName) {
        String cardId = SerenityRest.lastResponse().jsonPath().get("id");
        List list = ListFactory.getList(listName);
        return Task.where("{0} moves card from ToDo to {list}",
                Put.to("/cards/" + cardId)
                        .with(request -> request.spec(Requests.request())
                                .queryParams("idList", list.id())));
    }

    public static Task addCommentToCard(final String comment) {
        String cardId = SerenityRest.lastResponse().jsonPath().get("id");
        return Task.where("{0} adds comment {comment} to card",
                Post.to("/cards/" + cardId + "/actions/comments")
                        .with(request -> request.spec(Requests.request())
                                .queryParams("text", comment)));
    }

    public static Task deleteCard() {
        String cardId = SerenityRest.lastResponse().jsonPath().get("id");
        return Task.where("{0} deletes card",
                Delete.from("/cards/" + cardId)
                        .with(request -> request.spec(Requests.request())));
    }

}
