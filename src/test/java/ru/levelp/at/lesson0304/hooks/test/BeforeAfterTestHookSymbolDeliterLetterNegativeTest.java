package ru.levelp.at.lesson0304.hooks.test;

import org.testng.annotations.Test;

public class BeforeAfterTestHookSymbolDeliterLetterNegativeTest extends BeforeAfterTestHookBaseSymbolDeliterTest {

    @Test(expectedExceptions = {IllegalArgumentException.class},
          expectedExceptionsMessageRegExp = "Не задан удаляемый символ")
    public void shouldThrowExceptionWhenLetterIsNull() {
        System.out.println(this.getClass().getName() + " shouldThrowExceptionWhenLetterIsNull");

        sd.deleteSymbol(input, null);
    }

    @Test(expectedExceptions = {IllegalArgumentException.class},
          expectedExceptionsMessageRegExp = "Длина удаяемого символа не может быть больше 1")
    public void shouldThrowExceptionWhenLetterHasLengthMoreThatOneSymbol() {
        System.out.println(this.getClass().getName() + " shouldThrowExceptionWhenLetterHasLengthMoreThatOneSymbol");

        sd.deleteSymbol(input, "Sss");
    }
}
