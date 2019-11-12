package model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Set;

@Entity
public abstract class Personnel extends User {

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Clinic clinic;

	@ManyToMany(mappedBy = "PersonnelPatient")
	private Set<Patient> myPatients;

	@OneToMany(mappedBy = "applicant", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private Set<RequestForAbsence> requestForAbsences;
	
	public Personnel() {
		super();
	}

	public Personnel(Clinic clinic, Set<Patient> myPatients) {
		super();
		this.clinic = clinic;
		this.myPatients = myPatients;
	}

	public Clinic getClinic() {
		return clinic;
	}

	public void setClinic(Clinic clinic) {
		this.clinic = clinic;
	}

	public Set<Patient> getMyPatients() {
		return myPatients;
	}

	public void setMyPatients(Set<Patient> myPatients) {
		this.myPatients = myPatients;
	}
	
	
	
}
