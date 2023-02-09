package ru.levelp.at.lesson0304.data.providers;

import java.util.List;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.levelp.at.lesson0304.SymbolDeliter;
import ru.levelp.at.lesson0304.SymbolDeliterApp;

public class SymbolDeliterExternalDataProviderTest {

    private SymbolDeliter symbolDeliter;

    @BeforeMethod
    public void setUp() {
        symbolDeliter = new SymbolDeliterApp();
    }

    @Test(dataProviderClass = SymbolDeliterExternalDataProvider.class, dataProvider = "dataProvider")
    public void shouldDeleteLetter(List<String> input, String deletedSymbol, List<String> expected) {
        final var actual = symbolDeliter.deleteSymbol(input, deletedSymbol);

        Assert.assertEquals(actual, expected);
    }

    @Test(dataProviderClass = SymbolDeliterExternalDataProvider.class, dataProvider = "Data Provider for test")
    public void shouldDeleteLetter1(List<String> input, String deletedSymbol, List<String> expected) {
        final var actual = symbolDeliter.deleteSymbol(input, deletedSymbol);

        Assert.assertEquals(actual, expected);
    }

    @AfterMethod
    public void tearDown() {
        symbolDeliter = null;
    }
}
