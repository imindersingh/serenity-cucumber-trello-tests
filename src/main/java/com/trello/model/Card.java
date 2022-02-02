package com.trello.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Card {

    String name;
    String description;
    String due;
    String id;
}
