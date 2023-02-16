package ru.levelp.at.lesson0507.selenium.basic.locators.dom;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.levelp.at.utils.SleepUtils;
import java.util.List;

public class DomLocatorsTest {

    private static final String MAIL_RU = "https://mail.ru";

    private WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.navigate().to(MAIL_RU);
    }

    @Test
    void idLocator() {
        WebElement menu = driver.findElement(By.id("mailbox"));
        System.out.println(menu.getText());
    }

    @Test
    void classNameLocator() {
        WebElement menu = driver.findElement(By.className("mailbox"));
        System.out.println(menu.getText());
    }

    @Test
    void nameLocator() {
        WebElement loginButton = driver.findElement(By.className("resplash-btn"));
        loginButton.click();
        SleepUtils.sleep(1500);

        WebElement frameElement = driver.findElement(By.className("ag-popup__frame__layout__iframe"));
        WebDriver frameDriver = driver.switchTo().frame(frameElement);

        WebElement usernameTextField = frameDriver.findElement(By.name("username"));
        usernameTextField.sendKeys("123456");
        SleepUtils.sleep(1000);
    }

    @Test
    void linkTextLocator() {
        WebElement classmatesLink = driver.findElement(By.linkText("Одноклассники"));
        classmatesLink.click();
        SleepUtils.sleep(1500);
    }

    @Test
    void partialLinkTextLocator() {
        WebElement vkLink = driver.findElement(By.partialLinkText("ВКонт"));
        vkLink.click();
        SleepUtils.sleep(1500);
    }

    @Test
    void tagNameLocator() {
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println(links.size());
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
