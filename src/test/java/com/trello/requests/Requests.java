package com.trello.requests;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.guice.Injectors;
import net.thucydides.core.util.EnvironmentVariables;

import java.util.HashMap;
import java.util.Map;

public class Requests {

    private static final String API_KEY = "d8061edf621c61a1fb1d90f76d33fbaa";
    private static final String API_TOKEN = "04da8e13b9499e5d0557b1461f96b1d6c3d3942bcebee6850e9eaff610e28aea";
    private static final Map<String, String> AUTH_QUERY_PARAMS = new HashMap<String, String>() {
        {
            put("key", API_KEY);
            put("token", API_TOKEN);
        }
    };
    private static final EnvironmentVariables ENVIRONMENT_VARIABLES = Injectors.getInjector()
            .getInstance(EnvironmentVariables.class);

    public static RequestSpecification request() {
        return new RequestSpecBuilder().setBaseUri(getBaseUrl())
                .setUrlEncodingEnabled(true)
                .setAccept("application/json")
                .addQueryParams(AUTH_QUERY_PARAMS)
                .build();
    }

    public static String getBaseUrl(){
        return ENVIRONMENT_VARIABLES.getProperty("restapi.base.url");
    }

}
