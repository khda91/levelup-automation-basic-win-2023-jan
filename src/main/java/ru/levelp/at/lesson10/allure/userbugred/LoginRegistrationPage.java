package ru.levelp.at.lesson10.allure.userbugred;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginRegistrationPage extends BasePage {

    private static final String URL = "/user/login/index.html";

    @FindBy(xpath = "//form[contains(@action, 'register')]//input[@name='name']")
    private WebElement nameTextField;

    @FindBy(xpath = "//form[contains(@action, 'register')]//input[@name='email']")
    private WebElement emailTextField;

    @FindBy(xpath = "//form[contains(@action, 'register')]//input[@name='password']")
    private WebElement passwordTextField;

    @FindBy(xpath = "//form[contains(@action, 'register')]//input[@name='act_register_now']")
    private WebElement registerButton;

    @FindBy(xpath = "//form[contains(@action, 'register')]/p")
    private WebElement errorMessageLabel;

    public LoginRegistrationPage(final WebDriver driver) {
        super(driver);
    }

    @Override
    @Step("Открываем userbugred домашнюю страницу")
    public void open() {
        open(URL);
    }

    @Step("Вводим имя пользователя {name}")
    public void fillNameTextField(final String name) {
        sendKeys(nameTextField, name);
    }

    @Step("Вводим почтовый адрес {email}")
    public void fillEmailTextField(final String email) {
        wait.until(ExpectedConditions.visibilityOf(emailTextField)).sendKeys(email);
    }

    @Step("Вводим пароль")
    public void fillPasswordTextField(final String password) {
        wait.until(ExpectedConditions.visibilityOf(passwordTextField)).sendKeys(password);
    }

    @Step("Нажимаем на кнопку 'Регистировать'")
    public void clickRegisterButton() {
        click(registerButton);
    }

    public String getErrorMessageLabelText() {
        return wait.until(ExpectedConditions.visibilityOf(errorMessageLabel)).getText();
    }
}
