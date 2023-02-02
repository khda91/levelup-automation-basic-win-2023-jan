package ru.levelp.at.lesson02.git;

import java.math.BigDecimal;

public class App {

    public static void main(String[] args) {
        Calculator calculator = new CalculatorImpl();

        // сложение
        System.out.println("10 + 12 = " + calculator.sum(BigDecimal.valueOf(10), BigDecimal.valueOf(12)));

        // умножение
        System.out.println("10 * 12 = " + calculator.multiply(BigDecimal.valueOf(10), BigDecimal.valueOf(12)));
    }
}