package com.softwareComedians.ClinicalCenterApp.model;

import com.softwareComedians.ClinicalCenterApp.dto.ClinicAdminDTO;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
public class ClinicAdministrator extends User {

	@Autowired
	@Transient
	private PasswordEncoder passwordEncoder;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "clinicAdministrator")
	private Set<RequestForAbsence> requests;

	//@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "clinicAdministrator")
	//private Set<RequestForConsult> requestForConsultSet;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Clinic clinic;

	//public Set<RequestForConsult> getRequestForConsultSet() {
	//	return requestForConsultSet;
	//}

	//public void setRequestForConsultSet(Set<RequestForConsult> requestForConsultSet) {
	//	this.requestForConsultSet = requestForConsultSet;
	//}

	public ClinicAdministrator(ClinicAdminDTO ca){
		this.setId(ca.getId());
		this.setName(ca.getName());
		this.setSurname((ca.getSurname()));
		this.setUcidn(ca.getUcidn());
		this.setEmail(ca.getEmail());
		this.setPassword(passwordEncoder.encode(ca.getPassword()));
		this.setUsername(ca.getUsername());
		this.setPhone(ca.getPhone());
		this.setAddress(ca.getAddress());
		this.setCity(ca.getCity());
		this.setCountry(ca.getCountry());
		this.setActivated(ca.isActivated());
		//for (RequestForConsultDTO r : ca.getRequestForConsultDTOS()){
			//this.requestForConsultSet.add(new RequestForConsult(r));
		//}
	}

	public ClinicAdministrator() {
		super();
	}

	public Clinic getClinic() {
		return clinic;
	}

	public void setClinic(Clinic clinic) {
		this.clinic = clinic;
	}
}
