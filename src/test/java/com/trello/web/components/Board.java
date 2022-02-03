package com.trello.web.components;

import net.serenitybdd.screenplay.targets.Target;

public class Board {

    public static final Target BOARD_TITLE =
            Target.the("Board heading")
                    .locatedBy("//h1[text()='testing board']");

}
