package ru.levelp.at.lesson11.jenkins.annotation;

import io.qameta.allure.LabelAnnotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@LabelAnnotation(name = "custom label")
public @interface MyCustomLabel {

    String value();
}
