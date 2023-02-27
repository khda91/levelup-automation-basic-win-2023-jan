package ru.levelp.at.lesson0507.selenium.page.objects.page.component;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.levelp.at.lesson0507.selenium.page.objects.BaseSeleniumTest;
import ru.levelp.at.lesson0507.selenium.page.objects.page.component.elements.CatalogProductCardElement;
import ru.levelp.at.utils.SleepUtils;

class DnsTest extends BaseSeleniumTest {

    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
    }

    @Test
    void compareList() {
        var indexPage = new DnsIndexPage(driver);
        indexPage.open();
        indexPage.selectCategory("Смартфоны и фототехника");

        var subcategoryPage = new DnsSubcategoryPage(driver);
        subcategoryPage.selectSubcategory("Смартфоны и гаджеты");

        subcategoryPage = new DnsSubcategoryPage(driver);
        subcategoryPage.selectSubcategory("Смартфоны");

        var productListPage = new DnsProductListPage(driver);
        List<CatalogProductCardElement> productCards = productListPage.getProductCards();

        var expectedTitles = new ArrayList<String>();

        expectedTitles.add(productCards.get(0).getTitle());
        productCards.get(0).addToCompareList();
        SleepUtils.sleep(5000);

        expectedTitles.add(productCards.get(1).getTitle());
        productCards.get(1).addToCompareList();
        SleepUtils.sleep(5000);

        expectedTitles.add(productCards.get(2).getTitle());
        productCards.get(2).addToCompareList();
        SleepUtils.sleep(5000);

        productListPage.clickCompareButton();

        var comparePage = new DnsCompareProductPage(driver);
        List<String> actualTitles = comparePage.getProductTitles();

        SleepUtils.sleep(7000);
        assertThat(actualTitles).containsExactlyInAnyOrderElementsOf(expectedTitles);
    }
}
