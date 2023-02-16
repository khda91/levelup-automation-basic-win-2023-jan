package ru.levelp.at.lesson0507.selenium.basic.sample;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.levelp.at.utils.SleepUtils;

public class SeleniumWindowHandleTest {

    private static final String GOOGLE_URL = "https://google.com";
    private static final String YANDEX_URL = "https://ya.ru";
    private static final String MAIL_RU = "https://mail.ru";
    private static final String DNS_URL = "https://www.dns-shop.ru";

    private WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        System.out.println("Окрыт браузер");
        System.out.println("window handles -> " + driver.getWindowHandles());
    }

    @Test
    void test() {
        SleepUtils.sleep(1500);
        driver.navigate().to(GOOGLE_URL);
        System.out.println("Окрыли Google");

        driver = driver.switchTo().newWindow(WindowType.TAB);
        driver.navigate().to(YANDEX_URL);
        SleepUtils.sleep(1500);
        System.out.println("Окрыли yandex");
        System.out.println("window handles -> " + driver.getWindowHandles());

        driver = driver.switchTo().newWindow(WindowType.TAB);
        driver.navigate().to(MAIL_RU);
        SleepUtils.sleep(1500);
        System.out.println("Окрыли mail.ru");
        System.out.println("window handles -> " + driver.getWindowHandles());

        var currentHandle = driver.getWindowHandle();
        var handles = driver.getWindowHandles();
        for (String handle : handles) {
            driver = driver.switchTo().window(handle);
            var title = driver.getTitle();
            if ("Google".equals(title)) {
                driver.close();
                driver.switchTo().window(currentHandle);
                break;
            }
        }
        SleepUtils.sleep(1500);
        System.out.println("Закрыли Google");
        System.out.println("window handles -> " + driver.getWindowHandles());

        driver = driver.switchTo().newWindow(WindowType.WINDOW);
        driver.navigate().to(DNS_URL);
        SleepUtils.sleep(1500);
        System.out.println("Окрыли DNS");
        System.out.println("window handles -> " + driver.getWindowHandles());
    }

    @AfterEach
    void tearDown() {
        driver.quit();
        SleepUtils.sleep(1000);
        System.out.println("Закрыты все окна и вкладки браузера");
    }
}
