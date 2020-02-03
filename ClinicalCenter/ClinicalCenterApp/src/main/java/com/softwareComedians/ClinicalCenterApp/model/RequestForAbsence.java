package com.softwareComedians.ClinicalCenterApp.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
public class RequestForAbsence {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private Personnel applicant;

	@Column
	private boolean isAccepted;

	@Column
	private String resaonOfRejection;

	@Column
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date from;

	@Column
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date to;

	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private ClinicAdministrator clinicAdministrator;
	
	public RequestForAbsence() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Personnel getApplicant() {
		return applicant;
	}

	public void setApplicant(Personnel applicant) {
		this.applicant = applicant;
	}

	public boolean isAccepted() {
		return isAccepted;
	}

	public void setAccepted(boolean accepted) {
		isAccepted = accepted;
	}

	public String getResaonOfRejection() {
		return resaonOfRejection;
	}

	public void setResaonOfRejection(String resaonOfRejection) {
		this.resaonOfRejection = resaonOfRejection;
	}

	public Date getFrom() {
		return from;
	}

	public void setFrom(Date from) {
		this.from = from;
	}

	public Date getTo() {
		return to;
	}

	public void setTo(Date to) {
		this.to = to;
	}

	public ClinicAdministrator getClinicAdministrator() {
		return clinicAdministrator;
	}

	public void setClinicAdministrator(ClinicAdministrator clinicAdministrator) {
		this.clinicAdministrator = clinicAdministrator;
	}
}
