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


	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "consultTerm_id", referencedColumnName = "id")
	private ConsultTerm consultTerm;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
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

	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private MedicalRecord medicalRecord;

	public Consult(String report) {
		super();
		this.report = report;
	}


	public Consult() {
	}
}
