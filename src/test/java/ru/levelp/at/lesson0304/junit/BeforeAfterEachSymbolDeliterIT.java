package ru.levelp.at.lesson0304.junit;

import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.levelp.at.lesson0304.SymbolDeliter;
import ru.levelp.at.lesson0304.SymbolDeliterApp;

public class BeforeAfterEachSymbolDeliterIT {

    private SymbolDeliter symbolDeliter;
    private List<String> input;
    private String deletedSymbol;
    private List<String> expected;

    @BeforeEach
    void setUp() {
        System.out.println(this.getClass().getName() + " before each");
        symbolDeliter = new SymbolDeliterApp();
        input = List.of("salt", "sold", "system", "brother");
        deletedSymbol = "s";
        expected = List.of("alt", "old", "ytem", "brother");
    }

    @Test
    void shouldDeleteSymbol() {
        System.out.println(this.getClass().getName() + " shouldDeleteSymbol");
        final var actual = symbolDeliter.deleteSymbol(input, deletedSymbol);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldDeleteSymbolFail() {
        System.out.println(this.getClass().getName() + " shouldDeleteSymbolFail");
        final var actual = symbolDeliter.deleteSymbol(input, deletedSymbol);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldThrowExceptionWhenInputIsNull() {
        System.out.println(this.getClass().getName() + " shouldThrowExceptionWhenInputIsNull");

        Assertions.assertThrows(IllegalArgumentException.class,
            () -> symbolDeliter.deleteSymbol(null, deletedSymbol));
    }

    @AfterEach
    void tearDown() {
        System.out.println(this.getClass().getName() + " tear down");
        symbolDeliter = null;
    }
}
