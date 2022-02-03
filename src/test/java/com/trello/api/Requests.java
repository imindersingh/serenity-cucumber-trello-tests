package com.trello.api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import net.thucydides.core.guice.Injectors;
import net.thucydides.core.util.EnvironmentVariables;

import java.util.HashMap;
import java.util.Map;

public class Requests {

    private static final EnvironmentVariables ENVIRONMENT_VARIABLES = Injectors.getInjector()
            .getInstance(EnvironmentVariables.class);

    private static final String API_KEY = ENVIRONMENT_VARIABLES.getProperty("restapi.key");
    private static final String API_TOKEN = ENVIRONMENT_VARIABLES.getProperty("restapi.token");
    private static final Map<String, String> AUTH_QUERY_PARAMS = new HashMap<String, String>() {
        {
            put("key", API_KEY);
            put("token", API_TOKEN);
        }
    };

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
