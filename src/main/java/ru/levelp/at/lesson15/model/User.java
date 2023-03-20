package ru.levelp.at.lesson15.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@Getter
@ToString
public class User {

    private final Long id;
    private final String email;
    private final String name;
}
