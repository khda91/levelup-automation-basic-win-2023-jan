package ru.levelp.at.trello.taf.service.wed.driver;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.openqa.selenium.WebDriver;
import ru.levelp.at.trello.taf.configuration.provider.ConfigProvider;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class WebDriverProvider {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            var name = BrowserName.getBrowserName(ConfigProvider.browserConfig().getBrowserName());
            driver = WebDriverFactory.createDriver(name);
        }
        return driver;
    }

    public static void closeDriver() {
        driver.quit();
        driver = null;
    }
}
