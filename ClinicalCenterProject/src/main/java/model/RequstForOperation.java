package model;

import java.sql.Date;

public class RequstForOperation {
	private Doctor applicant;
	private Date dateAndTime;
	private boolean isApproved;
	
	public RequstForOperation() {
		super();
	}

	public RequstForOperation(Doctor applicant, Date dateAndTime) {
		super();
		this.applicant = applicant;
		this.dateAndTime = dateAndTime;
	}

	public Doctor getApplicant() {
		return applicant;
	}

	public void setApplicant(Doctor applicant) {
		this.applicant = applicant;
	}

	public Date getDateAndTime() {
		return dateAndTime;
	}

	public void setDateAndTime(Date dateAndTime) {
		this.dateAndTime = dateAndTime;
	}

	public boolean isApproved() {
		return isApproved;
	}

	public void setApproved(boolean isApproved) {
		this.isApproved = isApproved;
	}
	
	
}
