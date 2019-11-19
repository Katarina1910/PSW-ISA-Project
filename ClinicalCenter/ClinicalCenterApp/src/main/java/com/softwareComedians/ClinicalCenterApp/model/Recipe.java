package com.softwareComedians.ClinicalCenterApp.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Recipe {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Nurse nurse;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "medicament_id", referencedColumnName = "id")
	private Medicament medicament;

	@Column
	private boolean isValidated;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private MedicalRecord medicalRecord;
	
	public Recipe() {
		super();
	}


}
