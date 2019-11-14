package com.softwareComedians.ClinicalCenterApp.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

//@Entity
@Getter
@Setter
public class Recipe {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

//	@Column
//	private Nurse nurse;

	//@Column
	//private Medicament medicament;

	@Column
	private boolean isValidated;

	//@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//	private MedicalRecord medicalRecord;
	
	public Recipe() {
		super();
	}


}
