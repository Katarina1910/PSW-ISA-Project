package com.softwareComedians.ClinicalCenterApp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Consult{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;


	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "consultTerm_id", referencedColumnName = "id")
	private ConsultTerm consultTerm;

	@Column
	private String report;

	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private MedicalRecord medicalRecord;

	public Consult(String report) {
		super();
		this.report = report;
	}


	
	

}
