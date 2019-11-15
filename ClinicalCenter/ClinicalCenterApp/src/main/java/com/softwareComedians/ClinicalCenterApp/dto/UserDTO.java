package com.softwareComedians.ClinicalCenterApp.dto;

import lombok.Getter;
import lombok.Setter;
import com.softwareComedians.ClinicalCenterApp.model.User;
@Setter
@Getter
public class UserDTO {
    private Long id;
    private String name;
    private String surname;
    private String ucidn;
    private String address;
    private String city;
    private String country;
    private String email;
    private String phone;
    private String userName;
    private String password;
    private boolean isActivated;

    public UserDTO() {
    }

    public UserDTO(Long id, String name, String surname, String ucidn, String address, String city, String country, String email, String phone, String userName, String password, boolean isActivated) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.ucidn = ucidn;
        this.address = address;
        this.city = city;
        this.country = country;
        this.email = email;
        this.phone = phone;
        this.userName = userName;
        this.password = password;
        this.isActivated = isActivated;
    }



}
