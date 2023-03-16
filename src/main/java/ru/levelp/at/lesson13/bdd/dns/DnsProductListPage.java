package ru.levelp.at.lesson13.bdd.dns;

import io.qameta.allure.Step;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.levelp.at.lesson13.bdd.dns.elements.CatalogProductCardElement;

public class DnsProductListPage extends DnsBasePage {

    @FindBy(xpath = "//*[@class='compare-link-counter']")
    private WebElement compareButtonClick;

    public DnsProductListPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {

    }

    public List<CatalogProductCardElement> getProductCards() {
        List<WebElement> productCards = wait.until(ExpectedConditions
            .numberOfElementsToBeMoreThan(By.xpath("//*[@data-id='product']"), 3));
        return productCards.stream()
                           .map(card -> new CatalogProductCardElement(driver, card))
                           .collect(Collectors.toList());
    }

    @Step("Нажимаем на кнопку 'Сравнение'")
    public void clickCompareButton() {
        wait.until(ExpectedConditions.elementToBeClickable(compareButtonClick)).click();
    }
}
