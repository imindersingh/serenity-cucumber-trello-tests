package com.trello.web.navigation;

import com.trello.web.components.TrelloHomePage;
import com.trello.web.components.TrelloLoginPage;
import com.trello.web.components.TrelloWorkspace;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;

public class NavigateTo {
    public static Performable theTrelloHomePage() {
        return Task.where("{0} opens the Trello home page",
                Open.browserOn().the(TrelloHomePage.class));
    }

    public static Performable theTrelloLoginPage() {
        return Task.where("{0} opens the Trello login page",
                Open.browserOn().the(TrelloLoginPage.class));
    }

    public static Performable theBoard() {
        return Task.where("{0} navigates to the testing board",
                Click.on(TrelloWorkspace.BOARD));
    }
}
