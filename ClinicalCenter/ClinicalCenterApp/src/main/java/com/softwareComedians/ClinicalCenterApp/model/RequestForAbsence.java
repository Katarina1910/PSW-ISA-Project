package com.softwareComedians.ClinicalCenterApp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class RequestForAbsence {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	private Personnel applicant;

	@Column
	private boolean isAccepted;

	@Column
	private String resaonOfRejection;


	@Column
	private String too;

	@Column
	private String froom;

	@ManyToOne(fetch = FetchType.LAZY)
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

	public Personnel getApplicant() {
		return applicant;
	}

	public void setApplicant(Personnel applicant) {
		this.applicant = applicant;
	}

	public String getToo() {
		return too;
	}

	public void setToo(String too) {
		this.too = too;
	}

	public String getFroom() {
		return froom;
	}

	public void setFroom(String froom) {
		this.froom = froom;
	}

	public ClinicAdministrator getClinicAdministrator() {
		return clinicAdministrator;
	}

	public void setClinicAdministrator(ClinicAdministrator clinicAdministrator) {
		this.clinicAdministrator = clinicAdministrator;
	}
}