package com.softwareComedians.ClinicalCenterApp.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
public class ConsultTerm extends RequstForConsult {
	@Column
	private String type;

	@Column
	private int duration;

	@Column
	private String price;

	@Column
	private String discount;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "consultTerm")
	private Set<Personnel> personnels;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Room room;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Clinic clinic;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Patient patient;

	
	public ConsultTerm() {
		super();
	}

	
}
