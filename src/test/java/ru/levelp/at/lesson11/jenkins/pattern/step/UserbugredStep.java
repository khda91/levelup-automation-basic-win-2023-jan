package ru.levelp.at.lesson11.jenkins.pattern.step;

import static org.assertj.core.api.Assertions.assertThat;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import ru.levelp.at.lesson11.jenkins.userbugred.IndexPage;
import ru.levelp.at.lesson11.jenkins.userbugred.LoginRegistrationPage;

public class UserbugredStep {

    private final LoginRegistrationPage loginRegistrationPage;
    private final IndexPage indexPage;

    public UserbugredStep(WebDriver driver) {
        this.indexPage = new IndexPage(driver);
        this.loginRegistrationPage = new LoginRegistrationPage(driver);
    }

    @Step("Открываем страницу регистрации пользователя ")
    public void openRegistrationPage() {
        loginRegistrationPage.open();
    }

    @Step("Региструем пользоватся с name = {name}, email = {email}, password = {password}")
    public void registerUser(final String name, final String email, final String password) {
        loginRegistrationPage.fillNameTextField(name);
        loginRegistrationPage.fillEmailTextField(email);
        loginRegistrationPage.fillPasswordTextField(password);
        loginRegistrationPage.clickRegisterButton();
    }

    @Step("Проверяем что пользователь создался с именем {expectedName}")
    public void assertCreateUserName(final String expectedName) {
        var actualUsername = indexPage.getUserDropdownText();
        assertThat(actualUsername).isEqualToIgnoringCase(expectedName);
    }

    @Step("Текст ошибки должен совпадать с {expectedErrorText}")
    public void assertErrorMessageText(final String expectedErrorText) {
        String actualErrorMessageText = loginRegistrationPage.getErrorMessageLabelText();
        assertThat(actualErrorMessageText).isEqualToIgnoringCase(expectedErrorText);
    }
}
