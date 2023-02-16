package ru.levelp.at.lesson0507.selenium.basic.locators.xpath;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.levelp.at.utils.SleepUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class XpathSelectorLocatorsTest {

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
        // WebElement menu = driver.findElement(By.cssSelector("#mailbox")); XPATH
        WebElement menu = driver.findElement(By.xpath("//*[@id='mailbox']"));
        System.out.println(menu.getText());
    }

    @Test
    void classNameLocator() {
        // WebElement menu = driver.findElement(By.className("mailbox")); DOM
        // WebElement menu = driver.findElement(By.className("[class='mailbox']")); CSS
        // WebElement menu = driver.findElement(By.cssSelector(".mailbox")); CSS
        // WebElement menu = driver.findElement(By.xpath("//*[@class='mailbox cfe-kcal__l7uccm']"));
        WebElement menu = driver.findElement(By.xpath("//*[contains(@class, 'mailbox')]"));
        System.out.println(menu.getText());
    }

    @Test
    void nameLocator() {
        // WebElement loginButton = driver.findElement(By.className("resplash-btn")); DOM
        // WebElement loginButton = driver.findElement(By.cssSelector(".resplash-btn")); CSS
        WebElement loginButton = driver.findElement(By.xpath("//*[contains(@class, 'resplash-btn')]"));
        loginButton.click();
        SleepUtils.sleep(1500);

        // WebElement frameElement = driver.findElement(By.className("ag-popup__frame__layout__iframe")); DOM
        // WebElement frameElement = driver.findElement(By.cssSelector(".ag-popup__frame__layout__iframe")); CSS
        WebElement frameElement = driver
            .findElement(By.xpath("//*[contains(@class, 'ag-popup__frame__layout__iframe')]"));
        WebDriver frameDriver = driver.switchTo().frame(frameElement);

        // WebElement usernameTextField = frameDriver.findElement(By.name("username")); DOM
        // WebElement usernameTextField = frameDriver.findElement(By.cssSelector("[name='username']")); CSS
        WebElement usernameTextField = frameDriver.findElement(By.xpath("//*[@name='username']"));
        usernameTextField.sendKeys("123456");
        SleepUtils.sleep(1000);
    }

    @Test
    void linkTextLocator() {
        // DOM
        // WebElement classmatesLink = driver.findElement(By.linkText("Одноклассники"));
        // Аналога в CSS Selector нет
        WebElement classmatesLink = driver.findElement(By.xpath("//*[text()='Одноклассники']"));
        classmatesLink.click();
        SleepUtils.sleep(1500);
    }

    @Test
    void partialLinkTextLocator() {
        // DOM
        // WebElement vkLink = driver.findElement(By.partialLinkText("ВКонт"));
        // Аналога в CSS Selector нет

        WebElement vkLink = driver.findElement(By.xpath("//*[contains(text(), 'ВКонт')]"));
        vkLink.click();
        SleepUtils.sleep(1500);
    }

    @Test
    void tagNameLocator() {
        // List<WebElement> links = driver.findElements(By.tagName("a")); DOM
        // List<WebElement> links = driver.findElements(By.cssSelector("a")); CSS
        List<WebElement> links = driver.findElements(By.xpath("//a"));
        System.out.println(links.size());
    }

    @Test
    void combinedSearch1() {
        // WebElement loginButton = driver.findElement(By.cssSelector("button.resplash-btn")); CSS
        WebElement loginButton = driver
            .findElement(By.xpath("//button[contains(@class, 'resplash-btn')]"));
        loginButton.click();
        SleepUtils.sleep(1500);
    }

    @Test
    void combinedSearch2() {
        WebElement createMailboxLink =
            // driver.findElement(By.cssSelector("[class='resplash-btn'][data-testid='mailbox-create-link']"));
            // driver.findElement(By.cssSelector(".resplash-btn[data-testid='mailbox-create-link']")); CSS
            driver.findElement(By
                .xpath("//*[contains(@class, 'resplash-btn') and @data-testid='mailbox-create-link']"));
        createMailboxLink.click();
        SleepUtils.sleep(1500);
    }

    @Test
    void anotherAttributeSearch2() {
        // CSS
        // WebElement createMailboxLink = driver.findElement(By.cssSelector("[data-testid='mailbox-create-link']"));
        WebElement createMailboxLink = driver
            .findElement(By.xpath("//*[@data-testid='mailbox-create-link']"));
        createMailboxLink.click();
        SleepUtils.sleep(1500);
    }

    @Test
    void fromParentSearch() {
        // WebElement loginButton = driver.findElement(By.cssSelector("#mailbox button.resplash-btn")); CSS
        WebElement loginButton = driver
            .findElement(By.xpath("//*[@id='mailbox']//button[contains(@class, 'resplash-btn')]"));
        loginButton.click();
        SleepUtils.sleep(1500);
    }

    @Test
    void fromParentWithAllChildsSearch() {
        // List<WebElement> links = driver.findElements(By.cssSelector("#ph-whiteline > div > div > a")); CSS
        List<WebElement> links = driver
            .findElements(By.xpath("//*[@id='ph-whiteline']/div/div/a"));
        System.out.println(links.size());
    }

    @Test
    void getAttributeValueSearch() {
        // List<WebElement> links = driver.findElements(By.cssSelector("#ph-whiteline > div > div > a")); CSS
        List<WebElement> links = driver
            .findElements(By.xpath("//*[@id='ph-whiteline']/div/div/a"));
        links.forEach(link -> System.out.println(link.getText() + " || " + link.getAttribute("href")));
    }

    // Индексы использовать плохо
    @Test
    void indexes() {
        WebElement link = driver.findElement(By.xpath("//*[@id='ph-whiteline']/div/div/a[1]"));
        System.out.println(link.getText());
    }

    @Test
    void checkFirstElementList() {
        List<WebElement> links = driver.findElements(By.xpath("//*[@id='ph-whiteline']/div/div/a"));
        Assertions.assertThat(links.get(0).getText()).isEqualTo("Mail.ru");
    }

    @Test
    void checkFirstElementFindElement() {
        WebElement link = driver.findElement(By.xpath("//*[@id='ph-whiteline']/div/div/a"));
        Assertions.assertThat(link.getText()).isEqualTo("Mail.ru");
    }

    @Test
    void checkFirstElementFindAssertions() {
        List<WebElement> links = driver.findElements(By.xpath("//*[@id='ph-whiteline']/div/div/a"));
        Assertions.assertThat(links).first()
                  .extracting(WebElement::getText)
                  .isEqualTo("Mail.ru");
    }

    @Test
    void checkFirstElementFindAssertionsThroughString() {
        List<WebElement> links = driver.findElements(By.xpath("//*[@id='ph-whiteline']/div/div/a"));
        List<String> linksText = links.stream()
                                    .map(WebElement::getText)
                                    .collect(Collectors.toList());
        Assertions.assertThat(linksText).startsWith("Mail.ru");
    }

    @Test
    void checkFirstElementFindAssertionsThroughStringWithoutStream() {
        List<WebElement> links = driver.findElements(By.xpath("//*[@id='ph-whiteline']/div/div/a"));
        List<String> linksText = new ArrayList<>();
        for (WebElement link : links) {
            linksText.add(link.getText());
        }
        Assertions.assertThat(linksText).startsWith("Mail.ru");
    }

    @Test
    void parentSearchFromChild() {
        WebElement menu = driver
            .findElement(By.xpath("//button[contains(@class, 'resplash-btn')]/.."));
        System.out.println(menu.getAttribute("data-testid"));
        System.out.println(menu.getText());
        SleepUtils.sleep(1500);
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
