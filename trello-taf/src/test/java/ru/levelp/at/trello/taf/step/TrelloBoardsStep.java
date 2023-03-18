package ru.levelp.at.trello.taf.step;

import io.qameta.allure.Step;
import org.assertj.core.api.Assertions;
import ru.levelp.at.trello.taf.page.TrelloBoardsPage;
import ru.levelp.at.trello.taf.page.TrelloBoardsPage.MenuItem;
import ru.levelp.at.trello.taf.page.component.TrelloBoardCardComponent;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class TrelloBoardsStep extends TrelloBaseStep {

    private final TrelloBoardsPage boardsPage;

    public TrelloBoardsStep() {
        boardsPage = new TrelloBoardsPage(driver);
    }

    @Step("Создаем новую доску с именем '{boardName}'")
    public void createNewBoard(final String boardName) {
        boardsPage.clickCreateButton();
        boardsPage.selectMenu(MenuItem.CREATE_BOARD);
        boardsPage.sendKeysToBoardTitleTextField(boardName);
        boardsPage.clickCreateBoardButton();
    }

    @Step("Окрываем доску: {name}")
    public void openBoard(final String name) {
        boardsPage.openBoard(name);
    }

    @Step("Проверяем, что доска '{name}' удалена")
    public void assertThatBoardShouldBeDeleted(final String name) {
        List<String> boardNames = boardsPage.getBoards().stream()
                                            .map(TrelloBoardCardComponent::getTitle)
                                            .collect(Collectors.toList());

        assertThat(boardNames)
            .as(String.format("Доска %s не удалена", name))
            .doesNotContain(name);
    }
}
