package ru.levelp.at.lesson10.allure.dns;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class DnsBasePage {

    private static final String URL = "https://www.dns-shop.ru";

    protected final WebDriver driver;
    protected final WebDriverWait wait;

    protected DnsBasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    protected void open(String relativeUrl) {
        driver.navigate().to(URL + relativeUrl);
    }

    public abstract void open();
}
