package ru.levelp.at.lesson02.git;

import java.math.BigDecimal;

public class CalculatorImpl implements Calculator {
    @Override

    public BigDecimal sum(BigDecimal a, BigDecimal b) {
        return a.add(b);
    }

    @Override
    public BigDecimal subtract(BigDecimal a, BigDecimal b) {
        return a.subtract(b);
    }

    @Override
    public BigDecimal multiply(BigDecimal a, BigDecimal b) {
        return a.multiply(b);
    }

    @Override
    public BigDecimal divide(BigDecimal a, BigDecimal b) {
        return a.divide(b);
    }

    @Override
    public BigDecimal sum(BigDecimal... array) {
        return null;
    }
}