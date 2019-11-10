package model;

import java.util.ArrayList;

public class ClinicalCenter {
	private ArrayList<Clinic> clinics;
	private ArrayList<ClinicCenterAdministrator> admins;
	private ArrayList<MedicalRecord> medicalRecords;
	private ArrayList<Diagnosis> diagnosisCodebook;
	private ArrayList<Medicament> medicamentCodebook;

	public ClinicalCenter() {
		super();
	}
	
	public ClinicalCenter(ArrayList<Clinic> clinics, ArrayList<ClinicCenterAdministrator> admins,
                          ArrayList<MedicalRecord> medicalRecords, ArrayList<Diagnosis> diagnosisCodebook,
                          ArrayList<Medicament> medicamentCodebook) {
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

	public ArrayList<Diagnosis> getDiagnosisCodebook() {
		return diagnosisCodebook;
	}

	public void setDiagnosisCodebook(ArrayList<Diagnosis> diagnosisCodebook) {
		this.diagnosisCodebook = diagnosisCodebook;
	}

	public ArrayList<MedicalRecord> getMedicalRecords() {
		return medicalRecords;
	}



	public void setMedicalRecords(ArrayList<MedicalRecord> medicalRecords) {
		this.medicalRecords = medicalRecords;
	}



	public ArrayList<Medicament> getMedicamentCodebook() {
		return medicamentCodebook;
	}



	public void setMedicamentCodebook(ArrayList<Medicament> medicamentCodebook) {
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
