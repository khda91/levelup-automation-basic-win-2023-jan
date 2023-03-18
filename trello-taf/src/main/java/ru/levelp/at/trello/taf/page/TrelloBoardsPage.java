package ru.levelp.at.trello.taf.page;

import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.levelp.at.trello.taf.exceptions.BoardNotFoundException;
import ru.levelp.at.trello.taf.page.component.TrelloBoardCardComponent;

public class TrelloBoardsPage extends BasePage {

    @FindBy(xpath = "//*[@data-testid='header-create-menu-button']")
    private WebElement createButton;

    @FindBy(xpath = "//*[@data-testid='create-board-title-input']")
    private WebElement createBoardTitleTextField;

    @FindBy(xpath = "//*[@data-testid='create-board-submit-button']")
    private WebElement createBoardButton;

    @FindBy(xpath = "//ul[@class='boards-page-board-section-list']/li[@class='boards-page-board-section-list-item']")
    private List<WebElement> boards;

    public TrelloBoardsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {
        throw new UnsupportedOperationException("Method does not supported");
    }

    public void openBoard(final String boardName) {
        wait.until(ExpectedConditions.visibilityOfAllElements(boards));
        boards.stream()
              .map(board -> new TrelloBoardCardComponent(driver, board))
              .filter(board -> board.getTitle().equals(boardName))
              .findFirst()
              .orElseThrow(() -> new BoardNotFoundException(boardName))
              .open();
    }

    public void clickCreateButton() {
        wait.until(ExpectedConditions.elementToBeClickable(createButton)).click();
    }

    public void sendKeysToBoardTitleTextField(final String boardName) {
        wait.until(ExpectedConditions.visibilityOf(createBoardTitleTextField)).sendKeys(boardName);
    }

    public void clickCreateBoardButton() {
        wait.until(ExpectedConditions.elementToBeClickable(createBoardButton)).click();
    }

    public List<TrelloBoardCardComponent> getBoards() {
        wait.until(ExpectedConditions.visibilityOfAllElements(boards));
        return boards.stream()
                     .map(board -> new TrelloBoardCardComponent(driver, board))
                     .collect(Collectors.toList());
    }

    public void selectMenu(final MenuItem item) {
        var menuItems = wait.until(ExpectedConditions
            .numberOfElementsToBe(By
                .xpath("//section[@data-testid='header-create-menu-popover']//li/button"), 3));

        for (WebElement menuItem : menuItems) {
            wait.until(ExpectedConditions.elementToBeClickable(menuItem));
            if (menuItem.getText().contains(item.getItemName())) {
                menuItem.click();
                break;
            }
        }
    }

    public enum MenuItem {
        CREATE_BOARD("Create board"),
        START_WITH_A_TEMPLATE("Start with a template"),
        CREATE_WORKSPACE("Create Workspace");

        private final String itemName;

        MenuItem(String itemName) {
            this.itemName = itemName;
        }

        public String getItemName() {
            return itemName;
        }
    }
}
