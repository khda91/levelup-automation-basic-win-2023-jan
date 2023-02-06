package ru.levelp.at.lesson0304.hooks.suite;

import java.util.List;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import ru.levelp.at.lesson0304.SymbolDeliter;
import ru.levelp.at.lesson0304.SymbolDeliterApp;

public abstract class BeforeAfterSuiteHookBaseSymbolDeliterTest {
    protected SymbolDeliter sd;
    protected List<String> input;
    protected List<String> expected;

    @BeforeSuite
    public void beforeSuite() {
        System.out.println(this.getClass().getName() + " before suite");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println(this.getClass().getName() + " before class");

        input = List.of("send", "system", "solo", "home", "brother");
        expected = List.of("end", "ytem", "olo", "home", "brother");
    }

    @BeforeMethod
    public void setUp() {
        System.out.println(this.getClass().getName() + " before method");

        sd = new SymbolDeliterApp();
    }

    @AfterMethod
    public void tearDown() {
        System.out.println(this.getClass().getName() + " after method");

        sd = null;

        System.out.println("======");
        System.out.println();
    }

    @AfterClass
    public void afterClass() {
        System.out.println(this.getClass().getName() + " after class");
        System.out.println("-----");
        System.out.println();
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println(this.getClass().getName() + " after suite");
    }
}
