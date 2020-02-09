package com.softwareComedians.ClinicalCenterApp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Operation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;


	@ManyToOne( fetch = FetchType.LAZY)
	private Room room;

	@ManyToOne(fetch = FetchType.LAZY)
	private MedicalRecord medicalRecord;

	@OneToOne(mappedBy = "operation")
	@JsonBackReference
	private RequstForOperation requstForOperation;

	@ManyToOne(fetch = FetchType.LAZY)
	private Doctor doctor;
	
	public Operation() {
		super();
	}

	public Room getRoom() {
		return room;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public MedicalRecord getMedicalRecord() {
		return medicalRecord;
	}

	public void setMedicalRecord(MedicalRecord medicalRecord) {
		this.medicalRecord = medicalRecord;
	}

	public RequstForOperation getRequstForOperation() {
		return requstForOperation;
	}

	public void setRequstForOperation(RequstForOperation requstForOperation) {
		this.requstForOperation = requstForOperation;
	}
}
