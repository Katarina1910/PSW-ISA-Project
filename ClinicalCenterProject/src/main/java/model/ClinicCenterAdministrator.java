package model;

import java.util.ArrayList;
import java.util.HashMap;

public class ClinicCenterAdministrator extends User{
	private ArrayList<RequestForPatientRegistration> requestedPatientsReg;
	private ArrayList<MedicalRecord> medicalRecords;
	private HashMap<String, String> diagnosisCodebook;
	private HashMap<String, String> medicamentCodebook;
	
	public ClinicCenterAdministrator() {
		super();
	}

	public ClinicCenterAdministrator(
			ArrayList<RequestForPatientRegistration> requestedPatientsReg, ArrayList<MedicalRecord> medicalRecords,
			HashMap<String, String> diagnosisCodebook, HashMap<String, String> medicamentCodebook) {
		super();
		
		this.requestedPatientsReg = requestedPatientsReg;
		this.medicalRecords = medicalRecords;
		this.diagnosisCodebook = diagnosisCodebook;
		this.medicamentCodebook = medicamentCodebook;
	}


	public ArrayList<RequestForPatientRegistration> getRequestedPatientsReg() {
		return requestedPatientsReg;
	}

	public void setRequestedPatientsReg(ArrayList<RequestForPatientRegistration> requestedPatientsReg) {
		this.requestedPatientsReg = requestedPatientsReg;
	}

	public ArrayList<MedicalRecord> getMedicalRecords() {
		return medicalRecords;
	}

	public void setMedicalRecords(ArrayList<MedicalRecord> medicalRecords) {
		this.medicalRecords = medicalRecords;
	}

	public HashMap<String, String> getDiagnosisCodebook() {
		return diagnosisCodebook;
	}

	public void setDiagnosisCodebook(HashMap<String, String> diagnosisCodebook) {
		this.diagnosisCodebook = diagnosisCodebook;
	}

	public HashMap<String, String> getMedicamentCodebook() {
		return medicamentCodebook;
	}

	public void setMedicamentCodebook(HashMap<String, String> medicamentCodebook) {
		this.medicamentCodebook = medicamentCodebook;
	}
	
	
}
