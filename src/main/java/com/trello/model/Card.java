package com.trello.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Card {

    String name;
    String description;
    String due;
    String id;
}
