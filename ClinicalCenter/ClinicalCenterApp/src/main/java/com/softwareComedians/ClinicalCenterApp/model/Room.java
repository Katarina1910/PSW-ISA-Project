package com.softwareComedians.ClinicalCenterApp.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Room {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private Type type;

	@Column
	private String name;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Clinic clinic;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "room")
	private Set<ConsultTerm> consultTerms;

	@OneToOne(mappedBy = "room")
	private Operation operation;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "room")
	private Set<RoomTerms> roomTerms;



	public Room() {
		super();
	}

	public Room(Type type,  String name) {
		super();
		this.type = type;
		this.name = name;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Clinic getClinic() {
		return clinic;
	}

	public void setClinic(Clinic clinic) {
		this.clinic = clinic;
	}

	public Set<ConsultTerm> getConsultTerms() {
		return consultTerms;
	}

	public void setConsultTerms(Set<ConsultTerm> consultTerms) {
		this.consultTerms = consultTerms;
	}

	public Operation getOperation() {
		return operation;
	}

	public void setOperation(Operation operation) {
		this.operation = operation;
	}
	
	
	
}
