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

	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private Personnel applicant;

	@Column
	private boolean isAccepted;

	@Column
	private String resaonOfRejection;

	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private ClinicAdministrator clinicAdministrator;
	
	public RequestForAbsence() {
		super();
	}


	
}
