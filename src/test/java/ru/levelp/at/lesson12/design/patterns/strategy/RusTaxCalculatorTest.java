package ru.levelp.at.lesson12.design.patterns.strategy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class RusTaxCalculatorTest {

    private TaxCalculatorProvider taxCalculatorProvider;

    @BeforeEach
    void setUp() {
        taxCalculatorProvider = new TaxCalculatorProviderImpl(new RusTaxCalculator());
    }

    @Test
    void lowerThan5_000_000() {
        final var income = BigDecimal.valueOf(4_485_123);
        var actual = taxCalculatorProvider.calculate(income);
        var expected = BigDecimal.valueOf(583065.99);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void greaterThan5_000_000() {
        final var income = BigDecimal.valueOf(5_485_123);
        var actual = taxCalculatorProvider.calculate(income);
        var expected = BigDecimal.valueOf(822768.45);
        assertThat(actual).isEqualTo(expected);
    }

    @AfterEach
    void tearDown() {
        taxCalculatorProvider = null;
    }
}
