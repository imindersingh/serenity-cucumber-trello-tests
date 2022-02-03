package com.trello.web.actions;

import com.trello.web.components.LoginForm;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import net.serenitybdd.screenplay.waits.Wait;

public class Login {
    private static final String LOGIN_BUTTON_TEXT = "Log in with Atlassian";

    public static Performable with(String user, String password) {
        return Task.where("{0} logs in in with {user} and {password}",
                Enter.theValue(user)
                        .into(LoginForm.USER_FIELD),
                Wait.until(WebElementQuestion.the(LoginForm.LOGIN_BUTTON), WebElementStateMatchers
                        .hasValue(LOGIN_BUTTON_TEXT))
                        .forNoMoreThan(5).seconds(),
                Click.on(LoginForm.LOGIN_BUTTON),
                Enter.theValue(password)
                        .into(LoginForm.PASSWORD_FIELD),
                Click.on(LoginForm.SUBMIT_BUTTON)
        );
    }
}
