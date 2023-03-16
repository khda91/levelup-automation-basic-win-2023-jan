package ru.levelp.at.lesson12.design.patterns.factory.method;

import org.junit.jupiter.api.Test;
import ru.levelp.at.lesson12.design.patterns.factory.method.exception.UnknownBrowserException;
import ru.levelp.at.utils.SleepUtils;

class WebDriverSingletonFactoryTest {

    @Test
    void chrome() {
        System.setProperty("browser.name", "chrome");
        WebDriverSingleton.getDriver();
        SleepUtils.sleep(3000);
        WebDriverSingleton.closeDriver();
    }

    @Test
    void edge() {
        System.setProperty("browser.name", "edge");
        WebDriverSingleton.getDriver();
        SleepUtils.sleep(3000);
        WebDriverSingleton.closeDriver();
    }

    @Test
    void unknownBrowser() {
        System.setProperty("browser.name", "opera");
        WebDriverSingleton.getDriver();
        System.out.println("After unhandled exception!");
        SleepUtils.sleep(3000);
        WebDriverSingleton.closeDriver();
    }

    @Test
    void unknownBrowserHandleException() {
        System.setProperty("browser.name", "opera");

        try {
            WebDriverSingleton.getDriver();
        } catch (UnknownBrowserException e) {
            System.out.println("oooooooppsssssss!");
        }
        System.out.println("After catch!!!");
    }
}
