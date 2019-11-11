package model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Set;

@Entity
public class MedicalRecord {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String historyDesease;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL,mappedBy = "medicalRecord")
	private Set<Consult> visitsToDoctor;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL,mappedBy = "medicalRecord")
	private Set<Operation> operations;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL,mappedBy = "medicalRecord")
	private Set<Recipe> recipes;

	@ManyToMany(mappedBy = "diagAtMedRec")
	private Set<Diagnosis> diagnosis;

	@ManyToMany(mappedBy = "MedPatient")
	private Set<Medicament> prescribedMedicaments;

	@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private ClinicalCenter clinicalCenter;
	
	public MedicalRecord() {
		super();
	}

	public String getHistoryDesease() {
		return historyDesease;
	}

	public void setHistoryDesease(String historyDesease) {
		this.historyDesease = historyDesease;
	}

	public Set<Consult> getVisitsToDoctor() {
		return visitsToDoctor;
	}

	public void setVisitsToDoctor(Set<Consult> visitsToDoctor) {
		this.visitsToDoctor = visitsToDoctor;
	}

	public Set<Operation> getOperations() {
		return operations;
	}

	public void setOperations(Set<Operation> operations) {
		this.operations = operations;
	}

	public Set<Recipe> getRecipes() {
		return recipes;
	}

	public void setRecipes(Set<Recipe> recipes) {
		this.recipes = recipes;
	}

	public Set<Diagnosis> getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(Set<Diagnosis> diagnosis) {
		this.diagnosis = diagnosis;
	}

	public Set<Medicament> getPrescribedMedicaments() {
		return prescribedMedicaments;
	}

	public void setPrescribedMedicaments(Set<Medicament> prescribedMedicaments) {
		this.prescribedMedicaments = prescribedMedicaments;
	}

	public ClinicalCenter getClinicalCenter() {
		return clinicalCenter;
	}

	public void setClinicalCenter(ClinicalCenter clinicalCenter) {
		this.clinicalCenter = clinicalCenter;
	}
}
