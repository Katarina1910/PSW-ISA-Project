package model;

public class RequestForAbsence {
	private Personnel applicant;
	private boolean isAccepted;
	private String resaonOfRejection;
	
	public RequestForAbsence() {
		super();
	}

	public RequestForAbsence(Personnel applicant, boolean isAccepted, String resaonOfRejection) {
		super();
		this.applicant = applicant;
		this.isAccepted = isAccepted;
		this.resaonOfRejection = resaonOfRejection;
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
