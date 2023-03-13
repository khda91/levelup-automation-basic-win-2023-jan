package ru.levelp.at.lesson11.jenkins.dns;

import io.qameta.allure.Step;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DnsSubcategoryPage extends DnsBasePage {

    @FindBy(xpath = "//a[contains(@class, 'subcategory__item')]")
    private List<WebElement> subcategories;

    public DnsSubcategoryPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {

    }

    @Step("Открываем подкатегорию {subcategoryName}")
    public void selectSubcategory(final String subcategoryName) {
        for (WebElement subcategory : subcategories) {
            wait.until(ExpectedConditions.elementToBeClickable(subcategory));
            if (subcategoryName.contains(subcategory.getText())) {
                subcategory.click();
                break;
            }
        }
    }
}
