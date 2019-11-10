package model;


public class Recipe {
	private Nurse nurse;
	private Medicament medicament;
	private boolean isValidated;
	
	public Recipe() {
		super();
	}

	public Recipe(Nurse nurse, Medicament medicament, boolean isValidated) {
		super();
		this.nurse = nurse;
		this.medicament = medicament;
		this.isValidated = isValidated;
	}

	public Nurse getNurse() {
		return nurse;
	}

	public void setNurse(Nurse nurse) {
		this.nurse = nurse;
	}

	public Medicament getMedicament() {
		return medicament;
	}

	public void setMedicament(Medicament medicament) {
		this.medicament = medicament;
	}

	public boolean isValidated() {
		return isValidated;
	}

	public void setValidated(boolean isValidated) {
		this.isValidated = isValidated;
	}
	
	
}
