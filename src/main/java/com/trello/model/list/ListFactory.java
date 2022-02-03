package com.trello.model.list;

public class ListFactory {

    public static List getList(String listName) {
        switch (listName.toUpperCase()) {
            case "TO DO":
                return new ToDo();
            case "DOING":
                return new Doing();
            default:
                throw new IllegalStateException("Unexpected value: " + listName);
        }
    }
}
