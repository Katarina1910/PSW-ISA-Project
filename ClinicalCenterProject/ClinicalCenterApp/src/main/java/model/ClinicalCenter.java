package model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class ClinicalCenter {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String name;

	@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL, mappedBy = "clinicalCenter")
	private Set<Clinic> clinics;

	@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL, mappedBy = "clinicalCenter")
	private Set<ClinicCenterAdministrator> admins;

	@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL, mappedBy = "clinicalCenter")
	private Set<MedicalRecord> medicalRecords;

	@OneToOne(mappedBy = "clinicalCenter")
	private DiagnosisCodebook diagnosisCodebook;

	@OneToOne(mappedBy = "clinicalCenter")
	private MedicamentCodeBook medicamentCodebook;

	public ClinicalCenter() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Clinic> getClinics() {
		return clinics;
	}

	public void setClinics(Set<Clinic> clinics) {
		this.clinics = clinics;
	}

	public Set<ClinicCenterAdministrator> getAdmins() {
		return admins;
	}

	public void setAdmins(Set<ClinicCenterAdministrator> admins) {
		this.admins = admins;
	}

	public Set<MedicalRecord> getMedicalRecords() {
		return medicalRecords;
	}

	public void setMedicalRecords(Set<MedicalRecord> medicalRecords) {
		this.medicalRecords = medicalRecords;
	}

	public DiagnosisCodebook getDiagnosisCodebook() {
		return diagnosisCodebook;
	}

	public void setDiagnosisCodebook(DiagnosisCodebook diagnosisCodebook) {
		this.diagnosisCodebook = diagnosisCodebook;
	}

	public MedicamentCodeBook getMedicamentCodebook() {
		return medicamentCodebook;
	}

	public void setMedicamentCodebook(MedicamentCodeBook medicamentCodebook) {
		this.medicamentCodebook = medicamentCodebook;
	}
}
