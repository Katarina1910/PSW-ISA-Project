package com.softwareComedians.ClinicalCenterApp.model;

import com.softwareComedians.ClinicalCenterApp.dto.MedicalRecordDTO;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "medicalRecord")
	private Set<Consult> visitsToDoctor;

	@OneToMany(fetch = FetchType.LAZY,mappedBy = "medicalRecord")
	private Set<Operation> operations;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "medicalRecord")
	private Set<Recipe> recipes;

	@OneToMany(mappedBy = "medicalRecord", fetch = FetchType.LAZY)
	public Set<Consult> consults;



	public  MedicalRecord(MedicalRecordDTO mr){
		this.id = mr.getId();
		this.height = mr.getHeight();
		this.weight = mr.getWeight();
		this.bloodType = mr.getBloodType();
		this.diopter = mr.getDiopter();
		this.alergies = mr.getAlergies();
		this.historyDisease = mr.getHistoryDisease();
		this.patient = new Patient(mr.getPatient());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getBloodType() {
		return bloodType;
	}

	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}

	public String getDiopter() {
		return diopter;
	}

	public void setDiopter(String diopter) {
		this.diopter = diopter;
	}

	public String getAlergies() {
		return alergies;
	}

	public void setAlergies(String alergies) {
		this.alergies = alergies;
	}

	public String getHistoryDisease() {
		return historyDisease;
	}

	public void setHistoryDisease(String historyDisease) {
		this.historyDisease = historyDisease;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
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

	public Set<Consult> getConsults() {
		return consults;
	}

	public void setConsults(Set<Consult> consults) {
		this.consults = consults;
	}
}
