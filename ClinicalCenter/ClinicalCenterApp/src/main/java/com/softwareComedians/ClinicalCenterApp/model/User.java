package com.softwareComedians.ClinicalCenterApp.model;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

import static javax.persistence.InheritanceType.JOINED;

@Entity
@Inheritance(strategy=JOINED)
@Getter
@Setter
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String name;

	@Column
	private String surname;

	@Column
	private String ucidn;

	@Column
	private String address;

	@Column
	private String city;

	@Column
	private String country;

	@Column
	private String email;

	@Column
	private String phone;

	@Column
	private String userName;

	@Column
	private String password;

    @Column
    private boolean isActivated;

	@Column
    private  String role;



    @OneToMany(mappedBy = "applicant", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<RequestForConsult> requestForConsults;

	@OneToOne(mappedBy = "userData")
	private RequestForPatientRegistration requestForPatientRegistration;
	
	
	public User() {

	}

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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

    public Set<RequestForConsult> getRequestForConsults() {
        return requestForConsults;
    }

    public void setRequestForConsults(Set<RequestForConsult> requestForConsults) {
        this.requestForConsults = requestForConsults;
    }

    public RequestForPatientRegistration getRequestForPatientRegistration() {
        return requestForPatientRegistration;
    }

    public void setRequestForPatientRegistration(RequestForPatientRegistration requestForPatientRegistration) {
        this.requestForPatientRegistration = requestForPatientRegistration;
    }
}