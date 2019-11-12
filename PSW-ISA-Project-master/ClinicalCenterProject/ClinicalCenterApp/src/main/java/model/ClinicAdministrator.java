package model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Set;

@Entity
public class ClinicAdministrator extends User {

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "clinicAdministrator")
	private Set<RequestForAbsence> requests;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Clinic clinic;

	public ClinicAdministrator() {

		super();
	}

	public ClinicAdministrator(Set<RequestForAbsence> requests) {
		super();
		this.requests = requests;
	}

	public Clinic getClinic() {
		return clinic;
	}

	public void setClinic(Clinic clinic) {
		this.clinic = clinic;
	}

	public Set<RequestForAbsence> getRequests() {
		return requests;
	}

	public void setRequests(Set<RequestForAbsence> requests) {
		this.requests = requests;
	}
	
	
}
