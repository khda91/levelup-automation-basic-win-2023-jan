package ru.levelp.at.trello.taf.service.wed.driver;

import java.util.Arrays;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum BrowserName {

    CHROME("chrome"),
    EDGE("edge");

    private final String name;


    public static BrowserName getBrowserName(final String name) {
        return Arrays.stream(values())
                     .filter(bn -> bn.name.equalsIgnoreCase(name))
                     .findFirst()
                     .get();
    }
}
