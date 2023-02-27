package ru.levelp.at.lesson0507.selenium.page.objects.page.component;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class DnsIndexPage extends DnsBasePage {

    public DnsIndexPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {
        open("");
    }

    public void selectCategory(final String categoryName) {
        List<WebElement> categories = wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By
            .xpath("//*[@class='catalog-menu__root-item']"
                + "//a[contains(@class, 'catalog-menu__root-item-title')]"), 3));

        categories.stream()
                  .filter(category -> {
                      wait.until(ExpectedConditions.elementToBeClickable(category));
                      return categoryName.equals(category.getText());
                  })
                  .findFirst()
                  .orElseThrow(() -> new RuntimeException("Не удалось найти нужную категорию товара"))
                  .click();
    }
}
