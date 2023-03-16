package ru.levelp.at.lesson13.bdd.step.def;

import io.cucumber.java.en.When;
import ru.levelp.at.lesson13.bdd.dns.DnsSubcategoryPage;
import ru.levelp.at.lesson13.bdd.service.webdriver.WebDriverContainer;

public class DnsSubcategoryPageStep {

    @When("I select {string} subcategory in Menu on the Category page")
    public void selectSubcategoryInMenuOnTheCategoryPage(String subcategory) {
        new DnsSubcategoryPage(WebDriverContainer.getDriver()).selectSubcategory(subcategory);
    }

    @When("I select {string} subcategory in Menu on the Subcategory page")
    public void selectSubcategoryInMenuOnTheSubcategoryPage(String subcategory) {
        new DnsSubcategoryPage(WebDriverContainer.getDriver()).selectSubcategory(subcategory);
    }
}
