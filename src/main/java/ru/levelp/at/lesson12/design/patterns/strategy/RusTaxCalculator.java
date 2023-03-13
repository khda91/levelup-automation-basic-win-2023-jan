package ru.levelp.at.lesson12.design.patterns.strategy;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class RusTaxCalculator implements TaxCalculator {

    private static final BigDecimal STANDARD_TAX_RATE = BigDecimal.valueOf(0.13);
    private static final BigDecimal UPPER_TAX_RATE = BigDecimal.valueOf(0.15);
    private static final BigDecimal UPPER_BOUND = BigDecimal.valueOf(5_000_000);

    @Override
    public BigDecimal calculate(BigDecimal income) {
        if (UPPER_BOUND.compareTo(income) > 0) {
            return STANDARD_TAX_RATE.multiply(income).setScale(2, RoundingMode.HALF_UP);
        }

        return UPPER_TAX_RATE.multiply(income).setScale(2, RoundingMode.HALF_UP);
    }
}
