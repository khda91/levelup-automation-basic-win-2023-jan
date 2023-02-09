package ru.levelp.at.lesson0304.junit.tags;

import java.util.Collections;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.levelp.at.lesson0304.junit.tags.annotation.NegativeTag;

public class SymbolDeliterNegativeIT extends BaseSymbolDeliterIT {

    @Test
    // @Tag("negative")
    @NegativeTag
    void shouldThrowExceptionWhenInputIsNull() {
        System.out.println(this.getClass().getName() + " shouldThrowExceptionWhenInputIsNull");

        Assertions.assertThrows(IllegalArgumentException.class,
            () -> symbolDeliter.deleteSymbol(null, deletedSymbol));
    }

    @Test
    @Tags({@Tag(TagNames.NEGATIVE_TAG_NAME), @Tag("one_more_tag")})
    void shouldThrowExceptionWhenInputIsEmpty() {
        System.out.println(this.getClass().getName() + " shouldThrowExceptionWhenInputIsEmpty");

        Assertions.assertThrows(IllegalArgumentException.class,
            () -> symbolDeliter.deleteSymbol(Collections.emptyList(), deletedSymbol));
    }
}
