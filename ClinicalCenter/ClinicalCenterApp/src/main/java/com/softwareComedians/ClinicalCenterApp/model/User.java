package com.softwareComedians.ClinicalCenterApp.model;
import lombok.Getter;
import lombok.Setter;
import org.joda.time.DateTime;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import static javax.persistence.InheritanceType.JOINED;

@Entity
@Inheritance(strategy=JOINED)
@Getter
@Setter
public class User implements UserDetails {

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
	private String username;

	@Column
	private String password;

    @Column
    private boolean isActivated;

	@Column
    private  String role;

    @Column(name = "last_password_reset_date")
    private Timestamp lastPasswordResetDate;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_authority",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "authority_id", referencedColumnName = "id"))
    private Set<Authority> authorities = new HashSet<>();

    @OneToMany(mappedBy = "applicant", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<RequestForConsult> requestForConsults;

	@OneToOne(mappedBy = "userData")
	private RequestForPatientRegistration requestForPatientRegistration;


	public User() {

	}

    public User(Long id, String name, String surname, String ucidn, String address, String city, String country, String email, String phone, String username, String password, boolean isActivated) {
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

    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return isActivated;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
	    Timestamp now = new Timestamp(DateTime.now().getMillis());
        this.setLastPasswordResetDate( now );
        this.password = password;
    }

    public boolean isActivated() {
        return isActivated;
    }

    public void setActivated(boolean activated) {
        isActivated = activated;
    }

    public boolean getAccepted() {
	    return isActivated;
    }

    public void setAuthorities(Set<Authority> authorities) {
        this.authorities = authorities;
    }

    public Set<Authority> getUsersAuthorities() {
        return this.authorities;
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

    public String getRole() {
	    return role;
    }

    public Timestamp getLastPasswordResetDate() {
        return lastPasswordResetDate;
    }

    public void setLastPasswordResetDate(Timestamp lastPasswordResetDate) {
        this.lastPasswordResetDate = lastPasswordResetDate;
    }

}