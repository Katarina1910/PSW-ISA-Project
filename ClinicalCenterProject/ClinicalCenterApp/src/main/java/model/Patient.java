package model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Set;

@Entity
public class Patient extends RequestForPatientRegistration {
	//preuzmi userata iz requesta
	private MedicalRecord medicalRecord;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "patient")
	private Set<ConsultTerm> appointedTerms;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Clinic clinic;

	@ManyToMany
	@JoinTable(name = "PersonnelPatient", joinColumns = @JoinColumn(name = "pat_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "presonnel_id", referencedColumnName = "id"))
	private Set<Personnel> personnels;
	
	public Patient() {
		super();
	}

	public Patient(MedicalRecord medicalRecord, Set<ConsultTerm> appointedTerms) {
		super();
		this.medicalRecord = medicalRecord;
		this.appointedTerms = appointedTerms;
	}

	public MedicalRecord getMedicalRecord() {
		return medicalRecord;
	}

	public void setMedicalRecord(MedicalRecord medicalRecord) {
		this.medicalRecord = medicalRecord;
	}

	public Set<ConsultTerm> getAppointedTerms() {
		return appointedTerms;
	}

	public void setAppointedTerms(Set<ConsultTerm> appointedTerms) {
		this.appointedTerms = appointedTerms;
	}
	
	
}
