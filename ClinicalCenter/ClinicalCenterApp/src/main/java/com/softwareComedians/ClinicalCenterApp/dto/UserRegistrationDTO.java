package com.softwareComedians.ClinicalCenterApp.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@NoArgsConstructor
@Getter
@Setter
public class UserRegistrationDTO {

    @NotNull(message = "First name must be provided")
    private String name;

    @NotNull(message = "Last name must be provided")
    private String surname;

    @NotNull(message = "UCIDN must be provided")
    private String ucidn;

    @NotNull(message = "Address must be provided")
    private String address;

    @NotNull(message = "Phone must be provided")
    private String phone;

    @NotNull(message = "City must be provided")
    private String city;

    @NotNull(message = "Country must be provided")
    private String country;

    @NotNull(message = "Username must be provided")
    private String username;

    @NotNull(message = "Role must be provided")
    private String role;

    @NotNull(message = "Password must be provided")
    @Size(min = 3, message = "Password must be at least 3 characters long")
    private String password;

    @NotNull(message = "Email must be provided")
    @Email
    private String email;

}
