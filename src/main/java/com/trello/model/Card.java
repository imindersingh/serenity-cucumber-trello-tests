package com.trello.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Card {

    private String name;
    private String description;
    private String due;
    private String id;
}
