package ru.levelp.at.lesson0304.junit.inheritance.with.statics;

import java.util.List;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import ru.levelp.at.lesson0304.SymbolDeliter;
import ru.levelp.at.lesson0304.SymbolDeliterApp;

public class BaseSymbolDeliterIT {
    protected static List<String> input;
    protected static String deletedSymbol;
    protected static List<String> expected;
    protected SymbolDeliter symbolDeliter;

    @BeforeAll
    static void beforeAll() {
        System.out.println(BaseSymbolDeliterIT.class.getName() + " before all");
        input = List.of("salt", "sold", "system", "brother");
        deletedSymbol = "s";
        expected = List.of("alt", "old", "ytem", "brother");
    }

    @AfterAll
    static void afterAll() {
        System.out.println(BaseSymbolDeliterIT.class.getName() + " after all");
    }

    @BeforeEach
    void setUp() {
        System.out.println(this.getClass().getName() + " before each");
        symbolDeliter = new SymbolDeliterApp();
    }

    @AfterEach
    void tearDown() {
        System.out.println(this.getClass().getName() + " tear down");
        symbolDeliter = null;
    }
}
