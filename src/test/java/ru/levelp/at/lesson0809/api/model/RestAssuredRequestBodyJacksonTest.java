package ru.levelp.at.lesson0809.api.model;

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
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RestAssuredRequestBodyJacksonTest {

    private static final String SERVICE_BASE_URI = "http://localhost";
    private static final int SERVICE_PORT = 8082;
    private static final String SERVICE_BASE_PATH = "srv-person-profile";

    private static final Faker FAKER = new Faker();

    private RequestSpecification requestSpecification;
    private ResponseSpecification responseSpecificationHttpStatusCreated;
    private ResponseSpecification responseSpecificationHttpStatusOk;

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

        responseSpecificationHttpStatusOk = new ResponseSpecBuilder()
            .log(LogDetail.ALL)
            .expectStatusCode(HttpStatus.SC_OK)
            .build();
    }

    @Test
    void createPerson() {
        System.out.println(this.getClass().getName() + "#createPerson");
        System.out.println("=======");
        final var email = FAKER.internet().emailAddress();
        final var phoneNumber = FAKER.phoneNumber().cellPhone();
        final var firstName = FAKER.name().firstName();
        final var lastName = FAKER.name().lastName();

        CreatePersonRequest body = CreatePersonRequest
            .builder()
            .role("WORK_INSPECTOR")
            .email(email)
            .phoneNumber(phoneNumber)
            .identity(IdentityData.builder()
                                  .firstName(firstName)
                                  .lastName(lastName)
                                  .build())
            .build();

        System.out.println(body);

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
        System.out.println("=======");
    }

    @Test
    void createPersonWithResponseBodyAsObject() {
        System.out.println(this.getClass().getName() + "#createPersonWithResponseBodyAsObject");
        System.out.println("=======");
        final var email = FAKER.internet().emailAddress();
        final var phoneNumber = FAKER.phoneNumber().cellPhone();
        final var firstName = FAKER.name().firstName();
        final var lastName = FAKER.name().lastName();

        CreatePersonRequest body = CreatePersonRequest
            .builder()
            .role("WORK_INSPECTOR")
            .email(email)
            .phoneNumber(phoneNumber)
            .identity(IdentityData.builder()
                                  .firstName(firstName)
                                  .lastName(lastName)
                                  .build())
            .build();

        System.out.println(body);

        PersonResponse personResponse = given()
            .spec(requestSpecification)
            .body(body)
            .when()
            .post("/people")
            .then()
            .spec(responseSpecificationHttpStatusCreated)
            .extract()
            .as(PersonResponse.class);

        System.out.println(personResponse);

        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(personResponse.getData().getId()).isNotBlank();
            softly.assertThat(personResponse.getData().getEmail()).isEqualTo(email);
            softly.assertThat(personResponse.getData().getPhoneNumber()).isEqualTo(phoneNumber);
            softly.assertThat(personResponse.getData().getIdentity().getFirstName()).isEqualTo(firstName);
            softly.assertThat(personResponse.getData().getIdentity().getLastName()).isEqualTo(lastName);
        });

        System.out.println("=======");
    }

    @Test
    void createPersonWithResponseBodyAsObjectAndGetRequest() {
        System.out.println(this.getClass().getName() + "#createPersonWithResponseBodyAsObjectAndGetRequest");
        System.out.println("=======");
        final var email = FAKER.internet().emailAddress();
        final var phoneNumber = FAKER.phoneNumber().cellPhone();
        final var firstName = FAKER.name().firstName();
        final var lastName = FAKER.name().lastName();

        CreatePersonRequest body = CreatePersonRequest
            .builder()
            .role("WORK_INSPECTOR")
            .email(email)
            .phoneNumber(phoneNumber)
            .identity(IdentityData.builder()
                                  .firstName(firstName)
                                  .lastName(lastName)
                                  .build())
            .build();

        System.out.println(body);

        PersonResponse personResponse = given()
            .spec(requestSpecification)
            .body(body)
            .when()
            .post("/people")
            .then()
            .spec(responseSpecificationHttpStatusCreated)
            .extract()
            .as(PersonResponse.class);

        System.out.println(personResponse);

        PersonResponse getPersonResponse = given()
            .spec(requestSpecification)
            .when()
            .get("/people/{personId}", personResponse.getData().getId())
            .then()
            .spec(responseSpecificationHttpStatusOk)
            .extract()
            .as(PersonResponse.class);

        System.out.println(getPersonResponse);

        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(getPersonResponse.getData().getId()).isNotBlank();
            softly.assertThat(getPersonResponse.getData().getEmail()).isEqualTo(email);
            softly.assertThat(getPersonResponse.getData().getPhoneNumber()).isEqualTo(phoneNumber);
            softly.assertThat(getPersonResponse.getData().getIdentity().getFirstName()).isEqualTo(firstName);
            softly.assertThat(getPersonResponse.getData().getIdentity().getLastName()).isEqualTo(lastName);
        });

        System.out.println("=======");
    }

    @Test
    void getPeople() {
        System.out.println(this.getClass().getName() + "#getPeople");
        System.out.println("=======");

        PersonListResponse response = given()
            .spec(requestSpecification)
            .when()
            .get("/people")
            .then()
            .spec(responseSpecificationHttpStatusOk)
            .extract()
            .as(PersonListResponse.class);

        System.out.println(response);

        System.out.println("=======");
    }
}
