package model;

import javax.persistence.*;

import static javax.persistence.InheritanceType.JOINED;

@Entity
@Inheritance(strategy=JOINED)
public class RequestForPatientRegistration {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

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

	public RequestForPatientRegistration(User userData, boolean isAccepted, String reasonOfRejection) {
		super();
		this.userData = userData;
		this.isAccepted = isAccepted;
		this.reasonOfRejection = reasonOfRejection;
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

	public void setAccepted(boolean isAccepted) {
		this.isAccepted = isAccepted;
	}

	public String getReasonOfRejection() {
		return reasonOfRejection;
	}

	public void setReasonOfRejection(String reasonOfRejection) {
		this.reasonOfRejection = reasonOfRejection;
	}
	
	
}
