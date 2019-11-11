package model;

import javax.persistence.*;
import java.sql.Date;

import static javax.persistence.InheritanceType.JOINED;

@Entity
@Inheritance(strategy=JOINED)
public class RequstForConsult {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private User applicant;
	//doctor or patient, activated user
	@Column
	private Date dateAndTime;

	@Column
	private boolean isAccepted;
	
	public RequstForConsult() {
		super();
	}

	public RequstForConsult(User applicant, Date dateAndTime, boolean isAccepted) {
		super();
		this.applicant = applicant;
		this.dateAndTime = dateAndTime;
		this.isAccepted = isAccepted;
	}

	public User getApplicant() {
		return applicant;
	}

	public void setApplicant(User applicant) {
		this.applicant = applicant;
	}

	public Date getDateAndTime() {
		return dateAndTime;
	}

	public void setDateAndTime(Date dateAndTime) {
		this.dateAndTime = dateAndTime;
	}

	public boolean isAccepted() {
		return isAccepted;
	}

	public void setAccepted(boolean isAccepted) {
		this.isAccepted = isAccepted;
	}
	
	
	
}
