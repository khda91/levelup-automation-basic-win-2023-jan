package ru.levelp.at.lesson12.design.patterns.strategy;

import java.math.BigDecimal;

public class TaxCalculatorProviderImpl implements TaxCalculatorProvider {

    private final TaxCalculator taxCalculator;

    public TaxCalculatorProviderImpl(TaxCalculator taxCalculator) {
        this.taxCalculator = taxCalculator;
    }

    @Override
    public BigDecimal calculate(BigDecimal income) {
        return taxCalculator.calculate(income);
    }
}
