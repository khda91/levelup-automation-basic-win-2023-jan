package ru.levelp.at.trello.taf.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TrelloLoginPage extends BasePage {

    private static final String LOGIN_URL = "/login";

    @FindBy(xpath = "//*[@id='user']")
    private WebElement usernameTextField;

    @FindBy(xpath = "//*[@id='login']")
    private WebElement continueButton;

    @FindBy(xpath = "//*[@id='password']")
    private WebElement passwordTextField;

    @FindBy(xpath = "//*[@id='login-submit']")
    private WebElement loginButton;

    public TrelloLoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {
        open(LOGIN_URL);
    }


    public void sendKeysToUsernameTextField(final String username) {
        wait.until(ExpectedConditions.visibilityOf(usernameTextField)).sendKeys(username);
    }

    public void clickContinueButton() {
        wait.until(ExpectedConditions.elementToBeClickable(continueButton)).click();
    }

    public void sendKeysToPasswordTextField(final String password) {
        wait.until(ExpectedConditions.visibilityOf(passwordTextField)).sendKeys(password);
    }

    public void clickLoginButton() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
    }
}
