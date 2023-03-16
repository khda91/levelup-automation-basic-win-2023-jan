package ru.levelp.at.lesson13.bdd.service.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public final class WebDriverContainer {

    private static WebDriver driver;

    private WebDriverContainer() {

    }

    public static WebDriver getDriver() {
        if (driver == null) {
            var options = new ChromeOptions()
                .addArguments("--remote-allow-origins=*");
            driver = new ChromeDriver(options);
        }

        return driver;
    }

    public static void closeDriver() {
        driver.quit();
        driver = null;
    }
}
