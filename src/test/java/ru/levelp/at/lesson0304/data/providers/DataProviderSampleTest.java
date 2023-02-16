package ru.levelp.at.lesson0304.data.providers;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class DataProviderSampleTest {

    @DataProvider
    static Object[][] sumDataProvider() {
        return new Object[][] {
            {1, 1, "2"},
            {2, 2, "4"},
            {2, 4, "6"},
            {5, 4, "9"}
        };
    }

    @Test(dataProvider = "sumDataProvider")
    public void sumTest(Integer a, Integer b, String expected) {
        var result = a + b;
        assertEquals(result, Integer.parseInt(expected));
    }
}
