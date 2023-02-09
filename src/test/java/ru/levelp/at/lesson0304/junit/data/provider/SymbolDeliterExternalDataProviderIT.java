package ru.levelp.at.lesson0304.junit.data.provider;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import ru.levelp.at.lesson0304.SymbolDeliter;
import ru.levelp.at.lesson0304.SymbolDeliterApp;

public class SymbolDeliterExternalDataProviderIT {

    @ParameterizedTest
    @MethodSource("ru.levelp.at.lesson0304.junit.data.provider.SymbolDeliterExternalDataProvider#dataProvider")
    void shouldDeleteSymbol(List<String> input, String deletedSymbol, List<String> expected) {
        SymbolDeliter symbolDeliter = new SymbolDeliterApp();
        final var actual = symbolDeliter.deleteSymbol(input, deletedSymbol);

        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @NullAndEmptySource
    void shouldThrowExceptionWhenInputIsNull(List<String> input) {
        final var deletedSymbol = "s";

        SymbolDeliter symbolDeliter = new SymbolDeliterApp();

        Assertions.assertThrows(IllegalArgumentException.class,
            () -> symbolDeliter.deleteSymbol(input, deletedSymbol));
    }
}
