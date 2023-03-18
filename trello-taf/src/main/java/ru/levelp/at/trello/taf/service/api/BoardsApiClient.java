package ru.levelp.at.trello.taf.service.api;

import static io.restassured.RestAssured.given;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import java.util.Map;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BoardsApiClient {

    private static final String BOARDS_ENDPOINT_PATH = "/boards";

    private final RequestSpecification requestSpecification;

    public Response createBoard(final String name) {
        return given()
            .spec(requestSpecification)
            .queryParams(Map.of("name", name))
            .when()
            .post(BOARDS_ENDPOINT_PATH)
            .andReturn();
    }
}
