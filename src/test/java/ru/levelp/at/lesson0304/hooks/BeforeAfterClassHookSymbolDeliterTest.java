package ru.levelp.at.lesson0304.hooks;

import java.util.Collections;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.levelp.at.lesson0304.SymbolDeliter;
import ru.levelp.at.lesson0304.SymbolDeliterApp;

public class BeforeAfterClassHookSymbolDeliterTest {

    private List<String> input;
    private List<String> expected;

    private SymbolDeliter sd;

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

    @Test
    public void shouldDeleteLetter() {
        System.out.println(this.getClass().getName() + " shouldDeleteLetter");

        final var deletedSymbol = "s";

        final var actual = sd.deleteSymbol(input, deletedSymbol);

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void shouldDeleteCapitalLetter() {
        System.out.println(this.getClass().getName() + " shouldDeleteCapitalLetter");

        final var deletedSymbol = "S";

        final var actual = sd.deleteSymbol(input, deletedSymbol);

        Assert.assertEquals(actual, expected);
    }

    @Test(expectedExceptions = {IllegalArgumentException.class},
          expectedExceptionsMessageRegExp = "Входные данные не могут быть пустыми")
    public void shouldThrowExceptionWhenListIsNull() {
        System.out.println(this.getClass().getName() + " shouldThrowExceptionWhenListIsNull");

        sd.deleteSymbol(null, "S");
    }

    @Test(expectedExceptions = {IllegalArgumentException.class},
          expectedExceptionsMessageRegExp = "Входные данные не могут быть пустыми")
    public void shouldThrowExceptionWhenListIsEmpty() {
        System.out.println(this.getClass().getName() + " shouldThrowExceptionWhenListIsEmpty");

        sd.deleteSymbol(Collections.emptyList(), "S");
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
}
