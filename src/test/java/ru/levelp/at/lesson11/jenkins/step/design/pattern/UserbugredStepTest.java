package ru.levelp.at.lesson11.jenkins.step.design.pattern;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.levelp.at.lesson11.jenkins.BaseSeleniumTest;
import ru.levelp.at.lesson11.jenkins.annotation.MyCustomLabel;
import ru.levelp.at.lesson11.jenkins.step.design.pattern.step.UserbugredStep;

@Epic("Epic 1")
@TmsLink("OOO-546")
@DisplayName("Регистрация пользователя")
class UserbugredStepTest extends BaseSeleniumTest {

    private UserbugredStep userbugredStep;

    private String nameData;
    private String emailData;
    private String passwordData;

    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
        userbugredStep = new UserbugredStep(driver);

        nameData = faker.funnyName().name();
        emailData = faker.internet().emailAddress();
        passwordData = faker.internet().password();
    }

    @Test
    @Story("Story 2")
    @Feature("Feature 1")
    @TmsLink("OOO-547")
    @DisplayName("Успешная регистрация пользователя в системе")
    @MyCustomLabel("моё кастомное значение")
    void registrationTest() {
        userbugredStep.openRegistrationPage();
        userbugredStep.registerUser(nameData, emailData, passwordData);
        userbugredStep.assertCreateUserName(nameData);
    }

    @Test
    @Story("Story 2")
    @Feature("Feature 2")
    @TmsLink("OOO-548")
    @DisplayName("Не успешная регистрация пользователя в системе")
    void negativeRegistrationTest() {
        emailData = faker.internet().domainSuffix();

        userbugredStep.openRegistrationPage();
        userbugredStep.registerUser(nameData, emailData, passwordData);
        userbugredStep.assertErrorMessageText("register_not_correct_field (email)");
    }
}
