package model;

import java.util.ArrayList;

public class Patient extends RequestForPatientRegistration {
	//preuzmi userata iz requesta
	private MedicalRecord medicalRecord;
	private ArrayList<ConsultTerm> appointedTerms;
	
	public Patient() {
		super();
	}

	public Patient(MedicalRecord medicalRecord, ArrayList<ConsultTerm> appointedTerms) {
		super();
		this.medicalRecord = medicalRecord;
		this.appointedTerms = appointedTerms;
	}

	public MedicalRecord getMedicalRecord() {
		return medicalRecord;
	}

	public void setMedicalRecord(MedicalRecord medicalRecord) {
		this.medicalRecord = medicalRecord;
	}

	public ArrayList<ConsultTerm> getAppointedTerms() {
		return appointedTerms;
	}

	public void setAppointedTerms(ArrayList<ConsultTerm> appointedTerms) {
		this.appointedTerms = appointedTerms;
	}
	
	
}
