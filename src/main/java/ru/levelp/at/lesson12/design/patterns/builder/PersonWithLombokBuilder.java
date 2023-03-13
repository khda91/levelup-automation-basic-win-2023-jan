package ru.levelp.at.lesson12.design.patterns.builder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@ToString
public class PersonWithLombokBuilder {

    private String firstName;
    private String lastName;
    private Integer age;
    private String email;
}
