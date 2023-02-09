package ru.levelp.at.lesson0304.data.providers;

import java.util.List;
import org.testng.annotations.DataProvider;

public class SymbolDeliterExternalDataProvider {

    @DataProvider
    public static Object[][] dataProvider() {
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
    public static Object[][] dataProvider1() {
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
}
