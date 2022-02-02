package com.trello.ui.search;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.Keys;

public class Login {
    public static Performable as(String user, String password) {
        return Task.where("{0} logins in with {user} and {password}",
                Enter.theValue(user)
                        .into(LoginForm.USER_FIELD),
                Click.on(LoginForm.LOGIN_BUTTON),
                Enter.theValue(password)
                        .into(LoginForm.PASSWORD_FIELD),
                Click.on(LoginForm.SUBMIT_BUTTON)
        );
    }
}
