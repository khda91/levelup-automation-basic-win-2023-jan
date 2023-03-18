package ru.levelp.at.trello.taf.step;

import static org.assertj.core.api.Assertions.assertThat;

import io.qameta.allure.Step;
import ru.levelp.at.trello.taf.page.TrelloBoardPage;

public class TrelloBoardStep extends TrelloBaseStep {

    private final TrelloBoardPage boardPage;

    public TrelloBoardStep() {
        boardPage = new TrelloBoardPage(driver);
    }

    @Step("Название доски должно быть '{expectedBoardName}'")
    public void checkBoardTitle(final String expectedBoardName) {
        final var actualBoardTitle = boardPage.getTitle();
        assertThat(actualBoardTitle)
            .as("Имя созданной достки не совпадает с ожидаемым")
            .isEqualTo(expectedBoardName);
    }

    @Step("Удаляем доску")
    public void deleteBoard() {
        boardPage.clickShowMenuButton();
        boardPage.clickMoreButton();
        boardPage.clickCloseBoardButton();
        boardPage.clickConfirmationCloseBoardButton();
        boardPage.clickCloseBoardDeleteBoardButton();
        boardPage.clickCloseBoardDeleteConfirmBoardButton();
    }
}
