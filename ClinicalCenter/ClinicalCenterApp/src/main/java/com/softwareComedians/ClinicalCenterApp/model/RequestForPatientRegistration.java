package com.softwareComedians.ClinicalCenterApp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class RequestForPatientRegistration {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne( fetch = FetchType.LAZY)
	@JoinColumn(name = "userData_id", referencedColumnName = "id")
	private User userData;

	@Column
	private boolean isAccepted;

	@Column
	private String reasonOfRejection;


	public RequestForPatientRegistration() {
		super();
	}

	public RequestForPatientRegistration(User user) {
		this.userData = user;
		this.isAccepted=false;
		this.reasonOfRejection="Razlog za odbijanje zahteva: ";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUserData() {
		return userData;
	}

	public void setUserData(User userData) {
		this.userData = userData;
	}

	public boolean isAccepted() {
		return isAccepted;
	}

	public void setAccepted(boolean accepted) {
		isAccepted = accepted;
	}

	public boolean getAccepted() { return isAccepted; }

	public String getReasonOfRejection() {
		return reasonOfRejection;
	}

	public void setReasonOfRejection(String reasonOfRejection) {
		this.reasonOfRejection = reasonOfRejection;
	}

}
