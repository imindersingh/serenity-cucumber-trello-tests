package com.trello.web.components;

import net.serenitybdd.screenplay.targets.Target;

public class BoardList {
    public static final Target ADD_A_CARD_LINK = Target.the("Add a card link")
            .locatedBy("#board > div:nth-child(1) a > span.js-add-a-card");
    public static final Target CREATE_CARD_TEXT_AREA = Target.the("Create card text area")
            .locatedBy(".list-card.js-composer > div > textarea");
    public static final Target CARD_TITLE = Target.the("Card title on board")
            .locatedBy("//a[2]/div[last()]/span");
}
