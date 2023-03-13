package ru.levelp.at.lesson12.design.patterns.strategy;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class TurTaxCalculator implements TaxCalculator {

    private static final BigDecimal TAX_RATE_15 = BigDecimal.valueOf(0.15);
    private static final BigDecimal TAX_RATE_20 = BigDecimal.valueOf(0.20);
    private static final BigDecimal TAX_RATE_27 = BigDecimal.valueOf(0.27);
    private static final BigDecimal TAX_RATE_35 = BigDecimal.valueOf(0.35);
    private static final BigDecimal TAX_RATE_40 = BigDecimal.valueOf(0.40);

    private static final BigDecimal BOUND_32000 = BigDecimal.valueOf(32_000);
    private static final BigDecimal BOUND_70000 = BigDecimal.valueOf(70_000);
    private static final BigDecimal BOUND_250000 = BigDecimal.valueOf(250_000);
    private static final BigDecimal BOUND_880000 = BigDecimal.valueOf(880_000);

    @Override
    public BigDecimal calculate(BigDecimal income) {
        if (BOUND_32000.compareTo(income) > 0) {
            return TAX_RATE_15.multiply(income).setScale(2, RoundingMode.HALF_UP);
        } else if (BOUND_32000.compareTo(income) <= 0 && BOUND_70000.compareTo(income) > 0) {
            return TAX_RATE_20.multiply(income).setScale(2, RoundingMode.HALF_UP);
        } else if (BOUND_70000.compareTo(income) <= 0 && BOUND_250000.compareTo(income) > 0) {
            return TAX_RATE_27.multiply(income).setScale(2, RoundingMode.HALF_UP);
        } else if (BOUND_250000.compareTo(income) <= 0 && BOUND_880000.compareTo(income) > 0) {
            return TAX_RATE_35.multiply(income).setScale(2, RoundingMode.HALF_UP);
        }

        return TAX_RATE_40.multiply(income).setScale(2, RoundingMode.HALF_UP);
    }
}
