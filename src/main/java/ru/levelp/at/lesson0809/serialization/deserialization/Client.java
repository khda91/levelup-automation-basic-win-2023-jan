package ru.levelp.at.lesson0809.serialization.deserialization;

import java.io.Serializable;
import java.time.LocalDate;

public class Client implements Serializable {

    private String id;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private Long accountNumber;

    public Client(String id, String firstName, String lastName, LocalDate dateOfBirth, Long accountNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.accountNumber = accountNumber;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Override
    public String toString() {
        return "Client{"
            + "id='" + id + '\''
            + ", firstName='" + firstName + '\''
            + ", lastName='" + lastName + '\''
            + ", dateOfBirth=" + dateOfBirth
            + ", accountNumber=" + accountNumber
            + '}';
    }
}
