package ru.levelp.at.lesson0809.api.configuration;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.not;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class RestAssuredConfigurationTest {

    private static final String SERVICE_BASE_URI = "http://localhost:8082";
    private static final String SERVICE_BASE_PATH = "srv-person-profile";

    @Test
    void getMessengers() {
        RestAssured
            .given()
            .log().all()
            .baseUri(SERVICE_BASE_URI)
            .basePath(SERVICE_BASE_PATH)
            .when()
            .get("/messengers")
            .then()
            .log().all()
            .statusCode(200)
            .body("data.id", Matchers.hasItems("TELEGRAM", "VIBER", "WHATS_UP"));
    }

    @Test
    void createMessengers() {
        final var faker = new Faker();
        final var messengerId = faker.funnyName().name().toUpperCase().replaceAll(" ", "_");

        RestAssured
            .given()
            .log().all()
            .baseUri(SERVICE_BASE_URI)
            .basePath(SERVICE_BASE_PATH)
            .when()
            .put("/messengers/" + messengerId)
            .then()
            .log().all()
            .statusCode(204);

        RestAssured
            .given()
            .log().all()
            .baseUri(SERVICE_BASE_URI)
            .basePath(SERVICE_BASE_PATH)
            .when()
            .get("/messengers")
            .then()
            .log().all()
            .statusCode(200)
            .body("data.id", hasItem(messengerId));
    }

    @Test
    void deleteMessenger() {
        final var faker = new Faker();
        final var messengerId = faker.funnyName().name().toUpperCase().replaceAll(" ", "_");

        RestAssured
            .given()
            .log().all()
            .baseUri(SERVICE_BASE_URI)
            .basePath(SERVICE_BASE_PATH)
            .when()
            .put("/messengers/" + messengerId)
            .then()
            .log().all()
            .statusCode(204);

        RestAssured
            .given()
            .log().all()
            .baseUri(SERVICE_BASE_URI)
            .basePath(SERVICE_BASE_PATH)
            .when()
            .delete("/messengers/" + messengerId)
            .then()
            .log().all()
            .statusCode(204);

        RestAssured
            .given()
            .log().all()
            .baseUri(SERVICE_BASE_URI)
            .basePath(SERVICE_BASE_PATH)
            .when()
            .get("/messengers")
            .then()
            .log().all()
            .statusCode(200)
            .body("data.id", not(hasItem(messengerId)));
    }

    @Test
    void deleteMessengerWithPathParams() {
        final var faker = new Faker();
        final var messengerId = faker.funnyName().name().toUpperCase().replaceAll(" ", "_");

        RestAssured
            .given()
            .log().all()
            .baseUri(SERVICE_BASE_URI)
            .basePath(SERVICE_BASE_PATH)
            .pathParams("messengerId", messengerId)
            .when()
            .put("/messengers/{messengerId}")
            .then()
            .log().all()
            .statusCode(204);

        RestAssured
            .given()
            .log().all()
            .baseUri(SERVICE_BASE_URI)
            .basePath(SERVICE_BASE_PATH)
            .when()
            .delete("/messengers/{messengerId}", messengerId)
            .then()
            .log().all()
            .statusCode(204);

        RestAssured
            .given()
            .log().all()
            .baseUri(SERVICE_BASE_URI)
            .basePath(SERVICE_BASE_PATH)
            .when()
            .get("/messengers")
            .then()
            .log().all()
            .statusCode(200)
            .body("data.id", not(hasItem(messengerId)));
    }

    @Test
    void getMessengersWithQueryParams() {
        RestAssured
            .given()
            .log().all()
            .baseUri(SERVICE_BASE_URI)
            .basePath(SERVICE_BASE_PATH)
            .queryParam("limit", 1)
            .when()
            .get("/messengers")
            .then()
            .log().all()
            .statusCode(200)
            .body("data.id", hasSize(1))
            .body("meta.pagination.limit", equalTo(1));
    }

    @Test
    void getPeopleWithQueryParams() {
        RestAssured
            .given()
            .log().all()
            .baseUri(SERVICE_BASE_URI)
            .basePath(SERVICE_BASE_PATH)
            .queryParam("email", "testemail12312@email.com")
            .when()
            .get("/people")
            .then()
            .log().all()
            .statusCode(200)
            .body("data.id", hasSize(1))
            .body("meta.pagination.limit", equalTo(10));
    }
}
