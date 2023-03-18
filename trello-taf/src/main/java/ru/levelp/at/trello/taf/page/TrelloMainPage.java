package ru.levelp.at.trello.taf.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TrelloMainPage extends BasePage {

    @FindBy(xpath = "//a[@href='/login']")
    private WebElement loginButton;

    public TrelloMainPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {
        open("/");
    }

    public void clickLoginButton() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
    }
}
