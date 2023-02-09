package ru.levelp.at.lesson0304.groups;

import java.util.List;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import ru.levelp.at.lesson0304.SymbolDeliter;
import ru.levelp.at.lesson0304.SymbolDeliterApp;

public abstract class BeforeAfterGroupsHookBaseSymbolDeliterTest {
    protected SymbolDeliter sd;
    protected List<String> input;
    protected List<String> expected;

    @BeforeSuite
    public void beforeSuite() {
        System.out.println(this.getClass().getName() + " before suite");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println(this.getClass().getName() + " before test");
    }

    @BeforeGroups(groups = {GroupNames.POSITIVE_GROUP_NAME, GroupNames.NEGATIVE_GROUP_NAME})
    public void beforeGroups() {
        System.out.println(this.getClass().getName() + " before groups");
    }

    @BeforeClass(alwaysRun = true)
    public void beforeClass() {
        System.out.println(this.getClass().getName() + " before class");

        input = List.of("send", "system", "solo", "home", "brother");
        expected = List.of("end", "ytem", "olo", "home", "brother");
    }

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        System.out.println(this.getClass().getName() + " before method");

        sd = new SymbolDeliterApp();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        System.out.println(this.getClass().getName() + " after method");

        sd = null;

        System.out.println("======");
        System.out.println();
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        System.out.println(this.getClass().getName() + " after class");
        System.out.println("-----");
        System.out.println();
    }

    @AfterGroups(groups = {"positive", "negative"})
    public void afterGroups() {
        System.out.println(this.getClass().getName() + " after groups");
    }

    @AfterTest
    public void afterTest() {
        System.out.println(this.getClass().getName() + " after test");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println(this.getClass().getName() + " after suite");
    }
}
