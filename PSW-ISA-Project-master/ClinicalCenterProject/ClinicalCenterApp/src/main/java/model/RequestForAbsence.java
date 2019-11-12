package model;

import javax.persistence.*;

@Entity
public class RequestForAbsence {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private Personnel applicant;

	@Column
	private boolean isAccepted;

	@Column
	private String resaonOfRejection;

	@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private ClinicAdministrator clinicAdministrator;
	
	public RequestForAbsence() {
		super();
	}

	public RequestForAbsence(Personnel applicant, boolean isAccepted, String resaonOfRejection) {
		super();
		this.applicant = applicant;
		this.isAccepted = isAccepted;
		this.resaonOfRejection = resaonOfRejection;
	}

	public ClinicAdministrator getClinicAdministrator() {
		return clinicAdministrator;
	}

	public void setClinicAdministrator(ClinicAdministrator clinicAdministrator) {
		this.clinicAdministrator = clinicAdministrator;
	}

	public Personnel getApplicant() {
		return applicant;
	}

	public void setApplicant(Personnel applicant) {
		this.applicant = applicant;
	}

	public boolean isAccepted() {
		return isAccepted;
	}

	public void setAccepted(boolean isAccepted) {
		this.isAccepted = isAccepted;
	}

	public String getResaonOfRejection() {
		return resaonOfRejection;
	}

	public void setResaonOfRejection(String resaonOfRejection) {
		this.resaonOfRejection = resaonOfRejection;
	}
	
	
	
}
