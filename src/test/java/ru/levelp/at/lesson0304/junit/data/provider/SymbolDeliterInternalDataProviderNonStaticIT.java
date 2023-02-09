package ru.levelp.at.lesson0304.junit.data.provider;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import ru.levelp.at.lesson0304.SymbolDeliter;
import ru.levelp.at.lesson0304.SymbolDeliterApp;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SymbolDeliterInternalDataProviderNonStaticIT {

    Stream<Arguments> dataProvider() {
        return Stream.of(
            Arguments.of(List.of("salt", "sold", "system", "brother"), "s",
                List.of("alt", "old", "ytem", "brother")),
            Arguments.of(List.of("Salt", "sold", "syStem", "brother"), "s",
                List.of("alt", "old", "ytem", "brother")),
            Arguments.of(List.of("Salt", "Sold", "SyStem", "brother"), "S",
                List.of("alt", "old", "ytem", "brother")),
            Arguments.of(List.of("Salt", "sold", "syStem", "brother"), "S",
                List.of("alt", "old", "ytem", "brother"))
        );
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
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
