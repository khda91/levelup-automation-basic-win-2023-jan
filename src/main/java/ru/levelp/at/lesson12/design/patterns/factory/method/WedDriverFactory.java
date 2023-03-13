package ru.levelp.at.lesson12.design.patterns.factory.method;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.levelp.at.lesson12.design.patterns.factory.method.exception.UnknownBrowserException;

public final class WedDriverFactory {

    private static final String CHROME = "chrome";
    private static final String EDGE = "edge";
    private static final String FIREFOX = "firefox";

    private WedDriverFactory() {

    }

    public static WebDriver createDriver(final String browserName) throws UnknownBrowserException {
        WebDriver driver;
        if (CHROME.equalsIgnoreCase(browserName)) {
            driver = createChromeDriver();
        } else if (EDGE.equalsIgnoreCase(browserName)) {
            driver = createEdgeDriver();
        } else if (FIREFOX.equalsIgnoreCase(browserName)) {
            driver = createFirefoxDriver();
        } else {
            throw new UnknownBrowserException(browserName);
        }

        return driver;
    }

    private static WebDriver createFirefoxDriver() {
        return new FirefoxDriver();
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
