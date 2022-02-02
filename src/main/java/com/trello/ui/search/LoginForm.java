package com.trello.ui.search;

import net.serenitybdd.screenplay.targets.Target;

class LoginForm {
    static Target USER_FIELD = Target.the("user").locatedBy("div > #user");
    //input[id='user']
    static Target PASSWORD_FIELD = Target.the("password").locatedBy("div > #password");
    static Target LOGIN_BUTTON = Target.the("login button").locatedBy("div > #login");
    static Target SUBMIT_BUTTON = Target.the("submit button").locatedBy("div > #login-submit");
}
