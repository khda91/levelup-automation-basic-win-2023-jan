package ru.levelp.at.lesson0809.api.body;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.commons.io.FileUtils;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

class RestAssuredRequestBodyFilePlaceholderTest {

    private static final String SERVICE_BASE_URI = "http://localhost";
    private static final int SERVICE_PORT = 8082;
    private static final String SERVICE_BASE_PATH = "srv-person-profile";

    private static final Faker FAKER = new Faker();

    private RequestSpecification requestSpecification;
    private ResponseSpecification responseSpecificationHttpStatusCreated;

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
            .setContentType(ContentType.JSON)
            .build();

        responseSpecificationHttpStatusCreated = new ResponseSpecBuilder()
            .log(LogDetail.ALL)
            .expectStatusCode(HttpStatus.SC_CREATED)
            .build();
    }

    @Test
    void createPerson() {
        String body = "";
        try {
            body = FileUtils
                .readFileToString(new File("src/test/resources/ru/levelp/at/lesson0809" +
                    "/api/create_person_request_body_placeholder.json"), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        final var email = FAKER.internet().emailAddress();
        final var phoneNumber = FAKER.phoneNumber().cellPhone();
        final var firstName = FAKER.name().firstName();
        final var lastName = FAKER.name().lastName();

        body = body.replace("{email}", email)
                   .replace("{phoneNumber}", phoneNumber)
                   .replace("{firstName}", firstName)
                   .replace("{lastName}", lastName);

        given()
            .spec(requestSpecification)
            .body(body)
            .when()
            .post("/people")
            .then()
            .spec(responseSpecificationHttpStatusCreated)
            .body("data.id", not(empty()))
            .body("data.email", equalTo(email))
            .body("data.phoneNumber", equalTo(phoneNumber))
            .body("data.identity.firstName", equalTo(firstName))
            .body("data.identity.lastName", equalTo(lastName));
    }
}
