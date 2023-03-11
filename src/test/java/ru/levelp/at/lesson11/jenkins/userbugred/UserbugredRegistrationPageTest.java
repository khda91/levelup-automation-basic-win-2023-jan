package ru.levelp.at.lesson11.jenkins.userbugred;

import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.levelp.at.lesson11.jenkins.BaseSeleniumTest;
import ru.levelp.at.lesson11.jenkins.annotation.MyCustomLabel;

@Epic("Epic 1")
@TmsLink("OOO-546")
@DisplayName("Регистрация пользователя")
class UserbugredRegistrationPageTest extends BaseSeleniumTest {

    private LoginRegistrationPage loginRegistrationPage;
    private IndexPage indexPage;

    private String nameData;
    private String emailData;
    private String passwordData;

    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
        loginRegistrationPage = new LoginRegistrationPage(driver);
        indexPage = new IndexPage(driver);

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
        loginRegistrationPage.open();
        loginRegistrationPage.fillNameTextField(nameData);
        loginRegistrationPage.fillEmailTextField(emailData);
        loginRegistrationPage.fillPasswordTextField(passwordData);
        loginRegistrationPage.clickRegisterButton();

        step("Проверка имени пользователя при регистрации", () -> {
            var actualUsername = indexPage.getUserDropdownText();
            assertThat(actualUsername).isEqualToIgnoringCase(nameData);
        });
    }

    @Test
    @Story("Story 2")
    @Feature("Feature 2")
    @TmsLink("OOO-548")
    @DisplayName("Не успешная регистрация пользователя в системе")
    void negativeRegistrationTest() {
        emailData = faker.internet().domainSuffix();

        loginRegistrationPage.open();
        loginRegistrationPage.fillNameTextField(nameData);
        loginRegistrationPage.fillEmailTextField(emailData);
        loginRegistrationPage.fillPasswordTextField(passwordData);
        loginRegistrationPage.clickRegisterButton();

        step("Проверка текста ошибки", () -> {
            String actualErrorMessageText = loginRegistrationPage.getErrorMessageLabelText();
            assertThat(actualErrorMessageText).isEqualToIgnoringCase("register_not_correct_field (email)");
        });
    }
}
