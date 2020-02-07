package com.softwareComedians.ClinicalCenterApp.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MedicalRecord {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String height;

	@Column
	private String weight;

	@Column
	private String bloodType;

	@Column
	private String diopter;

	@Column
	private String alergies;

	@Column
	private String historyDisease;

	@OneToOne(mappedBy = "medicalRecord")
	private Patient patient;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL,mappedBy = "medicalRecord")
	private Set<Consult> visitsToDoctor;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL,mappedBy = "medicalRecord")
	private Set<Operation> operations;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL,mappedBy = "medicalRecord")
	private Set<Recipe> recipes;

	@OneToMany(mappedBy = "medicalRecord", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	public Set<Consult> consults;

	/*//@ManyToMany(mappedBy = "diagAtMedRec")
	private Set<Diagnosis> diagnosis;

	//@ManyToMany(mappedBy = "MedPatient")
	private Set<Medicament> prescribedMedicaments;*/
}
