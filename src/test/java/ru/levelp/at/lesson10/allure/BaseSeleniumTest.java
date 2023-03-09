package ru.levelp.at.lesson10.allure;

import com.github.javafaker.Faker;
import java.time.Duration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.levelp.at.lesson10.allure.listener.AllureAttachmentCallback;
import ru.levelp.at.lesson10.allure.listener.AllureAttachmentReport;

@ExtendWith({AllureAttachmentReport.class, AllureAttachmentCallback.class})
public abstract class BaseSeleniumTest {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Faker faker;

    @BeforeEach
    public void setUp() {
        faker = new Faker();
        driver = new EdgeDriver();
        wait = new WebDriverWait(driver, Duration.ofMillis(10000));
        TestContext.getInstance().addObject("driver", driver);
    }

    @AfterEach
    public void tearDown() {
        System.out.println("tear down");
        driver.quit();
        TestContext.clear();
    }
}
