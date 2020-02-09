package com.softwareComedians.ClinicalCenterApp.model;

import com.softwareComedians.ClinicalCenterApp.dto.ClinicCenterAdminDTO;

import javax.persistence.*;


@Entity
public class ClinicCenterAdministrator extends User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	public ClinicCenterAdministrator() {
		super();
	}

	public ClinicCenterAdministrator(ClinicCenterAdminDTO cca){
		this.setId(cca.getId());
		this.setName(cca.getName());
		this.setSurname((cca.getSurname()));
		this.setUcidn(cca.getUcidn());
		this.setEmail(cca.getEmail());
		this.setUsername(cca.getUsername());
		this.setPhone(cca.getPhone());
		this.setAddress(cca.getAddress());
		this.setCity(cca.getCity());
		this.setCountry(cca.getCountry());
		this.setActivated(true);
		this.setPasswordChanged(false);
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}
}
