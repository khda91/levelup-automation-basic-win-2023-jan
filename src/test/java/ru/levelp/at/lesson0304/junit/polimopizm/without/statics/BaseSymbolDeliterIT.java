package ru.levelp.at.lesson0304.junit.polimopizm.without.statics;

import java.util.List;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import ru.levelp.at.lesson0304.SymbolDeliter;
import ru.levelp.at.lesson0304.SymbolDeliterApp;

@TestInstance(Lifecycle.PER_CLASS)
public class BaseSymbolDeliterIT {
    protected List<String> input;
    protected String deletedSymbol;
    protected List<String> expected;
    protected SymbolDeliter symbolDeliter;

    @BeforeAll
    void beforeAll() {
        System.out.println(this.getClass().getName() + " before all");
        input = List.of("salt", "sold", "system", "brother");
        deletedSymbol = "s";
        expected = List.of("alt", "old", "ytem", "brother");
    }

    @AfterAll
    void afterAll() {
        System.out.println(this.getClass().getName() + " after all");
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
