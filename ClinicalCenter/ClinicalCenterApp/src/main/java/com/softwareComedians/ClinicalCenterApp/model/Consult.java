package com.softwareComedians.ClinicalCenterApp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Consult{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;


	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "consultTerm_id", referencedColumnName = "id")
	private ConsultTerm consultTerm;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "recipe_id", referencedColumnName = "id")
	public Recipe recipe;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "nurse_id", referencedColumnName = "id")
	public Nurse nurse;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "diagnosis_id", referencedColumnName = "id")
	public Diagnosis diagnosis;

	@Column
	private String report;

	@ManyToOne(fetch = FetchType.LAZY)
	private MedicalRecord medicalRecord;

	public Consult(String report) {
		super();
		this.report = report;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ConsultTerm getConsultTerm() {
		return consultTerm;
	}

	public void setConsultTerm(ConsultTerm consultTerm) {
		this.consultTerm = consultTerm;
	}

	public Recipe getRecipe() {
		return recipe;
	}

	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}

	public Nurse getNurse() {
		return nurse;
	}

	public void setNurse(Nurse nurse) {
		this.nurse = nurse;
	}

	public Diagnosis getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(Diagnosis diagnosis) {
		this.diagnosis = diagnosis;
	}

	public String getReport() {
		return report;
	}

	public void setReport(String report) {
		this.report = report;
	}

	public MedicalRecord getMedicalRecord() {
		return medicalRecord;
	}

	public void setMedicalRecord(MedicalRecord medicalRecord) {
		this.medicalRecord = medicalRecord;
	}

	public Consult() {
	}
}
