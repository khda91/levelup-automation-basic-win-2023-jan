package ru.levelp.at.lesson0809.api.model;

import static io.restassured.RestAssured.given;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import java.time.LocalDate;
import java.time.ZoneId;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.http.HttpStatus;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RestAssuredObjectTest {

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
    void createPersonTest() {
        // 1. Генераниция пользователя
        var requestBody = generatePersonCreateRequestBody();

        // 2. Создание пользователя
        var tmpResponse = createPerson(requestBody);

        // 3. Получение пользователя по id
        var actualResponse = getPerson(tmpResponse.getData().getId());

        // 4. Проверка пользователя
        checkCreatePerson(requestBody, actualResponse);
    }

    private CreatePersonRequest generatePersonCreateRequestBody() {
        return CreatePersonRequest
            .builder()
            .email(FAKER.internet().emailAddress())
            .phoneNumber(FAKER.phoneNumber().cellPhone())
            .role("LECTOR")
            .placeOfWork(FAKER.company().name())
            .identity(IdentityData
                .builder()
                .firstName(FAKER.name().firstName())
                .lastName(FAKER.name().lastName())
                .dateOfBirth(LocalDate.ofInstant(FAKER.date().birthday().toInstant(), ZoneId.systemDefault()))
                .passport(PassportData
                    .builder()
                    .series(RandomStringUtils.randomNumeric(4))
                    .number(RandomStringUtils.randomNumeric(6))
                    .build())
                .build())
            .address(AddressData
                .builder()
                .street(FAKER.address().streetName())
                .houseNumber(Integer.parseInt(FAKER.address().buildingNumber()))
                .city(FAKER.address().city())
                .build())
            .build();
    }

    private PersonResponse createPerson(CreatePersonRequest request) {
        return given()
            .spec(requestSpecification)
            .body(request)
            .when()
            .post("/people")
            .then()
            .spec(responseSpecificationHttpStatusCreated)
            .extract()
            .as(PersonResponse.class);
    }

    private PersonResponse getPerson(String id) {
        return given()
            .spec(requestSpecification)
            .when()
            .get("/people/{personId}", id)
            .then()
            .spec(responseSpecificationHttpStatusOk)
            .extract()
            .as(PersonResponse.class);
    }

    private void checkCreatePerson(CreatePersonRequest request, PersonResponse actualResponse) {
        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(actualResponse.getData().getId()).isNotBlank();
            softly.assertThat(actualResponse.getData().getEmail()).isEqualTo(request.getEmail());
            softly.assertThat(actualResponse.getData().getPhoneNumber()).isEqualTo(request.getPhoneNumber());
            softly.assertThat(actualResponse.getData().getRole()).isEqualTo(request.getRole());
            softly.assertThat(actualResponse.getData().getPlaceOfWork()).isEqualTo(request.getPlaceOfWork());
            softly.assertThat(actualResponse.getData().getIdentity().getFirstName())
                  .isEqualTo(request.getIdentity().getFirstName());
            softly.assertThat(actualResponse.getData().getIdentity().getLastName())
                  .isEqualTo(request.getIdentity().getLastName());
            softly.assertThat(actualResponse.getData().getIdentity().getDateOfBirth())
                  .isEqualTo(request.getIdentity().getDateOfBirth());
            softly.assertThat(actualResponse.getData().getIdentity().getPassport().getNumber())
                  .isEqualTo(request.getIdentity().getPassport().getNumber());
            softly.assertThat(actualResponse.getData().getIdentity().getPassport().getSeries())
                  .isEqualTo(request.getIdentity().getPassport().getSeries());
            softly.assertThat(actualResponse.getData().getAddress().getStreet())
                  .isEqualTo(request.getAddress().getStreet());
            softly.assertThat(actualResponse.getData().getAddress().getHouseNumber())
                  .isEqualTo(request.getAddress().getHouseNumber());
            softly.assertThat(actualResponse.getData().getAddress().getCity())
                  .isEqualTo(request.getAddress().getCity());
        });
    }
}
