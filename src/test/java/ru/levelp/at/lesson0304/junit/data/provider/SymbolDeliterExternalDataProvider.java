package ru.levelp.at.lesson0304.junit.data.provider;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;

public class SymbolDeliterExternalDataProvider {

    static Stream<Arguments> dataProvider() {
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
}
