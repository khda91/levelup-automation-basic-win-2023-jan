package ru.levelp.at.lesson12.design.patterns.singleton;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.levelp.at.lesson12.design.patterns.singleton.listener.AllureAttachmentCallback;
import ru.levelp.at.lesson12.design.patterns.singleton.listener.AllureAttachmentReport;

import java.time.Duration;

@ExtendWith({AllureAttachmentReport.class, AllureAttachmentCallback.class})
public abstract class BaseSeleniumTest {

    protected WebDriverWait wait;
    protected Faker faker;

    @BeforeEach
    public void setUp() {
        faker = new Faker();
        var driver = WebDriverSingleton.getDriver();
        wait = new WebDriverWait(driver, Duration.ofMillis(10000));
    }

    @AfterEach
    public void tearDown() {
        System.out.println("tear down");
        WebDriverSingleton.closeDriver();
    }
}
