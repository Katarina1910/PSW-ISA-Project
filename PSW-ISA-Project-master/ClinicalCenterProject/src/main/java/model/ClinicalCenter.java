package model;

import java.util.ArrayList;
import java.util.HashMap;

public class ClinicalCenter {
	private ArrayList<Clinic> clinics;
	private ArrayList<ClinicCenterAdministrator> admins;
	private ArrayList<MedicalRecord> medicalRecords;
	private HashMap<String, String> diagnosisCodebook;
	private HashMap<String, String> medicamentCodebook;

	public ClinicalCenter() {
		super();
	}
	
	public ClinicalCenter(ArrayList<Clinic> clinics, ArrayList<ClinicCenterAdministrator> admins,
			ArrayList<MedicalRecord> medicalRecords, HashMap<String, String> diagnosisCodebook,
			HashMap<String, String> medicamentCodebook) {
		super();
		this.clinics = clinics;
		this.admins = admins;
		this.medicalRecords = medicalRecords;
		this.diagnosisCodebook = diagnosisCodebook;
		this.medicamentCodebook = medicamentCodebook;
	}


	public ArrayList<ClinicCenterAdministrator> getAdmins() {
		return admins;
	}

	public void setAdmins(ArrayList<ClinicCenterAdministrator> admins) {
		this.admins = admins;
	}

	public HashMap<String, String> getDiagnosisCodebook() {
		return diagnosisCodebook;
	}

	public void setDiagnosisCodebook(HashMap<String, String> diagnosisCodebook) {
		this.diagnosisCodebook = diagnosisCodebook;
	}

	public ArrayList<MedicalRecord> getMedicalRecords() {
		return medicalRecords;
	}



	public void setMedicalRecords(ArrayList<MedicalRecord> medicalRecords) {
		this.medicalRecords = medicalRecords;
	}



	public HashMap<String, String> getMedicamentCodebook() {
		return medicamentCodebook;
	}



	public void setMedicamentCodebook(HashMap<String, String> medicamentCodebook) {
		this.medicamentCodebook = medicamentCodebook;
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
