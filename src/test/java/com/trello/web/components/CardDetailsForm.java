package com.trello.web.components;

import net.serenitybdd.screenplay.targets.Target;

public class CardDetailsForm {
    public static final Target DESCRIPTION_BOX = Target
            .the("Add detailed description text box")
            .locatedBy("//a[text()='Add a more detailed description…']");
    public static final Target DESCRIPTION_FIELD = Target
            .the("Add detailed description text box")
            .locatedBy(".description-edit.edit > textarea");
    public static final Target SAVE_BUTTON = Target
            .the("Add detailed description text box")
            .locatedBy(".description-edit.edit > div > input");
    public static final Target DESCRIPTION_TEXT = Target
            .the("Add detailed description text box")
            .locatedBy(".current.markeddown.hide-on-edit.js-desc.js-show-with-desc");
    public static final Target CLOSE_BUTTON = Target
            .the("Card title on board")
            .locatedBy(".window-overlay > div > div > a");
}
