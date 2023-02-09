package ru.levelp.at.lesson0304.junit;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.levelp.at.lesson0304.SymbolDeliter;
import ru.levelp.at.lesson0304.SymbolDeliterApp;

public class SymbolDeliterIT {

    @Test
    void shouldDeleteSymbol() {
        final var input = List.of("salt", "sold", "system", "brother");
        final var deletedSymbol = "s";
        final var expected = List.of("alt", "old", "ytem", "brother");

        SymbolDeliter symbolDeliter = new SymbolDeliterApp();
        final var actual = symbolDeliter.deleteSymbol(input, deletedSymbol);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldDeleteSymbolFail() {
        final var input = List.of("salt", "sold", "system", "brother");
        final var deletedSymbol = "s";
        final var expected = List.of("alt", "sold", "ytem", "brother");

        SymbolDeliter symbolDeliter = new SymbolDeliterApp();
        final var actual = symbolDeliter.deleteSymbol(input, deletedSymbol);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldThrowExceptionWhenInputIsNull() {
        final var deletedSymbol = "s";

        SymbolDeliter symbolDeliter = new SymbolDeliterApp();

        Assertions.assertThrows(IllegalArgumentException.class,
            () -> symbolDeliter.deleteSymbol(null, deletedSymbol));
    }
}
