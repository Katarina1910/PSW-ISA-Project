package com.softwareComedians.ClinicalCenterApp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.InheritanceType.JOINED;

@Entity
@Inheritance(strategy=JOINED)
@Getter
@Setter
public class RequestForPatientRegistration {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;


	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "userData_id", referencedColumnName = "id")
	private User userData;

	@Column
	private boolean isAccepted;

	@Column
	private String reasonOfRejection;

	@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private ClinicCenterAdministrator clinicCenterAdministrator;

	public RequestForPatientRegistration() {
		super();
	}
	
}
