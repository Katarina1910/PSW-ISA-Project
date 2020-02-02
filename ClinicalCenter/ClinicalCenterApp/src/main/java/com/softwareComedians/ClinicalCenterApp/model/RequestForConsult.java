package com.softwareComedians.ClinicalCenterApp.model;

import com.softwareComedians.ClinicalCenterApp.dto.RequestForConsultDTO;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Getter
@Setter
public class RequestForConsult {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private Date dateAndTime;

	@Column
	private boolean isAccepted;


	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private  ConsultType type;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "consultTerm_id", referencedColumnName = "id")
	@JsonManagedReference
	private  ConsultTerm consultTerm;


	//@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	//private User applicant;
	//doctor or patient, activated user

	//@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	//private ClinicAdministrator clinicAdministrator;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private User patient;

	public RequestForConsult(RequestForConsultDTO rq){
		this.setDateAndTime(rq.getDateAndTime());
		this.setType(new ConsultType(rq.getType().getId(),rq.getType().getName(),rq.getType().getDescription()));
		this.setAccepted(false);
		//this.setApplicant(new User(rq.getApplicant()));
		this.setPatient(new User(rq.getPatient()));
	}
	
	public RequestForConsult() {
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

	public ConsultType getType() {
		return type;
	}

	public void setType(ConsultType type) {
		this.type = type;
	}

	public User getPatient() {
		return patient;
	}

	public void setPatient(User patient) {
		this.patient = patient;
	}



	public ConsultTerm getConsultTerm() {
		return consultTerm;
	}

	public void setConsultTerm(ConsultTerm consultTerm) {
		this.consultTerm = consultTerm;
	}

}
