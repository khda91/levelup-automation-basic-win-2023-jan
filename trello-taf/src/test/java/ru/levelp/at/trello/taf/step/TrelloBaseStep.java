package ru.levelp.at.trello.taf.step;

import org.openqa.selenium.WebDriver;
import ru.levelp.at.trello.taf.service.wed.driver.WebDriverProvider;

public abstract class TrelloBaseStep {

    protected final WebDriver driver;

    protected TrelloBaseStep() {
        this.driver = WebDriverProvider.getDriver();
    }
}
