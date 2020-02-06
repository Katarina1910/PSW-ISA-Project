package com.softwareComedians.ClinicalCenterApp.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
public class ConsultTerm {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String date;

	@Column
	private String report;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private ConsultType type;

	@Column
	private Double duration;

	@Column
	private Double price;

	@Column
	private Double discount;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Room room;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Doctor doctor;

	@OneToOne(mappedBy = "consultTerm")
	@JsonBackReference
	private RequestForConsult requestForConsult;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "consultTerm")
	private Set<Personnel> personnels;


	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Clinic clinic;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Patient patient;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "diagnosis_id", referencedColumnName = "id")
	public Diagnosis diagnosis;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "recipe_id", referencedColumnName = "id")
	public Recipe recipe;

	public ConsultTerm() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getDuration() {
		return duration;
	}

	public void setDuration(Double duration) {
		this.duration = duration;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Set<Personnel> getPersonnels() {
		return personnels;
	}

	public void setPersonnels(Set<Personnel> personnels) {
		this.personnels = personnels;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public Clinic getClinic() {
		return clinic;
	}

	public void setClinic(Clinic clinic) {
		this.clinic = clinic;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public ConsultType getType() {
		return type;
	}

	public void setType(ConsultType type) {
		this.type = type;
	}

	public RequestForConsult getRequestForConsult() {
		return requestForConsult;
	}

	public void setRequestForConsult(RequestForConsult requestForConsult) {
		this.requestForConsult = requestForConsult;
	}
}
