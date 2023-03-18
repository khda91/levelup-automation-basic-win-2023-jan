package ru.levelp.at.trello.taf.test;

import com.github.javafaker.Faker;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import ru.levelp.at.trello.taf.configuration.provider.ConfigProvider;
import ru.levelp.at.trello.taf.service.api.BoardsApiClient;
import ru.levelp.at.trello.taf.service.wed.driver.WebDriverProvider;
import ru.levelp.at.trello.taf.step.TrelloBoardStep;
import ru.levelp.at.trello.taf.step.TrelloBoardsStep;
import ru.levelp.at.trello.taf.step.TrelloCommonSteps;
import ru.levelp.at.trello.taf.step.TrelloLoginStep;
import java.util.Map;

public abstract class TrelloBaseTest {

    protected static final Faker FAKER = new Faker();

    protected TrelloCommonSteps commonStep;
    protected TrelloLoginStep loginStep;
    protected TrelloBoardsStep boardsStep;
    protected TrelloBoardStep boardStep;

    protected BoardsApiClient boardsApiClient;

    @BeforeEach
    void setUp() {
        WebDriverProvider.getDriver();
        commonStep = new TrelloCommonSteps();
        loginStep = new TrelloLoginStep();
        boardsStep = new TrelloBoardsStep();
        boardStep = new TrelloBoardStep();
    }

    @BeforeEach
    void apiSetUp() {
        var apiUrl = ConfigProvider.apiConfig().getApiUrl();
        var apiVersion = ConfigProvider.apiConfig().getApiVersion();

        RequestSpecification requestSpecification = new RequestSpecBuilder()
            .setBaseUri(apiUrl)
            .setBasePath(apiVersion)
            .setContentType(ContentType.JSON)
            .addQueryParams(Map.of(
                "key", ConfigProvider.apiConfig().getApiKey(),
                "token", ConfigProvider.apiConfig().getApiToken()
            ))
            .log(LogDetail.ALL)
            .build();

        boardsApiClient = new BoardsApiClient(requestSpecification);
    }

    @AfterEach
    void tearDown() {
        WebDriverProvider.closeDriver();
    }
}
