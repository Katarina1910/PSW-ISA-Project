package com.softwareComedians.ClinicalCenterApp.dto;

import com.softwareComedians.ClinicalCenterApp.model.User;
import lombok.Getter;
import lombok.Setter;

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
    private String role;

    public UserDTO() {
    }

    public UserDTO(Long id, String name, String surname, String ucidn, String address, String role, String city, String country, String email, String phone, String userName, String password, boolean isActivated) {
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
        this.role=role;

    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public UserDTO(User u){
        id=u.getId();
        name=u.getName();
        surname=u.getSurname();
        ucidn=u.getUcidn();
        address=u.getAddress();
        city=u.getCity();
        country=u.getCountry();
        email=u.getEmail();
        phone=u.getPhone();
        userName=u.getUserName();
        password=u.getPassword();
        isActivated=u.isActivated();
        role=u.getRole();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUcidn() {
        return ucidn;
    }

    public void setUcidn(String ucidn) {
        this.ucidn = ucidn;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActivated() {
        return isActivated;
    }

    public void setActivated(boolean activated) {
        isActivated = activated;
    }
}
