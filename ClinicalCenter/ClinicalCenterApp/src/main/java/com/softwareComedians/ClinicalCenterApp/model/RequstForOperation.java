package com.softwareComedians.ClinicalCenterApp.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.InheritanceType.JOINED;

@Entity
@Inheritance(strategy=JOINED)
@Getter
@Setter
public class RequstForOperation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String dateAndTime;

	@Column
	private boolean isAccepted;


	@ManyToOne(fetch = FetchType.EAGER)
	private User patient;

	@OneToOne(fetch =FetchType.LAZY)
	@JoinColumn(name = "operation_id", referencedColumnName = "id")
	@JsonManagedReference
	private  Operation operation;

	
	public RequstForOperation() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDateAndTime() {
		return dateAndTime;
	}

	public void setDateAndTime(String dateAndTime) {
		this.dateAndTime = dateAndTime;
	}

	public boolean isAccepted() {
		return isAccepted;
	}

	public void setAccepted(boolean accepted) {
		isAccepted = accepted;
	}


	public User getPatient() {
		return patient;
	}

	public void setPatient(User patient) {
		this.patient = patient;
	}
}
