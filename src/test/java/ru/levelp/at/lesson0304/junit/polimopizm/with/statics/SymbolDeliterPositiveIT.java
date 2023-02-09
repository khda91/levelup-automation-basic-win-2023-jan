package ru.levelp.at.lesson0304.junit.polimopizm.with.statics;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SymbolDeliterPositiveIT extends BaseSymbolDeliterIT {

    // Вот так вот делать нельзя!
    // Методы с модификаторм доступа static не могут быть переопределены, так как живут на уровне класса
    // @BeforeAll
    // @Override
    //    static void beforeAll() {
    //        System.out.println(BaseSymbolDeliterTest.class.getName() + " before all");
    //        input = List.of("salt", "sold", "system", "brother");
    //        deletedSymbol = "s";
    //        expected = List.of("alt", "old", "ytem", "brother");
    //    }

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
