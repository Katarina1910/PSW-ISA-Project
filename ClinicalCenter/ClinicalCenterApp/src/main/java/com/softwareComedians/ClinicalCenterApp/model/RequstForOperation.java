package com.softwareComedians.ClinicalCenterApp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

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
	private Date dateAndTime;

	@Column
	private boolean isAccepted;


	//@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	//private Doctor applicant;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private User patient;

	
	public RequstForOperation() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDateAndTime() {
		return dateAndTime;
	}

	public void setDateAndTime(Date dateAndTime) {
		this.dateAndTime = dateAndTime;
	}

	public boolean isAccepted() {
		return isAccepted;
	}

	public void setAccepted(boolean accepted) {
		isAccepted = accepted;
	}

	/*public Doctor getApplicant() {
		return applicant;
	}

	public void setApplicant(Doctor applicant) {
		this.applicant = applicant;
	}*/

	public User getPatient() {
		return patient;
	}

	public void setPatient(User patient) {
		this.patient = patient;
	}
}
