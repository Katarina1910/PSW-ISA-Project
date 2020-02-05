package com.softwareComedians.ClinicalCenterApp.dto;

import com.softwareComedians.ClinicalCenterApp.model.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
public class PatientDTO {

    private Long id;
    private String name;
    private String surname;
    private String ucidn;
    private String address;
    private String city;
    private String country;
    private String email;
    private String phone;
    private String username;
    private String password;
    private boolean isActivated;
    private UserTokenState token;
    private Set<Authority> authorities = new HashSet<>();
    private MedicalRecord medicalRecord;
    private Set<ConsultTerm> appointedTerms;

    public PatientDTO() {

    }

    public PatientDTO(Long id, String name, String surname, String ucidn, String address,String city, String country,
                      String email, String phone, String username, String password, boolean isActivated,
                      Set<Authority> authorities, MedicalRecord medicalRecord, Set<ConsultTerm> appointedTerms) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.ucidn = ucidn;
        this.address = address;
        this.city = city;
        this.country = country;
        this.email = email;
        this.phone = phone;
        this.username = username;
        this.password = password;
        this.isActivated = isActivated;
        this.token = null;
        this.authorities = authorities;
        this.medicalRecord = medicalRecord;
        this.appointedTerms = appointedTerms;
    }

    public PatientDTO(Patient p){
        id=p.getId();
        name=p.getName();
        surname=p.getSurname();
        ucidn=p.getUcidn();
        address=p.getAddress();
        city=p.getCity();
        country=p.getCountry();
        email=p.getEmail();
        phone=p.getPhone();
        username=p.getUsername();
        password=p.getPassword();
        isActivated=p.isActivated();
        /*authorities = p.getAuthorities().stream()
                .map(authority -> ((Authority) authority).getName()).collect(Collectors.toList());*/
       // medicalRecord = p.getMedicalRecord();
       // appointedTerms = p.getAppointedTerms();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getUcidn() {
        return ucidn;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean isActivated() {
        return isActivated;
    }

    public UserTokenState getToken() {
        return token;
    }

    public MedicalRecord getMedicalRecord() {
        return medicalRecord;
    }

    public Set<ConsultTerm> getAppointedTerms() {
        return appointedTerms;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setUcidn(String ucidn) {
        this.ucidn = ucidn;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setActivated(boolean activated) {
        isActivated = activated;
    }

    public void setToken(UserTokenState token) {
        this.token = token;
    }

    public void setMedicalRecord(MedicalRecord medicalRecord) {
        this.medicalRecord = medicalRecord;
    }

    public void setAppointedTerms(Set<ConsultTerm> appointedTerms) {
        this.appointedTerms = appointedTerms;
    }

    public Set<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<Authority> authorities) {
        this.authorities = authorities;
    }
}
