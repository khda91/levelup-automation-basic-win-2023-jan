package ru.levelp.at.lesson0304.junit.tags;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class SymbolDeliterPositiveIT extends BaseSymbolDeliterIT {

    @Test
    @Tag(TagNames.POSITIVE_TAG_NAME)
    @Tag(TagNames.ONE_MORE_TAG_NAME)
    void shouldDeleteSymbol() {
        System.out.println(this.getClass().getName() + " shouldDeleteSymbol");
        final var actual = symbolDeliter.deleteSymbol(input, deletedSymbol);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @Tag("positive")
    void shouldDeleteSymbolFail() {
        System.out.println(this.getClass().getName() + " shouldDeleteSymbolFail");
        final var actual = symbolDeliter.deleteSymbol(input, deletedSymbol);

        Assertions.assertEquals(expected, actual);
    }
}
