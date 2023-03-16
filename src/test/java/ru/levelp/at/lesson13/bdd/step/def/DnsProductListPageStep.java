package ru.levelp.at.lesson13.bdd.step.def;

import io.cucumber.java.ParameterType;
import io.cucumber.java.en.When;
import ru.levelp.at.lesson13.bdd.context.TestContext;
import ru.levelp.at.lesson13.bdd.dns.DnsProductListPage;
import ru.levelp.at.lesson13.bdd.dns.elements.CatalogProductCardElement;
import ru.levelp.at.lesson13.bdd.service.webdriver.WebDriverContainer;
import ru.levelp.at.utils.SleepUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DnsProductListPageStep {

    @ParameterType("(.*)")
    public List<Integer> productNumbers(String str) {
        return Arrays.stream(str.split(","))
                     .map(Integer::parseInt)
                     .collect(Collectors.toList());
    }

    @When("I add {productNumbers} items to compare list on Products List page")
    public void addItemsToCompareListOnProductsListPage(List<Integer> productNumbers) {
        List<CatalogProductCardElement> productCards = new DnsProductListPage(WebDriverContainer.getDriver())
            .getProductCards();
        List<String> addedTitles = new ArrayList<>();
        for (Integer productNumber : productNumbers) {
            String title = productCards.get(productNumber - 1).getTitle();
            productCards.get(productNumber - 1).addToCompareList();
            addedTitles.add(title);
            SleepUtils.sleep(3000);
        }

        TestContext.getInstance().addParameter("comparedProductTitles", addedTitles);
    }

    @When("I click 'Сравнение' button in the page header")
    public void clickCompareButtonInTheHeader() {
        new DnsProductListPage(WebDriverContainer.getDriver()).clickCompareButton();
    }
}
