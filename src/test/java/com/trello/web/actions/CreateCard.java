package com.trello.web.actions;

import com.trello.web.components.BoardList;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.Keys;

public class CreateCard {
    public static Performable onToDoList(final String title) {
        return Task.where("{0} creates a new card on To Do list with {title}",
                Click.on(BoardList.ADD_A_CARD_LINK),
                Enter.theValue(title)
                        .into(BoardList.CREATE_CARD_TEXT_AREA)
                        .thenHit(Keys.ENTER)
        );
    }
}
