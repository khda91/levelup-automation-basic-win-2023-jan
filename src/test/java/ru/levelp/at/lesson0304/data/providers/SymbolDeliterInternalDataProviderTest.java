package ru.levelp.at.lesson0304.data.providers;

import java.util.List;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.levelp.at.lesson0304.SymbolDeliter;
import ru.levelp.at.lesson0304.SymbolDeliterApp;

public class SymbolDeliterInternalDataProviderTest {

    private SymbolDeliter symbolDeliter;

    @DataProvider
    public Object[][] dataProvider() {
        return new Object[][] {
            {List.of("send", "system", "solo", "home", "brother"), "s",
                List.of("end", "ytem", "olo", "home", "brother")},
            {List.of("Send", "SyStem", "Solo", "home", "brother"), "s",
                List.of("end", "ytem", "olo", "home", "brother")},
            {List.of("send", "system", "solo", "home", "brother"), "S",
                List.of("end", "ytem", "olo", "home", "brother")},
            {List.of("Send", "SyStem", "Solo", "home", "brother"), "S",
                List.of("end", "ytem", "olo", "home", "brother")},
            {List.of("Send", "System", "solo", "home", "brother"), "s",
                List.of("end", "ytem", "olo", "home", "brother")},
            {List.of("Send", "System", "solo", "home", "brother"), "S",
                List.of("end", "ytem", "olo", "home", "brother")}
        };
    }

    @DataProvider(name = "Data Provider for test")
    public Object[][] dataProvider1() {
        return new Object[][] {
            {List.of("send", "system", "solo", "home", "brother"), "s",
                List.of("end", "ytem", "olo", "home", "brother")},
            {List.of("Send", "SyStem", "Solo", "home", "brother"), "s",
                List.of("end", "ytem", "olo", "home", "brother")},
            {List.of("send", "system", "solo", "home", "brother"), "S",
                List.of("end", "ytem", "olo", "home", "brother")},
            {List.of("Send", "SyStem", "Solo", "home", "brother"), "S",
                List.of("end", "ytem", "olo", "home", "brother")},
            {List.of("Send", "System", "solo", "home", "brother"), "s",
                List.of("end", "ytem", "olo", "home", "brother")},
            {List.of("Send", "System", "solo", "home", "brother"), "S",
                List.of("end", "ytem", "olo", "home", "brother")}
        };
    }

    @BeforeMethod
    public void setUp() {
        symbolDeliter = new SymbolDeliterApp();
    }

    @Test(dataProvider = "dataProvider")
    public void shouldDeleteLetter(List<String> input, String deletedSymbol, List<String> expected) {
        final var actual = symbolDeliter.deleteSymbol(input, deletedSymbol);

        Assert.assertEquals(actual, expected);
    }

    @Test(dataProvider = "Data Provider for test")
    public void shouldDeleteLetter1(List<String> input, String deletedSymbol, List<String> expected) {
        final var actual = symbolDeliter.deleteSymbol(input, deletedSymbol);

        Assert.assertEquals(actual, expected);
    }

    @AfterMethod
    public void tearDown() {
        symbolDeliter = null;
    }
}
