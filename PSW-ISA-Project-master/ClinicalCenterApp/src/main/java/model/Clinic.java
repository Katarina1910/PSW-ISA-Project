package model;


import java.util.ArrayList;

public class Clinic {
	private String name;
	private String address;
	private String description;
	private double grade;
	
	private ArrayList<ConsultTerm> freeConsultTerms;
	private ArrayList<ConsultTerm> appointedConsultTerms;
	private ArrayList<Doctor> doctors;
	private ArrayList<Patient> patients;
	private ArrayList<Room> rooms;
	private ArrayList<PriceListItem> priceList;
	private ArrayList<ClinicAdministrator> clinicAdministrators;
	
	public Clinic() {
		super();
	}

	public Clinic(String name, String address, String description, double clinicsGrade, ArrayList<ConsultTerm> freeConsultTerms, ArrayList<ConsultTerm> appointedConsultTerms, ArrayList<Doctor> doctors, ArrayList<Patient> patients, ArrayList<Room> rooms, ArrayList<PriceListItem> priceList, ArrayList<ClinicAdministrator> clinicAdministrators) {
		this.name = name;
		this.address = address;
		this.description = description;
		this.grade = clinicsGrade;
		this.freeConsultTerms = freeConsultTerms;
		this.appointedConsultTerms = appointedConsultTerms;
		this.doctors = doctors;
		this.patients = patients;
		this.rooms = rooms;
		this.priceList = priceList;
		this.clinicAdministrators = clinicAdministrators;
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

	public ArrayList<ClinicAdministrator> getClinicAdministrators() {
		return clinicAdministrators;
	}

	public void setClinicAdministrators(ArrayList<ClinicAdministrator> clinicAdministrators) {
		this.clinicAdministrators = clinicAdministrators;
	}

	public double getClinicsGrade() {
		return grade;
	}

	public void setClinicsGrade(double clinicsGrade) {
		this.grade = clinicsGrade;
	}

	public ArrayList<ConsultTerm> getFreeConsultTerms() {
		return freeConsultTerms;
	}

	public void setFreeConsultTerms(ArrayList<ConsultTerm> freeConsultTerms) {
		this.freeConsultTerms = freeConsultTerms;
	}

	public ArrayList<ConsultTerm> getAppointedConsultTerms() {
		return appointedConsultTerms;
	}

	public void setAppointedConsultTerms(ArrayList<ConsultTerm> appointedConsultTerms) {
		this.appointedConsultTerms = appointedConsultTerms;
	}

	public ArrayList<Doctor> getDoctors() {
		return doctors;
	}

	public void setDoctors(ArrayList<Doctor> doctors) {
		this.doctors = doctors;
	}

	public ArrayList<Patient> getPatients() {
		return patients;
	}

	public void setPatients(ArrayList<Patient> patients) {
		this.patients = patients;
	}

	public ArrayList<Room> getRooms() {
		return rooms;
	}

	public void setRooms(ArrayList<Room> rooms) {
		this.rooms = rooms;
	}

	public ArrayList<PriceListItem> getPriceList() {
		return priceList;
	}

	public void setPriceList(ArrayList<PriceListItem> priceList) {
		this.priceList = priceList;
	}
	
}
