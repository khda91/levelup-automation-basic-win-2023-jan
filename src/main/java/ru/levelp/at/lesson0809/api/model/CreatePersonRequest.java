package ru.levelp.at.lesson0809.api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
@Builder
public class CreatePersonRequest {

    private String role;
    private String email;
    private String phoneNumber;
    private String placeOfWork;
    private IdentityData identity;
    private AddressData address;
}
