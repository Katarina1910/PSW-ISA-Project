package com.softwareComedians.ClinicalCenterApp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.InheritanceType.JOINED;

@Entity
@Getter
@Setter
public class RequestForPatientRegistration {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "userData_id", referencedColumnName = "id")
	private User userData;

	@Column
	private boolean isAccepted;

	@Column
	private String reasonOfRejection;

	@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private ClinicCenterAdministrator clinicCenterAdministrator;

	public RequestForPatientRegistration() {
		super();
	}

	public RequestForPatientRegistration(User user) {
		this.userData = user;
		this.isAccepted=false;
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

	public String getReasonOfRejection() {
		return reasonOfRejection;
	}

	public void setReasonOfRejection(String reasonOfRejection) {
		this.reasonOfRejection = reasonOfRejection;
	}

	public ClinicCenterAdministrator getClinicCenterAdministrator() {
		return clinicCenterAdministrator;
	}

	public void setClinicCenterAdministrator(ClinicCenterAdministrator clinicCenterAdministrator) {
		this.clinicCenterAdministrator = clinicCenterAdministrator;
	}
}
