package ru.levelp.at.lesson0507.selenium.basic.locators.css;

import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.levelp.at.utils.SleepUtils;

public class CssSelectorLocatorsTest {

    private static final String MAIL_RU = "https://mail.ru";

    private WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.navigate().to(MAIL_RU);
    }

    @Test
    void idLocator() {
        // WebElement menu = driver.findElement(By.id("mailbox")); DOM
        // WebElement menu = driver.findElement(By.cssSelector("[id='mailbox']")); CSS
        WebElement menu = driver.findElement(By.cssSelector("#mailbox"));
        System.out.println(menu.getText());
    }

    @Test
    void classNameLocator() {
        // WebElement menu = driver.findElement(By.className("mailbox")); DOM
        // WebElement menu = driver.findElement(By.className("[class='mailbox']")); CSS
        WebElement menu = driver.findElement(By.cssSelector(".mailbox"));
        System.out.println(menu.getText());
    }

    @Test
    void nameLocator() {
        // WebElement loginButton = driver.findElement(By.className("resplash-btn")); DOM
        WebElement loginButton = driver.findElement(By.cssSelector(".resplash-btn"));
        loginButton.click();
        SleepUtils.sleep(1500);

        // WebElement frameElement = driver.findElement(By.className("ag-popup__frame__layout__iframe")); DOM
        WebElement frameElement = driver.findElement(By.cssSelector(".ag-popup__frame__layout__iframe"));
        WebDriver frameDriver = driver.switchTo().frame(frameElement);

        // WebElement usernameTextField = frameDriver.findElement(By.name("username")); DOM
        WebElement usernameTextField = frameDriver.findElement(By.cssSelector("[name='username']"));
        usernameTextField.sendKeys("123456");
        SleepUtils.sleep(1000);
    }

    @Test
    void linkTextLocator() {
        // DOM
        // WebElement classmatesLink = driver.findElement(By.linkText("Одноклассники"));
        // classmatesLink.click();
        // SleepUtils.sleep(1500);

        // Аналога в CSS Selector нет
    }

    @Test
    void partialLinkTextLocator() {
        // DOM
        // WebElement vkLink = driver.findElement(By.partialLinkText("ВКонт"));
        // vkLink.click();
        // SleepUtils.sleep(1500);

        // Аналога в CSS Selector нет
    }

    @Test
    void tagNameLocator() {
        // List<WebElement> links = driver.findElements(By.tagName("a")); DOM
        List<WebElement> links = driver.findElements(By.cssSelector("a"));
        System.out.println(links.size());
    }

    @Test
    void combinedSearch1() {
        WebElement loginButton = driver.findElement(By.cssSelector("button.resplash-btn"));
        loginButton.click();
        SleepUtils.sleep(1500);
    }

    @Test
    void combinedSearch2() {
        WebElement createMailboxLink =
            // driver.findElement(By.cssSelector("[class='resplash-btn'][data-testid='mailbox-create-link']"));
            driver.findElement(By.cssSelector(".resplash-btn[data-testid='mailbox-create-link']"));
        createMailboxLink.click();
        SleepUtils.sleep(1500);
    }

    @Test
    void anotherAttributeSearch2() {
        WebElement createMailboxLink = driver.findElement(By.cssSelector("[data-testid='mailbox-create-link']"));
        createMailboxLink.click();
        SleepUtils.sleep(1500);
    }

    @Test
    void fromParentSearch() {
        WebElement loginButton = driver.findElement(By.cssSelector("#mailbox button.resplash-btn"));
        loginButton.click();
        SleepUtils.sleep(1500);
    }

    @Test
    void fromParentWithAllChildsSearch() {
        List<WebElement> links = driver.findElements(By.cssSelector("#ph-whiteline > div > div > a"));
        System.out.println(links.size());
    }

    @Test
    void getAttributeValueSearch() {
        List<WebElement> links = driver.findElements(By.cssSelector("#ph-whiteline > div > div > a"));
        links.forEach(link -> System.out.println(link.getText() + " || " + link.getAttribute("href")));
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
