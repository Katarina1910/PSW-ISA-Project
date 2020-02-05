package com.softwareComedians.ClinicalCenterApp.model;

import com.softwareComedians.ClinicalCenterApp.dto.PatientDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
public class Patient extends User {
	//preuzmi user data iz requesta
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "medicalRecord", referencedColumnName = "id")
	private MedicalRecord medicalRecord;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "patient")
	private Set<ConsultTerm> appointedTerms;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Clinic clinic;

//	@ManyToMany
//	@JoinTable(name = "PersonnelPatient", joinColumns = @JoinColumn(name = "pat_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "presonnel_id", referencedColumnName = "id"))
	//private Set<Personnel> personnels;
	
	public Patient() {
		super();
	}

	public Patient(User u){
		super(u.getId(),u.getName(),u.getSurname(),u.getUcidn(),u.getAddress(), u.getCity(),
				u.getCountry(), u.getEmail(), u.getPhone(), u.getUsername(), u.getPassword(), u.isActivated());
	}

	public  Patient(PatientDTO p){
		super(p.getId(),p.getName(),p.getSurname(),p.getUcidn(),p.getAddress(), p.getCity(),
				p.getCountry(), p.getEmail(), p.getPhone(), p.getUsername(), p.getPassword(), p.isActivated());
	}

	public Clinic getClinic() {
		return clinic;
	}

	public void setClinic(Clinic clinic) {
		this.clinic = clinic;
	}
}
