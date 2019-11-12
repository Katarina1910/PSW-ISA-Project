package model;

import javax.persistence.*;
import java.util.Set;

import static javax.persistence.InheritanceType.JOINED;

@Entity
@Table
@Inheritance(strategy=JOINED)
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

	@OneToMany(mappedBy = "applicant", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<RequstForConsult> requstForConsults;

	@OneToOne(mappedBy = "userData")
	private RequestForPatientRegistration requestForPatientRegistration;
	
	
	public User() {
		super();
	}


	public User(String name, String surname, String ucidn, String address, String city, String country, String email,
			String phone, String userName, String password, boolean isActivated) {
		super();
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


	public void setActivated(boolean isActivated) {
		this.isActivated = isActivated;
	}
	
	
}