package ru.levelp.at.lesson0304.hooks.test;

import java.util.Collections;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BeforeAfterTestHookSymbolDeliterNegativeTest extends BeforeAfterTestHookBaseSymbolDeliterTest {

    @BeforeClass
    @Override
    public void beforeClass() {
        super.beforeClass();
        System.out.println("Оп! Переопределили");
    }

    @Test(expectedExceptions = {IllegalArgumentException.class},
          expectedExceptionsMessageRegExp = "Входные данные не могут быть пустыми")
    public void shouldThrowExceptionWhenListIsNull() {
        System.out.println(this.getClass().getName() + " shouldThrowExceptionWhenListIsNull");

        sd.deleteSymbol(null, "S");
    }

    @Test(expectedExceptions = {IllegalArgumentException.class},
          expectedExceptionsMessageRegExp = "Входные данные не могут быть пустыми")
    public void shouldThrowExceptionWhenListIsEmpty() {
        System.out.println(this.getClass().getName() + " shouldThrowExceptionWhenListIsEmpty");

        sd.deleteSymbol(Collections.emptyList(), "S");
    }
}
