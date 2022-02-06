package com.trello.web.actions;

import com.trello.web.components.BoardList;
import com.trello.web.components.CardDetailsForm;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import net.serenitybdd.screenplay.waits.Wait;

public class EditCard {
    public static Performable detailsWith(final String description) {
        return Task.where("{0} edit card details by adding {description}",
                Wait.until(WebElementQuestion.the(BoardList.CARD_TITLE), WebElementStateMatchers.isVisible())
                        .forNoMoreThan(5).seconds(),
                JavaScriptClick.on(BoardList.CARD_TITLE),
                Switch.toActiveElement(),
                Wait.until(WebElementQuestion.the(CardDetailsForm.DESCRIPTION_BOX), WebElementStateMatchers.isPresent())
                        .forNoMoreThan(5).seconds(),
                JavaScriptClick.on(CardDetailsForm.DESCRIPTION_BOX),
                Wait.until(WebElementQuestion.the(CardDetailsForm.DESCRIPTION_FIELD), WebElementStateMatchers.isPresent())
                        .forNoMoreThan(5).seconds(),
                Enter.theValue(description)
                        .into(CardDetailsForm.DESCRIPTION_FIELD),
                Wait.until(WebElementQuestion.the(CardDetailsForm.SAVE_BUTTON), WebElementStateMatchers.isClickable())
                        .forNoMoreThan(5).seconds(),
                JavaScriptClick.on(CardDetailsForm.SAVE_BUTTON)
        );
    }

    public static Performable closeForm() {
        return Task.where("{0} close the card details form",
                JavaScriptClick.on(CardDetailsForm.CLOSE_BUTTON));
    }
}
