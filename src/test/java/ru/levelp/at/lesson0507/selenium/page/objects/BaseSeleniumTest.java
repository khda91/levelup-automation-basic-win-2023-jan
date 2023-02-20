package ru.levelp.at.lesson0507.selenium.page.objects;

import com.github.javafaker.Faker;
import java.time.Duration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BaseSeleniumTest {

    protected static final String USER_BUG_RED_URL = "http://users.bugred.ru/user/login/index.html";

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Faker faker;

    @BeforeEach
    public void setUp() {
        faker = new Faker();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofMillis(10000));
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
