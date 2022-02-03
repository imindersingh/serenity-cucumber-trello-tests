package com.trello.web.actions;

import com.trello.web.components.BoardList;
import com.trello.web.components.CardDetailsForm;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

public class EditCard {
    public static Performable detailsWith(final String description) {
        return Task.where("{0} edit card details by adding {description}",
                Click.on(BoardList.CARD_TITLE),
                Click.on(CardDetailsForm.CLOSE_BUTTON)
//                Wait.until(WebElementQuestion.the(CardDetailsForm.CARD_DETAILS_FORM), WebElementStateMatchers.isEnabled())
//                        .forNoMoreThan(7).seconds()
//                Click.on(CardDetailsForm.DESCRIPTION_BOX),
//                Enter.theValue(description)
//                        .into(CardDetailsForm.DESCRIPTION_TEXT),
//                Click.on(CardDetailsForm.SAVE_BUTTON)
        );
    }
}
