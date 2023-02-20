package ru.levelp.at.lesson0507.selenium.basic.wait;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SeleniumImplicitVsExplicitWaitTest {

    private static final String URL = "https://google.com";

    private WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.navigate().to(URL);

        // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    void searchImplicitMoreExplicitTest() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        var wait = new WebDriverWait(driver, Duration.ofSeconds(6));

        driver.findElement(By.xpath("//input[@name='q']")).sendKeys("машина");
        driver.findElement(By.xpath("//input[@name='btnK']")).click();

        long startTime = System.currentTimeMillis();
        try {
            List<WebElement> searchList = wait.until(
                ExpectedConditions.numberOfElementsToBeMoreThan(By
                    .xpath("//div[@id='search']//div[@id='rso1']//a[@data-ved]"), 3));

            assertThat(searchList).hasSizeGreaterThan(10);
        } finally {
            long endTime = System.currentTimeMillis();
            System.out.println("Implicit more than Explicit: " + (endTime - startTime) + " ms");
        }
    }

    @Test
    void searchImplicitLessExplicitTest() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
        var wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.findElement(By.xpath("//input[@name='q']")).sendKeys("машина");
        driver.findElement(By.xpath("//input[@name='btnK']")).click();

        long startTime = System.currentTimeMillis();
        try {
            List<WebElement> searchList = wait.until(
                ExpectedConditions.numberOfElementsToBeMoreThan(By
                    .xpath("//div[@id='search']//div[@id='rso1']//a[@data-ved]"), 3));

            assertThat(searchList).hasSizeGreaterThan(10);
        } finally {
            long endTime = System.currentTimeMillis();
            System.out.println("Implicit less than Explicit: " + (endTime - startTime) + " ms");
        }
    }


    @Test
    void searchImplicitTogetherExplicitTest() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
        var wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.findElement(By.xpath("//input[@name='q']")).sendKeys("машина");
        driver.findElement(By.xpath("//input[@name='btnK']")).click();

        var implicitWaitTimeout = driver.manage().timeouts().getImplicitWaitTimeout();
        driver.manage().timeouts().implicitlyWait(Duration.ZERO);
        long startTime = System.currentTimeMillis();
        try {
            List<WebElement> searchList = wait.until(
                ExpectedConditions.numberOfElementsToBeMoreThan(By
                    .xpath("//div[@id='search']//div[@id='rso1']//a[@data-ved]"), 3));

            assertThat(searchList).hasSizeGreaterThan(10);
        } finally {
            long endTime = System.currentTimeMillis();
            System.out.println("Implicit together Explicit: " + (endTime - startTime) + " ms");
            driver.manage().timeouts().implicitlyWait(implicitWaitTimeout);
        }
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
