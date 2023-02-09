package ru.levelp.at.lesson0304.groups;

import org.testng.annotations.Test;

public class BeforeAfterGroupsHookSymbolDeliterLetterNegativeTest extends BeforeAfterGroupsHookBaseSymbolDeliterTest {

    @Test(expectedExceptions = {IllegalArgumentException.class},
          expectedExceptionsMessageRegExp = "Не задан удаляемый символ",
          groups = {"negative"})
    public void shouldThrowExceptionWhenLetterIsNull() {
        System.out.println(this.getClass().getName() + " shouldThrowExceptionWhenLetterIsNull");

        sd.deleteSymbol(input, null);
    }

    @Test(expectedExceptions = {IllegalArgumentException.class},
          expectedExceptionsMessageRegExp = "Длина удаяемого символа не может быть больше 1",
          groups = {"negative"})
    public void shouldThrowExceptionWhenLetterHasLengthMoreThatOneSymbol() {
        System.out.println(this.getClass().getName() + " shouldThrowExceptionWhenLetterHasLengthMoreThatOneSymbol");

        sd.deleteSymbol(input, "Sss");
    }
}
