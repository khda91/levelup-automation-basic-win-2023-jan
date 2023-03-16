package ru.levelp.at.lesson13.bdd.step.def;

import io.cucumber.java.en.Given;
import ru.levelp.at.lesson13.bdd.dns.DnsIndexPage;
import ru.levelp.at.lesson13.bdd.service.webdriver.WebDriverContainer;

public class DnsIndexPageStep {

    @Given("I open DNS shop Home page")
    public void openDnsHomePage() {
        new DnsIndexPage(WebDriverContainer.getDriver()).open();
    }

    @Given("I select {string} category in Menu on the Home page")
    public void selectCategoryInMenuOnTheHomePage(String category) {
        new DnsIndexPage(WebDriverContainer.getDriver()).selectCategory(category);
    }
}
