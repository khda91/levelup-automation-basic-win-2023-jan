package ru.levelp.at.trello.taf.step;

import io.qameta.allure.Step;
import ru.levelp.at.trello.taf.page.TrelloMainPage;

public class TrelloCommonSteps extends TrelloBaseStep {

    private final TrelloMainPage mainPage;

    public TrelloCommonSteps() {
        mainPage = new TrelloMainPage(driver);
    }

    @Step("Открываем сайт Trello")
    public void openSite() {
        mainPage.open();
    }
}
