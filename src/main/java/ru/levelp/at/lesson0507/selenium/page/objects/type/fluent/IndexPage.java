package ru.levelp.at.lesson0507.selenium.page.objects.type.fluent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class IndexPage extends BasePage {

    @FindBy(xpath = "//li[@id='fat-menu']/a[@class='dropdown-toggle']")
    private WebElement userDropdown;

    public IndexPage(WebDriver driver) {
        super(driver);
    }

    public IndexPage open() {
        open("/");
        // return new IndexPage(driver);
        return this;
    }

    public String getUserDropdownText() {
        return wait.until(ExpectedConditions.visibilityOf(userDropdown)).getText();
    }
}
