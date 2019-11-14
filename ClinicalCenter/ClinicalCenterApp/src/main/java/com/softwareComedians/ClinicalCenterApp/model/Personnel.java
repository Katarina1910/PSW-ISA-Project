package com.softwareComedians.ClinicalCenterApp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

//@Entity
@Getter
@Setter
public abstract class Personnel extends User {

	//@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	//private Clinic clinic;

	//@ManyToMany(mappedBy = "PersonnelPatient")
//	private Set<Patient> myPatients;

	//@OneToMany(mappedBy = "applicant", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
//	private Set<RequestForAbsence> requestForAbsences;
	
	public Personnel() {
		super();
	}


	
	
}
