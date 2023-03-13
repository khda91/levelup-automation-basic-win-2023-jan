package ru.levelp.at.lesson12.design.patterns.factory.method;

import org.junit.jupiter.api.Test;
import ru.levelp.at.utils.SleepUtils;

public class WebDriverFactoryTest {

    @Test
    void chromeTest() {
        var driver = WedDriverFactory.createDriver("chrome");
        SleepUtils.sleep(3000);
        driver.quit();
    }

    @Test
    void edgeTest() {
        var driver = WedDriverFactory.createDriver("edge");
        SleepUtils.sleep(3000);
        driver.quit();
    }
}
