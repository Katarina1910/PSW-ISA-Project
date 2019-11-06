package model;


public class Recipe {
	private Nurse nurse;
	private String medicamentName;
	private String medicamentCode;
	private boolean isValidated;
	
	public Recipe() {
		super();
	}

	public Recipe(Nurse nurse, String medicamentName, String medicamentCode, boolean isValidated) {
		super();
		this.nurse = nurse;
		this.medicamentName = medicamentName;
		this.medicamentCode = medicamentCode;
		this.isValidated = isValidated;
	}

	public Nurse getNurse() {
		return nurse;
	}

	public void setNurse(Nurse nurse) {
		this.nurse = nurse;
	}

	public String getMedicamentName() {
		return medicamentName;
	}

	public void setMedicamentName(String medicamentName) {
		this.medicamentName = medicamentName;
	}

	public String getMedicamentCode() {
		return medicamentCode;
	}

	public void setMedicamentCode(String medicamentCode) {
		this.medicamentCode = medicamentCode;
	}

	public boolean isValidated() {
		return isValidated;
	}

	public void setValidated(boolean isValidated) {
		this.isValidated = isValidated;
	}
	
	
}
