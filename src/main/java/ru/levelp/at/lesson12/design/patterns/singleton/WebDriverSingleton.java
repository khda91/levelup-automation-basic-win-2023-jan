package ru.levelp.at.lesson12.design.patterns.singleton;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public final class WebDriverSingleton {

    private static WebDriver driver;

    private WebDriverSingleton() {
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            driver = new EdgeDriver();
        }
        return driver;
    }

    public static void closeDriver() {
        driver.quit();
        driver = null;
    }
}
