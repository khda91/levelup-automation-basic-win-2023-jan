package ru.levelp.at.lesson10.allure.dns;

import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.levelp.at.lesson10.allure.BaseSeleniumTest;
import ru.levelp.at.lesson10.allure.dns.elements.CatalogProductCardElement;
import ru.levelp.at.utils.SleepUtils;

@DisplayName("DNS магазин тесты")
@Owner("d.khodakovskiy")
@Epic("Epic 1")
@Story("Story 1")
class DnsTest extends BaseSeleniumTest {

    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
    }

    @Test
    @DisplayName("Добавить товары к сравнению")
    @Owner("a.pupkin")
    @Severity(SeverityLevel.BLOCKER)
    @TmsLink("III-12345")
    @Issue("III-98765")
    @Feature("Feature 1")
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

        step("Добавляем товыры в список для сравнения", () -> {
            expectedTitles.add(productCards.get(0).getTitle());
            productCards.get(0).addToCompareList();
            SleepUtils.sleep(5000);

            expectedTitles.add(productCards.get(1).getTitle());
            productCards.get(1).addToCompareList();
            SleepUtils.sleep(5000);

            expectedTitles.add(productCards.get(2).getTitle());
            productCards.get(2).addToCompareList();
        });

        SleepUtils.sleep(5000);

        productListPage.clickCompareButton();

        var comparePage = new DnsCompareProductPage(driver);
        List<String> actualTitles = comparePage.getProductTitles();

        SleepUtils.sleep(7000);
        step("Сравниваем добавленные товары в список для сравнения с отображаемыми", () -> {
            assertThat(actualTitles).containsExactlyInAnyOrderElementsOf(expectedTitles);
        });
    }
}
