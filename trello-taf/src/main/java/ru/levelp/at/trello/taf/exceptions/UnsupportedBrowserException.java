package ru.levelp.at.trello.taf.exceptions;

import java.util.Arrays;
import java.util.stream.Collectors;
import ru.levelp.at.trello.taf.service.wed.driver.BrowserName;

public class UnsupportedBrowserException extends IllegalArgumentException {

    public UnsupportedBrowserException(final BrowserName browserName) {
        super(String.format("Браузер %s не поддерживается для запуска тестов.\n"
                + "Поддерживаемые браузеры %s", browserName.getName(),
            Arrays.stream(BrowserName.values()).map(BrowserName::getName).collect(Collectors.joining(", "))));
    }
}
