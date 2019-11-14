package com.softwareComedians.ClinicalCenterApp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

//@Entity
@Getter
@Setter
public class Operation extends RequstForOperation {
//	@ManyToMany(mappedBy = "DocOp")
//	private Set<Doctor> doctors;

	@Column
	private Room room;

//	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	//private MedicalRecord medicalRecord;
	
	public Operation() {
		super();
	}


	
}
