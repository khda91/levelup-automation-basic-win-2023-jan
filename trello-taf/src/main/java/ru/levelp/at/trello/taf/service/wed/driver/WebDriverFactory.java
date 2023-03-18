package ru.levelp.at.trello.taf.service.wed.driver;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import ru.levelp.at.trello.taf.exceptions.UnsupportedBrowserException;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class WebDriverFactory {

    public static WebDriver createDriver(BrowserName browserName) {
        WebDriver driver;

        switch (browserName) {
            case CHROME:
                return createChromeDriver();
            case EDGE:
                return createEdgeDriver();
            default:
                throw new UnsupportedBrowserException(browserName);
        }
    }

    private static WebDriver createChromeDriver() {
        var options = new ChromeOptions()
            .addArguments("--remote-allow-origins=*");
        return new ChromeDriver(options);
    }

    private static WebDriver createEdgeDriver() {
        return new EdgeDriver();
    }
}
