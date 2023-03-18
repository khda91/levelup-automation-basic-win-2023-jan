package ru.levelp.at.trello.taf.page.component;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TrelloBoardCardComponent extends BaseComponent {

    private static final By TITLE_XPATH = By.xpath(".//div[@class='board-tile-details-name']/div");

    public TrelloBoardCardComponent(WebDriver driver, WebElement root) {
        super(driver, root);
    }

    public String getTitle() {
        wait.until(ExpectedConditions.visibilityOf(root));
        return wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(root, TITLE_XPATH)).getText();
    }

    public void open() {
        wait.until(ExpectedConditions.elementToBeClickable(root)).click();
    }
}
