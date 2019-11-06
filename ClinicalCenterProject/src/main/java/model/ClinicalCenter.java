package model;

import java.util.ArrayList;

public class ClinicalCenter {
	private ArrayList<Clinic> clinics;
	private ArrayList<ClinicCenterAdministrator> admins;

	public ClinicalCenter() {
		super();
	}

	public ArrayList<Clinic> getClinics() {
		return clinics;
	}

	public void setClinics(ArrayList<Clinic> clinics) {
		this.clinics = clinics;
	}

	public ClinicalCenter(ArrayList<Clinic> clinics) {
		super();
		this.clinics = clinics;
	}
	
}
