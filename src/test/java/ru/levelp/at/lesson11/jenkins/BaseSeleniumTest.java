package ru.levelp.at.lesson11.jenkins;

import com.github.javafaker.Faker;
import java.time.Duration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.levelp.at.lesson11.jenkins.listener.AllureAttachmentCallback;
import ru.levelp.at.lesson11.jenkins.listener.AllureAttachmentReport;

@ExtendWith({AllureAttachmentReport.class, AllureAttachmentCallback.class})
public abstract class BaseSeleniumTest {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Faker faker;

    @BeforeEach
    public void setUp() {
        faker = new Faker();

        final var browserName = System.getProperty("browser.name", "edge");
        final var headless = Boolean.parseBoolean(System.getProperty("browser.headless", "false"));

        System.out.println("browserName -> " + browserName);
        System.out.println("headless -> " + headless);

        if ("chrome".equalsIgnoreCase(browserName)) {
            var options = new ChromeOptions();
            if (headless) {
                options.addArguments("--headless=new");
            }
            System.out.println(options);
            driver = new ChromeDriver(options);
        } else if ("edge".equalsIgnoreCase(browserName)) {
            var options = new EdgeOptions();
            if (headless) {
                options.addArguments("--headless=new");
            }
            System.out.println(options);
            driver = new EdgeDriver(options);
        }
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
