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

	@OneToMany(mappedBy = "applicant", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<RequstForConsult> requstForConsults;

	@OneToOne(mappedBy = "userData")
	private RequestForPatientRegistration requestForPatientRegistration;
	
	
	public User() {

	}

}