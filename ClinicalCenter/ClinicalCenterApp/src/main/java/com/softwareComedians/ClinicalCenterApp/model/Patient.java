package com.softwareComedians.ClinicalCenterApp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

//@Entity
@Getter
@Setter
public class Patient extends RequestForPatientRegistration {
	//preuzmi userata iz requesta
	private MedicalRecord medicalRecord;

	//@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "patient")
	//private Set<ConsultTerm> appointedTerms;

	//@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	//private Clinic clinic;

//	@ManyToMany
//	@JoinTable(name = "PersonnelPatient", joinColumns = @JoinColumn(name = "pat_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "presonnel_id", referencedColumnName = "id"))
	//private Set<Personnel> personnels;
	
	public Patient() {
		super();
	}

	
}
