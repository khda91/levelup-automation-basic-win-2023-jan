package ru.levelp.at.trello.taf.test;

import org.junit.jupiter.api.Test;
import ru.levelp.at.trello.taf.configuration.provider.ConfigProvider;

public class TrelloBoardTests extends TrelloBaseTest {

    @Test
    void createBoard() {
        final var boardName = FAKER.funnyName().name();
        final var username = ConfigProvider.userCredentialsConfig().getSimpleTrelloUsername();
        final var password = ConfigProvider.userCredentialsConfig().getSimpleTrelloPassword();

        commonStep.openSite();
        loginStep.login(username, password);
        boardsStep.createNewBoard(boardName);
        boardStep.checkBoardTitle(boardName);
    }

    @Test
    void deleteBoard() {
        final var boardName = FAKER.funnyName().name();
        final var username = ConfigProvider.userCredentialsConfig().getSimpleTrelloUsername();
        final var password = ConfigProvider.userCredentialsConfig().getSimpleTrelloPassword();

        boardsApiClient.createBoard(boardName);

        commonStep.openSite();
        loginStep.login(username, password);
        boardsStep.openBoard(boardName);
        boardStep.deleteBoard();
        boardsStep.assertThatBoardShouldBeDeleted(boardName);
    }
}
