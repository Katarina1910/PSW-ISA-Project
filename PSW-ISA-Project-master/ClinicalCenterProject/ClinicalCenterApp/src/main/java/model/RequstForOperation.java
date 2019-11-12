package model;

import javax.persistence.*;
import java.sql.Date;

import static javax.persistence.InheritanceType.JOINED;

@Entity
@Inheritance(strategy=JOINED)
public class RequstForOperation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Doctor applicant;

	@Column
	private Date dateAndTime;

	@Column
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
