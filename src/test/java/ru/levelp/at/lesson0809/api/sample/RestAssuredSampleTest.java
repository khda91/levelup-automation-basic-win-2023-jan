package ru.levelp.at.lesson0809.api.sample;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

class RestAssuredSampleTest {

    @Test
    void getMessengers() {
        RestAssured
            .when()
            .get("http://localhost:8082/srv-person-profile/messengers")
            .then()
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
            .when()
            .put("http://localhost:8082/srv-person-profile/messengers/" + messengerId)
            .then()
            .log().all()
            .statusCode(204);

        RestAssured
            .when()
            .get("http://localhost:8082/srv-person-profile/messengers")
            .then()
            .statusCode(200)
            .body("data.id", Matchers.hasItem(messengerId));
    }
}
