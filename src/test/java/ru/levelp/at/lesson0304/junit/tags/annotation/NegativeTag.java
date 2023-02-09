package ru.levelp.at.lesson0304.junit.tags.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.junit.jupiter.api.Tag;
import ru.levelp.at.lesson0304.junit.tags.TagNames;

@Target({ ElementType.TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
// @Tag("negative")
@Tag(TagNames.NEGATIVE_TAG_NAME)
public @interface NegativeTag {
}
