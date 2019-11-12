package model;

import java.util.ArrayList;

public abstract class Personnel extends User {
	
	private Clinic clinic;
	private ArrayList<Patient> myPatients;
	
	public Personnel() {
		super();
	}

	public Personnel(Clinic clinic, ArrayList<Patient> myPatients) {
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

	public ArrayList<Patient> getMyPatients() {
		return myPatients;
	}

	public void setMyPatients(ArrayList<Patient> myPatients) {
		this.myPatients = myPatients;
	}
	
	
	
}
