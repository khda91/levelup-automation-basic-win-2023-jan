package ru.levelp.at.lesson13.bdd.dns.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CatalogProductCardElement {

    private final WebDriver driver;
    private final WebDriverWait wait;
    private final WebElement root;

    public CatalogProductCardElement(WebDriver driver, WebElement root) {
        this.driver = driver;
        this.root = root;
        this.wait = new WebDriverWait(driver, Duration.ofMillis(10000));
    }

    public void addToCompareList() {
        var checkbox = root.findElement(By.xpath(".//label[@class='ui-checkbox']"));
        wait.until(ExpectedConditions.elementToBeClickable(checkbox)).click();
    }

    public String getTitle() {
        var title = root.findElement(By.xpath("//a[contains(@class, 'catalog-product__name')]/span"))
                        .getText();
        return title.substring(0, title.indexOf("[") - 1).trim();
    }
}
