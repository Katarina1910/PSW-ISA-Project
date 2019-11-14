package com.softwareComedians.ClinicalCenterApp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

//@Entity
@Getter
@Setter
public class MedicalRecord {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String historyDesease;

/*	//@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL,mappedBy = "medicalRecord")
	private Set<Consult> visitsToDoctor;

	//@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL,mappedBy = "medicalRecord")
	private Set<Operation> operations;

	//@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL,mappedBy = "medicalRecord")
	private Set<Recipe> recipes;

	//@ManyToMany(mappedBy = "diagAtMedRec")
	private Set<Diagnosis> diagnosis;

	//@ManyToMany(mappedBy = "MedPatient")
	private Set<Medicament> prescribedMedicaments;

	//@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private ClinicalCenter clinicalCenter;*/
	
	public MedicalRecord() {
		super();
	}


}
