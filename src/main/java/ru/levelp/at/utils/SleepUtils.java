package ru.levelp.at.utils;

public final class SleepUtils {

    private SleepUtils() {
    }

    public static void sleep(long timeout) {
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
