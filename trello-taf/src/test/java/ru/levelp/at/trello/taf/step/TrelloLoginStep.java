package ru.levelp.at.trello.taf.step;

import io.qameta.allure.Step;
import ru.levelp.at.trello.taf.page.TrelloLoginPage;
import ru.levelp.at.trello.taf.page.TrelloMainPage;

public class TrelloLoginStep extends TrelloBaseStep {

    private final TrelloMainPage mainPage;
    private final TrelloLoginPage loginPage;

    public TrelloLoginStep() {
        super();
        this.mainPage = new TrelloMainPage(driver);
        this.loginPage = new TrelloLoginPage(driver);
    }

    @Step("Авторизация пользрователя {username}")
    public void login(final String username, final String password) {
        mainPage.clickLoginButton();
        loginPage.sendKeysToUsernameTextField(username);
        loginPage.clickContinueButton();
        loginPage.sendKeysToPasswordTextField(password);
        loginPage.clickLoginButton();
    }
}
