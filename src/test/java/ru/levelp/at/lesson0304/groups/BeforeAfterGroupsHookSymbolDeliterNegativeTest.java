package ru.levelp.at.lesson0304.groups;

import java.util.Collections;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BeforeAfterGroupsHookSymbolDeliterNegativeTest extends BeforeAfterGroupsHookBaseSymbolDeliterTest {

    @BeforeClass
    @Override
    public void beforeClass() {
        super.beforeClass();
        System.out.println("Оп! Переопределили");
    }

    @Test(expectedExceptions = {IllegalArgumentException.class},
          expectedExceptionsMessageRegExp = "Входные данные не могут быть пустыми",
          groups = {GroupNames.NEGATIVE_GROUP_NAME})
    public void shouldThrowExceptionWhenListIsNull() {
        System.out.println(this.getClass().getName() + " shouldThrowExceptionWhenListIsNull");

        sd.deleteSymbol(null, "S");
    }

    @Test(expectedExceptions = {IllegalArgumentException.class},
          expectedExceptionsMessageRegExp = "Входные данные не могут быть пустыми",
          groups = {"negative"})
    public void shouldThrowExceptionWhenListIsEmpty() {
        System.out.println(this.getClass().getName() + " shouldThrowExceptionWhenListIsEmpty");

        sd.deleteSymbol(Collections.emptyList(), "S");
    }
}
