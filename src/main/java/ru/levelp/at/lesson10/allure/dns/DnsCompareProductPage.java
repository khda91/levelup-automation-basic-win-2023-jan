package ru.levelp.at.lesson10.allure.dns;

import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DnsCompareProductPage extends DnsBasePage {

    @FindBy(xpath = "//*[@class='products-slider__product-name']")
    private List<WebElement> productTitles;

    public DnsCompareProductPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {

    }

    public List<String> getProductTitles() {
        return productTitles.stream()
                            .map(WebElement::getText)
                            .collect(Collectors.toList());
    }
}
