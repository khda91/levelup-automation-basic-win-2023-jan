package ru.levelp.at.lesson13.bdd.step.def;

import io.cucumber.java.en.Then;
import ru.levelp.at.lesson13.bdd.context.TestContext;
import ru.levelp.at.lesson13.bdd.dns.DnsCompareProductPage;
import ru.levelp.at.lesson13.bdd.service.webdriver.WebDriverContainer;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class DnsCompareProductsPageStep {

    @Then("selected items should be displayed on the Compare Products page")
    public void selectedItemShouldBeDisplayedOnTheCompareProductsPage() {
        var actualTitles = new DnsCompareProductPage(WebDriverContainer.getDriver()).getProductTitles();
        var expectedTitles = (List<String>) TestContext.getInstance().getParameter("comparedProductTitles");

        assertThat(actualTitles).containsExactlyInAnyOrderElementsOf(expectedTitles);
    }
}
