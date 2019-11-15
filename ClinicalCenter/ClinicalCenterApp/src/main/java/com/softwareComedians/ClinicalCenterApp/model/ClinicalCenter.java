package com.softwareComedians.ClinicalCenterApp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
public class ClinicalCenter {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String name;

	@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "clinicalCenter")
	private Set<Clinic> clinics;

	@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "clinicalCenter")
	private Set<ClinicCenterAdministrator> admins;

	@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "clinicalCenter")
	private Set<MedicalRecord> medicalRecords;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "clinicalcenter_id", referencedColumnName = "id")
	private DiagnosisCodebook diagnosisCodebook;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "clinicalcenter_idd", referencedColumnName = "id")
	private MedicamentCodeBook medicamentCodebook;

	public ClinicalCenter() {
		super();
	}


}
