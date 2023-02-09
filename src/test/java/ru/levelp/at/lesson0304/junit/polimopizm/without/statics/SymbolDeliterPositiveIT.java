package ru.levelp.at.lesson0304.junit.polimopizm.without.statics;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class SymbolDeliterPositiveIT extends BaseSymbolDeliterIT {

    @BeforeAll
    @Override
    void beforeAll() {
        super.beforeAll();
        System.out.println("Хоп-Хей! Переопределился!");
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
}
