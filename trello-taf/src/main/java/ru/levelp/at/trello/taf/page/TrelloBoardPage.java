package ru.levelp.at.trello.taf.page;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TrelloBoardPage extends BasePage {

    @FindBy(xpath = "//h1[contains(@class, 'board-header-btn-text')]")
    private WebElement title;

    @FindBy(xpath = "//button[@aria-label='Show menu']")
    private WebElement showMenuButton;

    @FindBy(xpath = "//a[contains(@class, 'js-open-more')]")
    private WebElement moreButton;

    @FindBy(xpath = "//a[contains(@class, 'js-close-board')]")
    private WebElement closeBoardButton;

    @FindBy(xpath = "//input[@value='Close']")
    private WebElement confirmationCloseBoardButton;

    @FindBy(xpath = "//*[@data-testid='close-board-delete-board-button']")
    private WebElement closeBoardDeleteBoardButton;

    @FindBy(xpath = "//*[@data-testid='close-board-delete-board-confirm-button']")
    private WebElement closeBoardDeleteConfirmBoardButton;

    public TrelloBoardPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {
        throw new UnsupportedOperationException("method does not supported");
    }

    public String getTitle() {
        try {
            return wait.until(ExpectedConditions.visibilityOf(title)).getText();
        } catch (StaleElementReferenceException e) {
            return wait.until(ExpectedConditions.visibilityOf(title)).getText();
        }
    }

    public void clickShowMenuButton() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(showMenuButton)).click();
        } catch (StaleElementReferenceException e) {
            wait.until(ExpectedConditions.elementToBeClickable(showMenuButton)).click();
        }
    }

    public void clickMoreButton() {
        wait.until(ExpectedConditions.elementToBeClickable(moreButton)).click();
    }

    public void clickCloseBoardButton() {
        wait.until(ExpectedConditions.elementToBeClickable(closeBoardButton)).click();
    }

    public void clickConfirmationCloseBoardButton() {
        wait.until(ExpectedConditions.elementToBeClickable(confirmationCloseBoardButton)).click();
    }

    public void clickCloseBoardDeleteBoardButton() {
        wait.until(ExpectedConditions.elementToBeClickable(closeBoardDeleteBoardButton)).click();
    }

    public void clickCloseBoardDeleteConfirmBoardButton() {
        wait.until(ExpectedConditions.elementToBeClickable(closeBoardDeleteConfirmBoardButton)).click();
    }
}
