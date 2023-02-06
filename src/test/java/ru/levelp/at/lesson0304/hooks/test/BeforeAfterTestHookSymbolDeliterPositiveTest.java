package ru.levelp.at.lesson0304.hooks.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class BeforeAfterTestHookSymbolDeliterPositiveTest extends BeforeAfterTestHookBaseSymbolDeliterTest {

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

    @AfterMethod
    @Override
    public void tearDown() {
        super.tearDown();
        System.out.println("Хоп-хей ла-ла-лей!");
    }
}
