package ru.levelp.at.lesson12.design.patterns.strategy;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.stream.Stream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class TurTaxCalculatorTest {

    private TaxCalculatorProvider taxCalculatorProvider;

    @BeforeEach
    void setUp() {
        taxCalculatorProvider = new TaxCalculatorProviderImpl(new TurTaxCalculator());
    }

    static Stream<Arguments> taxData() {
        return Stream.of(
            Arguments.of(BigDecimal.valueOf(30_000), BigDecimal.valueOf(4_500).setScale(2, RoundingMode.HALF_UP)),
            Arguments.of(BigDecimal.valueOf(68_000), BigDecimal.valueOf(13_600).setScale(2, RoundingMode.HALF_UP)),
            Arguments.of(BigDecimal.valueOf(125_000), BigDecimal.valueOf(33_750).setScale(2, RoundingMode.HALF_UP)),
            Arguments.of(BigDecimal.valueOf(400_000), BigDecimal.valueOf(140_000).setScale(2, RoundingMode.HALF_UP)),
            Arguments.of(BigDecimal.valueOf(900_000), BigDecimal.valueOf(360_000).setScale(2, RoundingMode.HALF_UP))
        );
    }

    @ParameterizedTest(name = "income: {0}")
    @MethodSource("taxData")
    void turTaxes(BigDecimal income, BigDecimal expectedTax) {
        var actual = taxCalculatorProvider.calculate(income);
        assertThat(actual).isEqualTo(expectedTax);
    }

    @AfterEach
    void tearDown() {
        taxCalculatorProvider = null;
    }
}
