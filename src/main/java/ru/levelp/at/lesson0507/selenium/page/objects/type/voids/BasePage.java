package ru.levelp.at.lesson0507.selenium.page.objects.type.voids;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {

    private static final String URL = "http://users.bugred.ru";

    protected final WebDriver driver;
    protected final WebDriverWait wait;

    protected BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    protected void open(String relativeUrl) {
        driver.navigate().to(URL + relativeUrl);
    }

    public abstract void open();

    protected void click(final WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    protected void sendKeys(final WebElement element, final String text) {
        wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(text);
    }
}
