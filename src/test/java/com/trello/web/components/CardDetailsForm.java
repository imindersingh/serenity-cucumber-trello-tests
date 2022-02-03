package com.trello.web.components;

import net.serenitybdd.screenplay.targets.Target;

public class CardDetailsForm {
    public static final Target DESCRIPTION_BOX = Target.the("Add detailed description text box")
            .locatedBy("div > p.u-bottom.js-hide-with-desc > a");
    public static final Target DESCRIPTION_FIELD = Target.the("Add detailed description text box")
            .locatedBy("div.description-edit.edit > textarea");
    public static final Target SAVE_BUTTON = Target.the("Add detailed description text box")
            .locatedBy("div.description-edit.edit > div > input");
    public static final Target DESCRIPTION_TEXT = Target.the("Add detailed description text box")
            .locatedBy("//*[@id=\"chrome-container\"]//div[4]/div[2]/div/div/div/div[2]/div/div/div[3]/div/input");
    public static final Target CARD_DETAILS_FORM = Target.the("Card details form")
            .locatedBy("#chrome-container > div.window-overlay > div > div > div");
    public static final Target CLOSE_BUTTON = Target.the("Card title on board")
            .locatedBy("a[class=\"icon-md icon-close dialog-close-button js-close-window\"]");
    //

    //

}
