package ru.levelp.at.lesson13.bdd.hooks;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.BeforeStep;
import ru.levelp.at.lesson13.bdd.context.TestContext;
import ru.levelp.at.lesson13.bdd.service.webdriver.WebDriverContainer;

public class WebDriverHook {

    @Before
    public void setUp() {
        WebDriverContainer.getDriver();
    }

    @After
    public void tearDown() {
        WebDriverContainer.closeDriver();
        TestContext.getInstance().cleanContext();
    }

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Cucumber Before All");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("Cucumber After All");
    }

    @BeforeStep
    public void beforeStep() {
        System.out.println("Cucumber Before Step");
    }

    @AfterStep
    public void afterStep() {
        System.out.println("Cucumber After Step");
    }
}
