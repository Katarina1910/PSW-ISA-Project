package model;

import java.util.ArrayList;

public class ClinicAdministrator extends User {
	private ArrayList<RequestForAbsence> requests;

	public ClinicAdministrator() {
		super();
	}

	public ClinicAdministrator(ArrayList<RequestForAbsence> requests) {
		super();
		this.requests = requests;
	}

	public ArrayList<RequestForAbsence> getRequests() {
		return requests;
	}

	public void setRequests(ArrayList<RequestForAbsence> requests) {
		this.requests = requests;
	}
	
	
}
