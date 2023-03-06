package ru.levelp.at.lesson0809.api.service;

import static io.restassured.RestAssured.given;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.RequiredArgsConstructor;
import ru.levelp.at.lesson0809.api.model.CreatePersonRequest;

@RequiredArgsConstructor
public class PeopleService {

    private static final String PEOPLE_ENDPOINT = "/people";
    private static final String PERSON_ENDPOINT = PEOPLE_ENDPOINT + "/{personId}";

    private final RequestSpecification requestSpecification;

    public Response createPerson(CreatePersonRequest request) {
        return given()
            .spec(requestSpecification)
            .body(request)
            .when()
            .post(PEOPLE_ENDPOINT)
            .andReturn();
    }

    public Response getPerson(final String id) {
        return given()
            .spec(requestSpecification)
            .when()
            .get(PERSON_ENDPOINT, id)
            .andReturn();
    }
}
