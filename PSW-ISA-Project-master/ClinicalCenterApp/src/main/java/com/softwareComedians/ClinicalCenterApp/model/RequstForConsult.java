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
public class RequstForConsult {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	//@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	//private User applicant;
	//doctor or patient, activated user
	@Column
	private Date dateAndTime;

	@Column
	private boolean isAccepted;
	
	public RequstForConsult() {
		super();
	}


	
}
