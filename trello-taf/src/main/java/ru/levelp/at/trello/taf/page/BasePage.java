package ru.levelp.at.trello.taf.page;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.levelp.at.trello.taf.configuration.provider.ConfigProvider;

public abstract class BasePage {

    private static final String APP_URL;
    private static final Long TIMEOUT;

    static {
        APP_URL = ConfigProvider.webUiConfig().getTrelloApiUrl();
        TIMEOUT = ConfigProvider.browserConfig().getBrowserWait();
    }

    protected final WebDriver driver;
    protected final WebDriverWait wait;

    protected BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofMillis(TIMEOUT));
        PageFactory.initElements(driver, this);
    }

    public abstract void open();

    protected void open(final String relativeUrl) {
        driver.navigate().to(APP_URL + relativeUrl);
    }
}
