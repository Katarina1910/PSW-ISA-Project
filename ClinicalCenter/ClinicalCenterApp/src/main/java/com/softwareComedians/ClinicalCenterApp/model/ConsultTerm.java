package com.softwareComedians.ClinicalCenterApp.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

//@Entity
@Getter
@Setter
public class ConsultTerm extends RequstForConsult {
	@Column
	private String type;

	@Column
	private int duration;

	@Column
	private Doctor doctor;

	@Column
	private Nurse nurse;

	@Column
	private String price;

	@Column
	private String discount;

	@Column
	private Room room;

	//@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//	private Clinic clinic;

	//@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	//private Patient patient;

	
	public ConsultTerm() {
		super();
	}

	
}
