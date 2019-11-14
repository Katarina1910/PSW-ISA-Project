package com.softwareComedians.ClinicalCenterApp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
public class ClinicAdministrator extends User {

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "clinicAdministrator")
	private Set<RequestForAbsence> requests;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Clinic clinic;

	public ClinicAdministrator() {

		super();
	}

	
}
