package ru.levelp.at.lesson0809.api.body;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RestAssuredRequestBodyStringTest {

    private static final String SERVICE_BASE_URI = "http://localhost";
    private static final int SERVICE_PORT = 8082;
    private static final String SERVICE_BASE_PATH = "srv-person-profile";

    private static final Faker FAKER = new Faker();

    private RequestSpecification requestSpecification;
    private ResponseSpecification responseSpecificationHttpStatusOk;
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

        responseSpecificationHttpStatusOk = new ResponseSpecBuilder()
            .log(LogDetail.ALL)
            .expectStatusCode(HttpStatus.SC_OK)
            .build();

        responseSpecificationHttpStatusCreated = new ResponseSpecBuilder()
            .log(LogDetail.ALL)
            .expectStatusCode(HttpStatus.SC_CREATED)
            .build();
    }

    @Test
    void createPerson() {
        final var email = FAKER.internet().emailAddress();

        given()
            .spec(requestSpecification)
            .body("{\n"
                + "  \"role\": \"LECTOR\",\n"
                + "  \"email\": \"" + email + "\",\n"
                + "  \"phoneNumber\": \"+79211234567\",\n"
                + "  \"placeOfWork\": \"Engineer\",\n"
                + "  \"identity\": {\n"
                + "    \"firstName\": \"Vasily\",\n"
                + "    \"lastName\": \"Pupkin\",\n"
                + "    \"middleName\": \"Ivanovich\",\n"
                + "    \"gender\": \"MALE\",\n"
                + "    \"dateOfBirth\": \"1980-02-07\",\n"
                + "    \"placeOfBirth\": \"Moscow\",\n"
                + "    \"passport\": {\n"
                + "      \"series\": \"1234\",\n"
                + "      \"number\": \"123456\",\n"
                + "      \"placeOfIssue\": \"\",\n"
                + "      \"dateOfIssue\": \"1980-02-07\",\n"
                + "      \"departmentCode\": \"123-456\"\n"
                + "    }\n"
                + "  },\n"
                + "  \"address\": {\n"
                + "    \"street\": \"Beethovenstrasse\",\n"
                + "    \"houseNumber\": 12,\n"
                + "    \"houseBuilding\": 1,\n"
                + "    \"houseLetter\": \"A\",\n"
                + "    \"flat\": 123,\n"
                + "    \"city\": \"Moscow\",\n"
                + "    \"postalCode\": \"123456\"\n"
                + "  }\n"
                + "}")
            .when()
            .post("/people")
            .then()
            .spec(responseSpecificationHttpStatusCreated)
            .body("data.id", not(empty()))
            .body("data.email", equalTo(email));
    }
}
