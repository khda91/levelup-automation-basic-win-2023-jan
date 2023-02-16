package ru.levelp.at.lesson0507.selenium.basic.sample;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import ru.levelp.at.utils.SleepUtils;

import static org.assertj.core.api.Assertions.assertThat;

public class SeleniumIncognitoTest {

    private static final String URL = "https://google.com";

    private WebDriver driver;

    @BeforeEach
    void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito", "--headless");
        driver = new ChromeDriver(options);
    }

    @Test
    void openGoogleHomePage() {
        SleepUtils.sleep(1500);

        driver.navigate().to(URL);

        SleepUtils.sleep(3000);

        var title = driver.getTitle();

        assertThat(title).isEqualTo("Google");
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
