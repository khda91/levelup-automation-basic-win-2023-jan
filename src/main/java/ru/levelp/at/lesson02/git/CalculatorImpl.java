package ru.levelp.at.lesson02.git;

import java.math.BigDecimal;
import java.util.Arrays;

public class CalculatorImpl implements Calculator {
    @Override

    public BigDecimal sum(BigDecimal a, BigDecimal b) {
        return a.add(b);
    }

    @Override
    public BigDecimal sum(BigDecimal... array) {
        return Arrays.stream(array).reduce(BigDecimal::add).get();
    }

    @Override
    public BigDecimal subtract(BigDecimal a, BigDecimal b) {
        return a.subtract(b);
    }

    @Override
    public BigDecimal subtract(BigDecimal a, BigDecimal b, BigDecimal c, BigDecimal d) {
        return a.subtract(b).subtract(c).subtract(d);
    }

    @Override
    public BigDecimal multiply(BigDecimal a, BigDecimal b) {
        return a.multiply(b);
    }

    @Override
    public BigDecimal multiply(BigDecimal... array) {
        return Arrays.stream(array).reduce(BigDecimal::multiply).get();
    }

    @Override
    public BigDecimal divide(BigDecimal a, BigDecimal b) {
        return a.divide(b);
    }

}
