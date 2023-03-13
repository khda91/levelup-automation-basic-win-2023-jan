package ru.levelp.at.lesson12.design.patterns.builder;

public class PersonWithoutBuilder {

    private String firstName;
    private String lastName;
    private Integer age;
    private String email;

    //    public PersonWithoutBuilder(String lastName) {
    //        this(null, lastName, null, null);
    //    }

    public PersonWithoutBuilder(String firstName) {
        this(firstName, null);
    }

    public PersonWithoutBuilder(Integer age, String lastName) {
        this(null, lastName, age, null);
    }

    public PersonWithoutBuilder(String firstName, Integer age) {
        this(firstName, age, null);
    }

    public PersonWithoutBuilder(String firstName, Integer age, String email) {
        this(firstName, null, age, email);
    }

    public PersonWithoutBuilder(String firstName, String lastName, Integer age, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
    }
}
