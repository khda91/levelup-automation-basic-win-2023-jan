package ru.levelp.at.lesson0304.junit.polimopizm.with.statics;

import java.util.Collections;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SymbolDeliterNegativeIT extends BaseSymbolDeliterIT {

    @BeforeEach
    @Override
    void setUp() {
        System.out.println("А я был переопределён!");
        super.setUp();
    }

    @Test
    void shouldThrowExceptionWhenInputIsNull() {
        System.out.println(this.getClass().getName() + " shouldThrowExceptionWhenInputIsNull");

        Assertions.assertThrows(IllegalArgumentException.class,
            () -> symbolDeliter.deleteSymbol(null, deletedSymbol));
    }

    @Test
    void shouldThrowExceptionWhenInputIsEmpty() {
        System.out.println(this.getClass().getName() + " shouldThrowExceptionWhenInputIsEmpty");

        Assertions.assertThrows(IllegalArgumentException.class,
            () -> symbolDeliter.deleteSymbol(Collections.emptyList(), deletedSymbol));
    }
}
