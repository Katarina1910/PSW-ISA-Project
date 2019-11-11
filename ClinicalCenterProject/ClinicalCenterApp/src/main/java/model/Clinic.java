package model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.Set;

@Entity
public class Clinic {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String address;

	@Column(nullable = false)
	private String description;

	@Column
	private double grade;

	@OneToMany(mappedBy = "clinic", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<ConsultTerm> freeConsultTerms;

	@OneToMany(mappedBy = "clinic", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<ConsultTerm> appointedConsultTerms;

	@OneToMany(mappedBy = "clinic", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Doctor> doctors;

	@OneToMany(mappedBy = "clinic", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Patient> patients;

	@OneToMany(mappedBy = "clinic", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Room> rooms;

	@OneToOne(mappedBy = "clinic")
	private PriceList priceList;

	@OneToMany(mappedBy = "clinic", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<ClinicAdministrator> clinicAdministrators;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private ClinicalCenter clinicalCenter;
	
	public Clinic() {

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getGrade() {
		return grade;
	}

	public void setGrade(double grade) {
		this.grade = grade;
	}

	public Set<ConsultTerm> getFreeConsultTerms() {
		return freeConsultTerms;
	}

	public void setFreeConsultTerms(Set<ConsultTerm> freeConsultTerms) {
		this.freeConsultTerms = freeConsultTerms;
	}

	public Set<ConsultTerm> getAppointedConsultTerms() {
		return appointedConsultTerms;
	}

	public void setAppointedConsultTerms(Set<ConsultTerm> appointedConsultTerms) {
		this.appointedConsultTerms = appointedConsultTerms;
	}

	public Set<Doctor> getDoctors() {
		return doctors;
	}

	public void setDoctors(Set<Doctor> doctors) {
		this.doctors = doctors;
	}

	public Set<Patient> getPatients() {
		return patients;
	}

	public void setPatients(Set<Patient> patients) {
		this.patients = patients;
	}

	public Set<Room> getRooms() {
		return rooms;
	}

	public void setRooms(Set<Room> rooms) {
		this.rooms = rooms;
	}

	public PriceList getPriceList() {
		return priceList;
	}

	public void setPriceList(PriceList priceList) {
		this.priceList = priceList;
	}

	public Set<ClinicAdministrator> getClinicAdministrators() {
		return clinicAdministrators;
	}

	public void setClinicAdministrators(Set<ClinicAdministrator> clinicAdministrators) {
		this.clinicAdministrators = clinicAdministrators;
	}
}
