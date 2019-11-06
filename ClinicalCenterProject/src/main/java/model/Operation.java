package model;

import java.util.ArrayList;

public class Operation extends RequstForOperation {
	public ArrayList<Doctor> doctors;
	public Room room;
	
	public Operation() {
		super();
	}

	public Operation(ArrayList<Doctor> doctors, Room room) {
		super();
		this.doctors = doctors;
		this.room = room;
	}

	public ArrayList<Doctor> getDoctors() {
		return doctors;
	}

	public void setDoctors(ArrayList<Doctor> doctors) {
		this.doctors = doctors;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}
	
	
	
}
