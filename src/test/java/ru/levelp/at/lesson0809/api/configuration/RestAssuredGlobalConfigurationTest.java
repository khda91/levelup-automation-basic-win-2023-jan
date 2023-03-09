package ru.levelp.at.lesson0809.api.configuration;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.not;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RestAssuredGlobalConfigurationTest {

    private static final String SERVICE_BASE_URI = "http://localhost";
    private static final int SERVICE_PORT = 8082;
    private static final String SERVICE_BASE_PATH = "srv-person-profile";

    private RequestSpecification requestSpecification;
    private ResponseSpecification responseSpecificationHttpStatusOk;
    private ResponseSpecification responseSpecificationHttpStatusNoContent;

    @BeforeAll
    static void beforeAll() {
        RestAssured.baseURI = SERVICE_BASE_URI;
        RestAssured.port = SERVICE_PORT;
        RestAssured.basePath = SERVICE_BASE_PATH;
    }

    @BeforeEach
    void setUp() {
        requestSpecification = new RequestSpecBuilder()
            .log(LogDetail.ALL)
            .build();

        responseSpecificationHttpStatusOk = new ResponseSpecBuilder()
            .log(LogDetail.ALL)
            .expectStatusCode(HttpStatus.SC_OK)
            .build();

        responseSpecificationHttpStatusNoContent = new ResponseSpecBuilder()
            .log(LogDetail.ALL)
            .expectStatusCode(HttpStatus.SC_NO_CONTENT)
            .build();
    }

    @Test
    void getMessengers() {
        RestAssured
            .given()
            .spec(requestSpecification)
            .when()
            .get("/messengers")
            .then()
            .spec(responseSpecificationHttpStatusOk)
            .body("data.id", Matchers.hasItems("TELEGRAM", "VIBER", "WHATS_UP"));
    }

    @Test
    void createMessengers() {
        final var faker = new Faker();
        final var messengerId = faker.funnyName().name().toUpperCase().replaceAll(" ", "_");

        RestAssured
            .given()
            .spec(requestSpecification)
            .when()
            .put("/messengers/" + messengerId)
            .then()
            .spec(responseSpecificationHttpStatusNoContent);

        RestAssured
            .given()
            .spec(requestSpecification)
            .when()
            .get("/messengers")
            .then()
            .spec(responseSpecificationHttpStatusOk)
            .body("data.id", hasItem(messengerId));
    }

    @Test
    void deleteMessenger() {
        final var faker = new Faker();
        final var messengerId = faker.funnyName().name().toUpperCase().replaceAll(" ", "_");

        RestAssured
            .given()
            .spec(requestSpecification)
            .when()
            .put("/messengers/" + messengerId)
            .then()
            .spec(responseSpecificationHttpStatusNoContent);

        RestAssured
            .given()
            .spec(requestSpecification)
            .when()
            .delete("/messengers/" + messengerId)
            .then()
            .spec(responseSpecificationHttpStatusNoContent);

        RestAssured
            .given()
            .spec(requestSpecification)
            .when()
            .get("/messengers")
            .then()
            .spec(responseSpecificationHttpStatusOk)
            .body("data.id", not(hasItem(messengerId)));
    }

    @Test
    void deleteMessengerWithPathParams() {
        final var faker = new Faker();
        final var messengerId = faker.funnyName().name().toUpperCase().replaceAll(" ", "_");

        RestAssured
            .given()
            .spec(requestSpecification)
            .pathParams("messengerId", messengerId)
            .when()
            .put("/messengers/{messengerId}")
            .then()
            .spec(responseSpecificationHttpStatusNoContent);

        RestAssured
            .given()
            .spec(requestSpecification)
            .when()
            .delete("/messengers/{messengerId}", messengerId)
            .then()
            .spec(responseSpecificationHttpStatusNoContent);

        RestAssured
            .given()
            .spec(requestSpecification)
            .when()
            .get("/messengers")
            .then()
            .spec(responseSpecificationHttpStatusOk)
            .body("data.id", not(hasItem(messengerId)));
    }

    @Test
    void getMessengersWithQueryParams() {
        RestAssured
            .given()
            .spec(requestSpecification)
            .queryParam("limit", 1)
            .when()
            .get("/messengers")
            .then()
            .spec(responseSpecificationHttpStatusOk)
            .body("data.id", hasSize(1))
            .body("meta.pagination.limit", equalTo(1));
    }

    @Test
    void getPeopleWithQueryParams() {
        RestAssured
            .given()
            .spec(requestSpecification)
            .queryParam("email", "testemail12312@email.com")
            .when()
            .get("/people")
            .then()
            .spec(responseSpecificationHttpStatusOk)
            .body("data.id", hasSize(1))
            .body("meta.pagination.limit", equalTo(10));
    }
}
