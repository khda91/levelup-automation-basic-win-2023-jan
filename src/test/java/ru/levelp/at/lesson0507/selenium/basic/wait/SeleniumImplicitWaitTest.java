package ru.levelp.at.lesson0507.selenium.basic.wait;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.Duration;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class SeleniumImplicitWaitTest {

    private static final String URL = "https://google.com";

    private WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.navigate().to(URL);
    }

    @Test
    void searchTest() {
        long startTime = System.currentTimeMillis();
        try {
            driver.findElement(By.xpath("//input[@name='q']")).sendKeys("машина");
            driver.findElement(By.xpath("//input[@name='btnK']")).click();

            List<WebElement> searchList = driver.findElements(By
                .xpath("//div[@id='search']//div[@id='rso']//a[@data-ved]"));

            assertThat(searchList).hasSizeGreaterThan(10);
        } finally {
            long endTime = System.currentTimeMillis();
            System.out.println("SeleniumImplicitWaitTest Execution time: " + (endTime - startTime) + " ms");
        }
    }

    @Test
    void searchNonExistElementTest() {
        long startTime = System.currentTimeMillis();
        try {
            driver.findElement(By.xpath("//input[@name='q']")).sendKeys("машина");
            driver.findElement(By.xpath("//input[@name='btnK']")).click();

            List<WebElement> searchList = driver.findElements(By
                .xpath("//div[@id='search']//div[@id='rso1']//a[@data-ved]"));

            assertThat(searchList).hasSizeGreaterThan(10);
        } finally {
            long endTime = System.currentTimeMillis();
            System.out.println("SeleniumImplicitWaitTest searchNonExistElementTest Execution time: "
                + (endTime - startTime) + " ms");
        }
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
