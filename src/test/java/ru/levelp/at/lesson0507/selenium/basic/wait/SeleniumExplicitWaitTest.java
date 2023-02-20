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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

class SeleniumExplicitWaitTest {

    private static final String URL = "https://google.com";

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.navigate().to(URL);
    }

    @Test
    void searchTest() {
        long startTime = System.currentTimeMillis();
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='q']")))
                .sendKeys("машина");
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='btnK']")))
                .click();

            List<WebElement> searchList = wait.until(
                ExpectedConditions.numberOfElementsToBeMoreThan(By
                    .xpath("//div[@id='search']//div[@id='rso']//a[@data-ved]"), 3));

            assertThat(searchList).hasSizeGreaterThan(10);
        } finally {
            long endTime = System.currentTimeMillis();
            System.out.println("SeleniumExplicitWaitTest Execution time: " + (endTime - startTime) + " ms");
        }
    }

    @Test
    void searchNonExistElementTest() {
        long startTime = System.currentTimeMillis();
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='q']")))
                .sendKeys("машина");
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='btnK']")))
                .click();

            List<WebElement> searchList = wait.until(
                ExpectedConditions.numberOfElementsToBeMoreThan(By
                    .xpath("//div[@id='search']//div[@id='rso1']//a[@data-ved]"), 3));

            assertThat(searchList).hasSizeGreaterThan(10);
        } finally {
            long endTime = System.currentTimeMillis();
            System.out.println("SeleniumExplicitWaitTest searchNonExistElementTest Execution time: "
                + (endTime - startTime) + " ms");
        }
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
