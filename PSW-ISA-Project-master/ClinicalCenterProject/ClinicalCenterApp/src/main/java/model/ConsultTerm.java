package model;


import javax.persistence.*;

@Entity
public class ConsultTerm extends RequstForConsult {
	@Column
	private String type;

	@Column
	private int duration;

	@Column
	private Doctor doctor;

	@Column
	private Nurse nurse;

	@Column
	private String price;

	@Column
	private String discount;

	@Column
	private Room room;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Clinic clinic;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Patient patient;

	
	public ConsultTerm() {
		super();
	}

	public ConsultTerm(String type, int duration, Doctor doctor, Nurse nurse, String price, String discount,
                       Room room) {
		super();
		this.type = type;
		this.duration = duration;
		this.doctor = doctor;
		this.nurse = nurse;
		this.price = price;
		this.discount = discount;
		this.room = room;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Nurse getNurse() {
		return nurse;
	}

	public void setNurse(Nurse nurse) {
		this.nurse = nurse;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getDiscount() {
		return discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}
	
	
	
}
