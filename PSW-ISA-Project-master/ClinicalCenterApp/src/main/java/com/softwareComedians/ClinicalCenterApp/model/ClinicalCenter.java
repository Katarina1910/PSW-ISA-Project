package com.softwareComedians.ClinicalCenterApp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

//@Entity
@Getter
@Setter
public class ClinicalCenter {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String name;

	/*//@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL, mappedBy = "clinicalCenter")
	private Set<Clinic> clinics;

	//f@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL, mappedBy = "clinicalCenter")
	private Set<ClinicCenterAdministrator> admins;

	//@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL, mappedBy = "clinicalCenter")
	private Set<MedicalRecord> medicalRecords;

	//@OneToOne(mappedBy = "clinicalCenter")
	private DiagnosisCodebook diagnosisCodebook;

	//@OneToOne(mappedBy = "clinicalCenter")
	private MedicamentCodeBook medicamentCodebook;*/

	public ClinicalCenter() {
		super();
	}


}
