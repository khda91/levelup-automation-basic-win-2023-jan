package ru.levelp.at.lesson0507.selenium.basic.wait;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.levelp.at.utils.SleepUtils;

import java.time.Duration;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SeleniumThreadWaitTest {

    private static final String URL = "https://google.com";

    private WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.navigate().to(URL);
        SleepUtils.sleep(1500);
    }

    @Test
    void searchTest() {
        long startTime = System.currentTimeMillis();
        try {
            driver.findElement(By.xpath("//input[@name='q']")).sendKeys("машина");
            SleepUtils.sleep(2000);
            driver.findElement(By.xpath("//input[@name='btnK']")).click();

            SleepUtils.sleep(10000);
            List<WebElement> searchList = driver.findElements(By
                .xpath("//div[@id='search']//div[@id='rso']//a[@data-ved]"));

            assertThat(searchList).hasSizeGreaterThan(10);
        } finally {
            long endTime = System.currentTimeMillis();
            System.out.println("SeleniumThreadWaitTest Execution time: " + (endTime - startTime) + " ms");
        }
    }

    @Test
    void searchNonExistElementTest() {
        long startTime = System.currentTimeMillis();
        try {
            driver.findElement(By.xpath("//input[@name='q']")).sendKeys("машина");
            SleepUtils.sleep(2000);
            driver.findElement(By.xpath("//input[@name='btnK']")).click();

            SleepUtils.sleep(10000);
            List<WebElement> searchList = driver.findElements(By
                .xpath("//div[@id='search']//div[@id='rso1']//a[@data-ved]"));

            assertThat(searchList).hasSizeGreaterThan(10);
        } finally {
            long endTime = System.currentTimeMillis();
            System.out.println("SeleniumThreadWaitTest searchNonExistElementTest Execution time: "
                + (endTime - startTime) + " ms");
        }
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
