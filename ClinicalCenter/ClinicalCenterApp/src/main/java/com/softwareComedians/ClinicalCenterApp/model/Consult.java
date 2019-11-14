package com.softwareComedians.ClinicalCenterApp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Consult extends ConsultTerm {
	@Column
	private String report;

	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private MedicalRecord medicalRecord;

	public Consult(String report) {
		super();
		this.report = report;
	}


	
	

}
