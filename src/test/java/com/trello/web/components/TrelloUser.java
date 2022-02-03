package com.trello.web.components;

public enum TrelloUser {
    USER("bddtrellotesting@mailinator.com", "Greenfishbowl246!");

    public final String username;
    public final String password;

    TrelloUser(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
