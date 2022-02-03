package com.trello.web.navigation;

import com.trello.web.components.TrelloLoginPage;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public class NavigateTo {
    public static Performable theTrelloLoginPage() {
        return Task.where("{0} opens the Trello login page",
                Open.browserOn().the(TrelloLoginPage.class));
    }
}
