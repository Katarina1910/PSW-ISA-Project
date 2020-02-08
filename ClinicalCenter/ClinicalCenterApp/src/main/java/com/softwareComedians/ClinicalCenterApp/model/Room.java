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

	@ManyToOne( fetch = FetchType.LAZY)
	private Clinic clinic;

	@OneToMany( fetch = FetchType.LAZY, mappedBy = "room")
	private Set<ConsultTerm> consultTerms;


	@OneToMany(fetch = FetchType.LAZY, mappedBy = "room")
	private Set<Operation> operations;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "room")
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

	public Set<Operation> getOperations() {
		return operations;
	}

	public void setOperations(Set<Operation> operations) {
		this.operations = operations;
	}

	public Set<RoomTerms> getRoomTerms() {
		return roomTerms;
	}

	public void setRoomTerms(Set<RoomTerms> roomTerms) {
		this.roomTerms = roomTerms;
	}
}
