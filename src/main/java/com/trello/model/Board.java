package com.trello.model;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Board {

    public static final String id = "61f85f768fd1b110215f9800";
    public static final String name = "testing board";
    public static final List<BoardList> list = new ArrayList<BoardList>(){
        {
            add(new BoardList("61f85f768fd1b110215f9801", "To Do", id));
            add(new BoardList("61f85f768fd1b110215f9802", "Doing", id));
            add(new BoardList("61f85f768fd1b110215f9803", "Done", id));
        }
    };
}
