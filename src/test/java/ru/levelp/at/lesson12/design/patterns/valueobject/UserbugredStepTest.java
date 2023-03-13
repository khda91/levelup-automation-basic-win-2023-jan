package ru.levelp.at.lesson12.design.patterns.valueobject;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.levelp.at.lesson11.jenkins.BaseSeleniumTest;
import ru.levelp.at.lesson11.jenkins.annotation.MyCustomLabel;
import ru.levelp.at.lesson12.design.patterns.valueobject.step.UserbugredStep;

@Epic("Epic 1")
@TmsLink("OOO-546")
@DisplayName("Регистрация пользователя")
class UserbugredStepTest extends BaseSeleniumTest {

    private UserbugredStep userbugredStep;

    private User userData;

    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
        userbugredStep = new UserbugredStep(driver);

        userData = new User(faker.funnyName().name(), faker.internet().emailAddress(), faker.internet().password());
    }

    @Test
    @Story("Story 2")
    @Feature("Feature 1")
    @TmsLink("OOO-547")
    @DisplayName("Успешная регистрация пользователя в системе")
    @MyCustomLabel("моё кастомное значение")
    void registrationTest() {
        userbugredStep.openRegistrationPage();
        userbugredStep.registerUser(userData);
        userbugredStep.assertCreateUserName(userData.getName());
    }

    @Test
    @Story("Story 2")
    @Feature("Feature 2")
    @TmsLink("OOO-548")
    @DisplayName("Не успешная регистрация пользователя в системе")
    void negativeRegistrationTest() {
        userData = new User(faker.funnyName().name(), faker.internet().emailAddress(), faker.internet().password());

        userbugredStep.openRegistrationPage();
        userbugredStep.registerUser(userData);
        userbugredStep.assertErrorMessageText("register_not_correct_field (email)");
    }
}
