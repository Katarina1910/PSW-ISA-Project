package model;

import java.util.ArrayList;

public class MedicalRecord {
	private String historyDesease;
	private ArrayList<Consult> visitsToDoctor;
	private ArrayList<Operation> operations;
	private ArrayList<Recipe> recipes;
	private ArrayList<Diagnosis> diagnosis;
	private ArrayList<Personnel> beenTo; //personel kod koga je bio
	private ArrayList<Medicament> prescribedMedicaments;
	
	public MedicalRecord() {
		super();
	}

	public MedicalRecord(String historyDesease, ArrayList<Consult> visitsToDoctor, ArrayList<Operation> operations,
                         ArrayList<Recipe> recipes, ArrayList<Diagnosis> diagnosis, ArrayList<Personnel> beenTo, ArrayList<Medicament> prescribedMedicaments) {
		super();
		this.historyDesease = historyDesease;
		this.visitsToDoctor = visitsToDoctor;
		this.operations = operations;
		this.recipes = recipes;
		this.diagnosis = diagnosis;
		this.setBeenTo(beenTo);
		this.prescribedMedicaments = prescribedMedicaments;
	}

	public ArrayList<Medicament> getPrescribedMedicaments() {
		return prescribedMedicaments;
	}

	public void setPrescribedMedicaments(ArrayList<Medicament> prescribedMedicaments) {
		this.prescribedMedicaments = prescribedMedicaments;
	}

	public String getHistoryDesease() {
		return historyDesease;
	}

	public void setHistoryDesease(String historyDesease) {
		this.historyDesease = historyDesease;
	}

	public ArrayList<Consult> getVisitsToDoctor() {
		return visitsToDoctor;
	}

	public void setVisitsToDoctor(ArrayList<Consult> visitsToDoctor) {
		this.visitsToDoctor = visitsToDoctor;
	}

	public ArrayList<Operation> getOperations() {
		return operations;
	}

	public void setOperations(ArrayList<Operation> operations) {
		this.operations = operations;
	}

	public ArrayList<Recipe> getRecipes() {
		return recipes;
	}

	public void setRecipes(ArrayList<Recipe> recipes) {
		this.recipes = recipes;
	}

	public  ArrayList<Diagnosis> getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis( ArrayList<Diagnosis> diagnosis) {
		this.diagnosis = diagnosis;
	}

	public ArrayList<Personnel> getBeenTo() {
		return beenTo;
	}

	public void setBeenTo(ArrayList<Personnel> beenTo) {
		this.beenTo = beenTo;
	}
	
	
	
	
}
