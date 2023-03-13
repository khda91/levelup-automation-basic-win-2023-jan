package ru.levelp.at.lesson12.design.patterns.builder;

public class PersonWithBuilder {

    private final String firstName;
    private final String lastName;
    private final Integer age;
    private final String email;

    public PersonWithBuilder(String firstName, String lastName, Integer age, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String firstName;
        private String lastName;
        private Integer age;
        private String email;

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder age(Integer age) {
            this.age = age;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public PersonWithBuilder build() {
            return new PersonWithBuilder(firstName, lastName, age, email);
        }
    }

    @Override
    public String toString() {
        return "PersonWithBuilder{"
            + "firstName='" + firstName + '\''
            + ", lastName='" + lastName + '\''
            + ", age=" + age
            + ", email='" + email + '\''
            + '}';
    }
}
