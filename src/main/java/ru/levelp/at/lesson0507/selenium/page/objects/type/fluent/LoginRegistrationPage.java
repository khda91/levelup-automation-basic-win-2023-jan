package ru.levelp.at.lesson0507.selenium.page.objects.type.fluent;

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

    public LoginRegistrationPage open() {
        open(URL);
        return this;
    }

    public LoginRegistrationPage fillNameTextField(final String name) {
        sendKeys(nameTextField, name);
        return this;
    }

    public LoginRegistrationPage fillEmailTextField(final String email) {
        wait.until(ExpectedConditions.visibilityOf(emailTextField)).sendKeys(email);
        return this;
    }

    public LoginRegistrationPage fillPasswordTextField(final String password) {
        wait.until(ExpectedConditions.visibilityOf(passwordTextField)).sendKeys(password);
        return this;
    }

    public IndexPage clickRegisterButton() {
        click(registerButton);
        return new IndexPage(driver);
    }

    public IndexPage successClickRegisterButton() {
        click(registerButton);
        return new IndexPage(driver);
    }

    public LoginRegistrationPage failClickRegisterButton() {
        click(registerButton);
        return new LoginRegistrationPage(driver);
    }

    public String getErrorMessageLabelText() {
        return wait.until(ExpectedConditions.visibilityOf(errorMessageLabel)).getText();
    }
}
