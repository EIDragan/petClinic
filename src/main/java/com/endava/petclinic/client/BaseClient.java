package com.endava.petclinic.client;

import com.endava.petclinic.filters.LogFilter;
import com.endava.petclinic.util.EnvReader;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class BaseClient {

    protected RequestSpecification getBasicRestConfig() {
        return given().filter(new LogFilter())
                .baseUri(EnvReader.getBaseUri())
                .basePath(EnvReader.getBasePath());
    }

}
