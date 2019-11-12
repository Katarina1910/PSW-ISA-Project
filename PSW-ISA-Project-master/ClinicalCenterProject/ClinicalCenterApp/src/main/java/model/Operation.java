package model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Set;

@Entity
public class Operation extends RequstForOperation {
	@ManyToMany(mappedBy = "DocOp")
	private Set<Doctor> doctors;

	@Column
	private Room room;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private MedicalRecord medicalRecord;
	
	public Operation() {
		super();
	}

	public Operation(Set<Doctor> doctors, Room room) {
		super();
		this.doctors = doctors;
		this.room = room;
	}

	public Set<Doctor> getDoctors() {
		return doctors;
	}

	public void setDoctors(Set<Doctor> doctors) {
		this.doctors = doctors;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}
	
	
	
}
