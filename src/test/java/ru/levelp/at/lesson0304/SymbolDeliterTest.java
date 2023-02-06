package ru.levelp.at.lesson0304;

import java.util.Collections;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SymbolDeliterTest {

    @Test
    public void shouldDeleteLetter() {
        final var input = List.of("send", "system", "solo", "home", "brother");
        final var deletedSymbol = "s";
        final var expected = List.of("end", "ytem", "olo", "home", "brother");

        SymbolDeliter sd = new SymbolDeliterApp();
        final var actual = sd.deleteSymbol(input, deletedSymbol);

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void shouldDeleteLetterFail() {
        final var input = List.of("send", "system", "solo", "home", "brother");
        final var deletedSymbol = "s";
        final var expected = List.of("send", "ytem", "olo", "home", "brother");

        SymbolDeliter sd = new SymbolDeliterApp();
        final var actual = sd.deleteSymbol(input, deletedSymbol);

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void shouldDeleteCapitalLetter() {
        final var input = List.of("send", "syStem", "Solo", "home", "brother");
        final var deletedSymbol = "S";
        final var expected = List.of("end", "ytem", "olo", "home", "brother");

        SymbolDeliter sd = new SymbolDeliterApp();
        final var actual = sd.deleteSymbol(input, deletedSymbol);
        System.out.println(actual);

        Assert.assertEquals(actual, expected);
    }

    @Test(expectedExceptions = {IllegalArgumentException.class},
          expectedExceptionsMessageRegExp = "Входные данные не могут быть пустыми")
    public void shouldThrowExceptionWhenListIsNull() {
        SymbolDeliter sd = new SymbolDeliterApp();
        sd.deleteSymbol(null, "S");
    }

    @Test(expectedExceptions = {IllegalArgumentException.class},
          expectedExceptionsMessageRegExp = "Входные данные не могут быть пустыми")
    public void shouldThrowExceptionWhenListIsEmpty() {
        SymbolDeliter sd = new SymbolDeliterApp();
        sd.deleteSymbol(Collections.emptyList(), "S");
    }
}
