package com.softwareComedians.ClinicalCenterApp.model;

import javax.persistence.*;
import java.util.Set;


@Entity
public class ClinicCenterAdministrator extends User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;



	public ClinicCenterAdministrator() {
		super();
	}

}
