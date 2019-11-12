package model;


public class ConsultTerm extends RequstForConsult{
	private String type;
	private int duration;
	private Doctor doctor;
	private Nurse nurse;
	private String price;
	private String discount;
	private Room room;

	
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
