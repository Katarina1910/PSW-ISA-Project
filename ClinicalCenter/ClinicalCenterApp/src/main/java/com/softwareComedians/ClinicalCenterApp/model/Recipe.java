package com.softwareComedians.ClinicalCenterApp.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
public class Recipe {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	private Nurse nurse;


	@ManyToMany
	@JoinTable(
			name = "recipe_medicament",
			joinColumns = @JoinColumn(name = "recipe_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "medicament_id", referencedColumnName = "id")
	)
	public Set<Medicament> medicaments;

	@OneToOne(mappedBy = "recipe")
	public Consult consults;

	@Column
	private boolean isValidated;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "doctor_id", referencedColumnName = "id")
	public Doctor doctor;

	@ManyToOne(fetch = FetchType.LAZY)
	private MedicalRecord medicalRecord;
	
	public Recipe() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public Nurse getNurse() {
		return nurse;
	}

	public void setNurse(Nurse nurse) {
		this.nurse = nurse;
	}

	public Set<Medicament> getMedicaments() {
		return medicaments;
	}

	public void setMedicaments(Set<Medicament> medicaments) {
		this.medicaments = medicaments;
	}

	public Consult getConsults() {
		return consults;
	}

	public void setConsults(Consult consults) {
		this.consults = consults;
	}

	public boolean isValidated() {
		return isValidated;
	}

	public void setValidated(boolean validated) {
		isValidated = validated;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public MedicalRecord getMedicalRecord() {
		return medicalRecord;
	}

	public void setMedicalRecord(MedicalRecord medicalRecord) {
		this.medicalRecord = medicalRecord;
	}
}
