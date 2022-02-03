package com.trello.web.components;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;

public class TrelloWorkspace {
    public static final Target HEADING = Target.the("workspace heading").locatedBy("//h2");
    public static final Target BOARD = Target.the("workspace heading").locatedByFirstMatching("//div[text()='testing board']");

    public static Performable goToBoard() {
        return Task.where("{0} clicks on testing board",
                Click.on(TrelloWorkspace.BOARD)
        );
    }

}