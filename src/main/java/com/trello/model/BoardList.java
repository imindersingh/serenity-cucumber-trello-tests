package com.trello.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BoardList {

    private String id;
    private String name;
    private String boardId;
}
