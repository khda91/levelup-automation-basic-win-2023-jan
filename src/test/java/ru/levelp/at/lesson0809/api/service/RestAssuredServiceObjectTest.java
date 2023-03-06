package ru.levelp.at.lesson0809.api.service;

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
import java.util.List;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.http.HttpStatus;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.levelp.at.lesson0809.api.model.AddressData;
import ru.levelp.at.lesson0809.api.model.CreatePersonRequest;
import ru.levelp.at.lesson0809.api.model.IdentityData;
import ru.levelp.at.lesson0809.api.model.PassportData;
import ru.levelp.at.lesson0809.api.model.PersonResponse;
import ru.levelp.at.lesson0809.api.model.ProblemResponse;
import ru.levelp.at.lesson0809.api.model.ViolationData;

public class RestAssuredServiceObjectTest {

    private static final String SERVICE_BASE_URI = "http://localhost";
    private static final int SERVICE_PORT = 8082;
    private static final String SERVICE_BASE_PATH = "srv-person-profile";

    private static final Faker FAKER = new Faker();

    private RequestSpecification requestSpecification;
    private ResponseSpecification responseSpecificationHttpStatusCreated;
    private ResponseSpecification responseSpecificationHttpStatusOk;
    private ResponseSpecification responseSpecificationHttpStatusBadRequest;

    private PeopleService peopleService;

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

        responseSpecificationHttpStatusBadRequest = new ResponseSpecBuilder()
            .log(LogDetail.ALL)
            .expectStatusCode(HttpStatus.SC_BAD_REQUEST)
            .build();

        peopleService = new PeopleService(requestSpecification);
    }

    @Test
    void createPersonTest() {
        // 1. Генераниция пользователя
        var requestBody = generatePersonCreateRequestBody();

        // 2. Создание пользователя
        var tmpResponse = peopleService.createPerson(requestBody)
                                       .then()
                                       .spec(responseSpecificationHttpStatusCreated)
                                       .extract()
                                       .as(PersonResponse.class);

        // 3. Получение пользователя по id
        var actualResponse = peopleService.getPerson(tmpResponse.getData().getId())
                                          .then()
                                          .spec(responseSpecificationHttpStatusOk)
                                          .extract()
                                          .as(PersonResponse.class);

        // 4. Проверка пользователя
        checkCreatePerson(requestBody, actualResponse);
    }

    @Test
    void createPersonFail() {
        var requestBody = generatePersonCreateRequestBodyWithoutRole();

        var response = peopleService.createPerson(requestBody)
                                    .then()
                                    .spec(responseSpecificationHttpStatusBadRequest)
                                    .extract()
                                    .as(ProblemResponse.class);

        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(response.getType()).isEqualTo("validation");
            softly.assertThat(response.getTitle()).isEqualTo("Bad Request");
            softly.assertThat(response.getStatus()).isEqualTo("400");
            softly.assertThat(response.getDetail()).isEqualTo("A malformed request was sent");
            softly.assertThat(response.getViolations())
                  .containsExactlyInAnyOrderElementsOf(List.of(
                      ViolationData.builder()
                                   .code("missing_field")
                                   .detail("must not be null")
                                   .field("CreatePersonData.role")
                                   .build()
                  ));
        });
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

    private CreatePersonRequest generatePersonCreateRequestBodyWithoutRole() {
        return CreatePersonRequest
            .builder()
            .email(FAKER.internet().emailAddress())
            .phoneNumber(FAKER.phoneNumber().cellPhone())
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
