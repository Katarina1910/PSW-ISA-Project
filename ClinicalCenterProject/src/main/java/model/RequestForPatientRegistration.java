package model;

public class RequestForPatientRegistration {
	private User userData;
	private boolean isAccepted;
	private String reasonOfRejection;
	
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
