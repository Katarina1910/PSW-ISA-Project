package com.softwareComedians.ClinicalCenterApp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

import static javax.persistence.InheritanceType.JOINED;

//@Entity
@Inheritance(strategy=JOINED)
@Getter
@Setter
public class RequstForOperation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	//@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	//private Doctor applicant;

	@Column
	private Date dateAndTime;

	@Column
	private boolean isApproved;
	
	public RequstForOperation() {
		super();
	}


	
}
