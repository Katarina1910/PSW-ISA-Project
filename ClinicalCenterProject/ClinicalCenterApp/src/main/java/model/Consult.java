package model;

import javax.persistence.*;

@Entity
public class Consult extends ConsultTerm {
	@Column
	private String report;

	@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private MedicalRecord medicalRecord;

	public Consult(String report) {
		super();
		this.report = report;
	}

	public String getReport() {
		return report;
	}

	public void setReport(String report) {
		this.report = report;
	}
	
	

}
