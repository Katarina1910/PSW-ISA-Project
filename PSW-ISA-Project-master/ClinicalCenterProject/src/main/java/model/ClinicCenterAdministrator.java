package model;

import java.util.ArrayList;

public class ClinicCenterAdministrator extends User{
	private ArrayList<RequestForPatientRegistration> requestedPatientsReg;

	
	public ClinicCenterAdministrator() {
		super();
	}

	public ClinicCenterAdministrator(
			ArrayList<RequestForPatientRegistration> requestedPatientsReg) {
		super();
		
		this.requestedPatientsReg = requestedPatientsReg;
	}


	public ArrayList<RequestForPatientRegistration> getRequestedPatientsReg() {
		return requestedPatientsReg;
	}

	public void setRequestedPatientsReg(ArrayList<RequestForPatientRegistration> requestedPatientsReg) {
		this.requestedPatientsReg = requestedPatientsReg;
	}

	
}
