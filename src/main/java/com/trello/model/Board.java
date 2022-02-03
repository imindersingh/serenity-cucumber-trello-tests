package com.trello.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Board {

    public static final String ID = "61f85f768fd1b110215f9800";
    public static final String NAME = "testing board";
    public static final List<BoardList> BOARD_LISTS = new ArrayList<BoardList>(){
        {
            add(new BoardList("61f85f768fd1b110215f9801", "To Do", ID));
            add(new BoardList("61f85f768fd1b110215f9802", "Doing", ID));
            add(new BoardList("61f85f768fd1b110215f9803", "Done", ID));
        }
    };

    public static String getListIdByName(final String name) {
        return BOARD_LISTS.stream()
                .filter(list -> list.getName().equalsIgnoreCase(name))
                .map(BoardList::getId)
                .collect(Collectors.joining());
    }
}
