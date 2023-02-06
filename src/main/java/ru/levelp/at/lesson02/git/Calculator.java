package ru.levelp.at.lesson02.git;

import java.math.BigDecimal;

public interface Calculator {

    BigDecimal sum(BigDecimal a, BigDecimal b);

    BigDecimal sum(BigDecimal... array);

    BigDecimal subtract(BigDecimal a, BigDecimal b);

    BigDecimal subtract(BigDecimal a, BigDecimal b, BigDecimal c, BigDecimal d);

    BigDecimal multiply(BigDecimal a, BigDecimal b);

    BigDecimal multiply(BigDecimal... a);

    BigDecimal divide(BigDecimal a, BigDecimal b);


}
