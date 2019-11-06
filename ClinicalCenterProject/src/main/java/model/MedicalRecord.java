package model;

import java.util.ArrayList;
import java.util.HashMap;

public class MedicalRecord {
	private String historyDesease;
	private ArrayList<Consult> visitsToDoctor;
	private ArrayList<Operation> operations;
	private ArrayList<Recipe> recipes;
	private HashMap<String, String> diagnosis;
	
	public MedicalRecord() {
		super();
	}

	public MedicalRecord(String historyDesease, ArrayList<Consult> visitsToDoctor, ArrayList<Operation> operations,
			ArrayList<Recipe> recipes, HashMap<String, String> diagnosis) {
		super();
		this.historyDesease = historyDesease;
		this.visitsToDoctor = visitsToDoctor;
		this.operations = operations;
		this.recipes = recipes;
		this.diagnosis = diagnosis;
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

	public HashMap<String, String> getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(HashMap<String, String> diagnosis) {
		this.diagnosis = diagnosis;
	}
	
	
	
	
}
