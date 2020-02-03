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
	private Date too;

	@Column
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date froom;

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

	public Date getToo() {
		return too;
	}

	public void setToo(Date too) {
		this.too = too;
	}

	public Date getFroom() {
		return froom;
	}

	public void setFroom(Date froom) {
		this.froom = froom;
	}

	public ClinicAdministrator getClinicAdministrator() {
		return clinicAdministrator;
	}

	public void setClinicAdministrator(ClinicAdministrator clinicAdministrator) {
		this.clinicAdministrator = clinicAdministrator;
	}
}