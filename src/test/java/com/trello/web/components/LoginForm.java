package com.trello.web.components;

import net.serenitybdd.screenplay.targets.Target;

public class LoginForm {
    public static final Target USER_FIELD = Target.the("user").locatedBy("#user");
    public static final Target PASSWORD_FIELD = Target.the("password").locatedBy("#password");
    public static final Target LOGIN_BUTTON = Target.the("login button").locatedBy("#login");
    public static final Target SUBMIT_BUTTON = Target.the("submit button").locatedBy("#login-submit");
}
