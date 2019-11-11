package model;


import javax.persistence.*;

@Entity
public class Recipe {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private Nurse nurse;

	@Column
	private Medicament medicament;

	@Column
	private boolean isValidated;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private MedicalRecord medicalRecord;
	
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
