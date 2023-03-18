package ru.levelp.at.trello.taf.page.component;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.levelp.at.trello.taf.configuration.provider.ConfigProvider;

public abstract class BaseComponent {

    private static final Long TIMEOUT;

    static {
        TIMEOUT = ConfigProvider.browserConfig().getBrowserWait();
    }

    protected final WebDriver driver;
    protected final WebDriverWait wait;

    protected final WebElement root;

    protected BaseComponent(WebDriver driver, WebElement root) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofMillis(TIMEOUT));
        this.root = root;
    }
}
