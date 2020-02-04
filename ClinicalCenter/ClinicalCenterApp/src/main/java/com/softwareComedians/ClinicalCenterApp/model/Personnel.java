package com.softwareComedians.ClinicalCenterApp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
public abstract class Personnel extends User {

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Clinic clinic;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private ConsultTerm consultTerm;

	@OneToMany(mappedBy = "applicant", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private Set<RequestForAbsence> requestForAbsences;
	
	public Personnel() {
		super();
	}

	public Clinic getClinic() {
		return clinic;
	}

	public void setClinic(Clinic clinic) {
		this.clinic = clinic;
	}

	public ConsultTerm getConsultTerm() {
		return consultTerm;
	}

	public void setConsultTerm(ConsultTerm consultTerm) {
		this.consultTerm = consultTerm;
	}

	public Set<RequestForAbsence> getRequestForAbsences() {
		return requestForAbsences;
	}

	public void setRequestForAbsences(Set<RequestForAbsence> requestForAbsences) {
		this.requestForAbsences = requestForAbsences;
	}
}
