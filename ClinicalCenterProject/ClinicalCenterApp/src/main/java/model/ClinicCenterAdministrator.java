package model;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
public class ClinicCenterAdministrator extends User {

	@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private ClinicalCenter clinicalCenter;

	@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL, mappedBy = "clinicCenterAdministrator")
	private ArrayList<RequestForPatientRegistration> requestedPatientsReg;

	
	public ClinicCenterAdministrator() {
		super();
	}


	public ArrayList<RequestForPatientRegistration> getRequestedPatientsReg() {
		return requestedPatientsReg;
	}

	public void setRequestedPatientsReg(ArrayList<RequestForPatientRegistration> requestedPatientsReg) {
		this.requestedPatientsReg = requestedPatientsReg;
	}

	public ClinicalCenter getClinicalCenter() {
		return clinicalCenter;
	}

	public void setClinicalCenter(ClinicalCenter clinicalCenter) {
		this.clinicalCenter = clinicalCenter;
	}
}
