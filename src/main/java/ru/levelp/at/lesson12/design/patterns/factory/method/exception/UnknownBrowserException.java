package ru.levelp.at.lesson12.design.patterns.factory.method.exception;

public class UnknownBrowserException extends IllegalArgumentException {

    public UnknownBrowserException(String browserName) {
        super(String.format("'%s' is unknown browser name", browserName));
    }
}
