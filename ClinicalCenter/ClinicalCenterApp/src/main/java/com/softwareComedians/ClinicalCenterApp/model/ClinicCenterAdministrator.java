package com.softwareComedians.ClinicalCenterApp.model;

import javax.persistence.*;
import java.util.Set;


@Entity
public class ClinicCenterAdministrator extends User {

	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private ClinicalCenter clinicalCenter;

	@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "clinicCenterAdministrator")
	private Set<RequestForPatientRegistration> requestedPatientsReg;

	
	public ClinicCenterAdministrator() {
		super();
	}

}
