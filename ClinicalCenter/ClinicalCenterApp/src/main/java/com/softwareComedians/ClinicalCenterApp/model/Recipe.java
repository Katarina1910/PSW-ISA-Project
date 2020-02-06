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

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Nurse nurse;

	@OneToOne(mappedBy = "recipe")
	public ConsultTerm consultTerm;

	@ManyToMany
	@JoinTable(
			name = "recipe_medicament",
			joinColumns = @JoinColumn(name = "recipe_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "medicament_id", referencedColumnName = "id")
	)
	public Set<Medicament> medicaments;

	@Column
	private boolean isValidated;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "doctor_id", referencedColumnName = "id")
	public Doctor doctor;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private MedicalRecord medicalRecord;
	
	public Recipe() {
		super();
	}


}
