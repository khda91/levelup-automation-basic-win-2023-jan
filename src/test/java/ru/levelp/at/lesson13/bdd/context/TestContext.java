package ru.levelp.at.lesson13.bdd.context;

import java.util.HashMap;
import java.util.Map;

public final class TestContext {

    private static TestContext instance;

    private final Map<String, Object> context;

    private TestContext() {
        context = new HashMap<>();
    }

    public void addParameter(String key, Object value) {
        context.put(key, value);
    }

    public Object getParameter(String key) {
        return context.get(key);
    }

    public void cleanContext() {
        context.clear();
    }

    public static TestContext getInstance() {
        if (instance == null) {
            instance = new TestContext();
        }
        return instance;
    }
}
