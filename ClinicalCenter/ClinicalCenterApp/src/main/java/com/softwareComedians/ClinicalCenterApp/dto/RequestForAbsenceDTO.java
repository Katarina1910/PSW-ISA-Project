package com.softwareComedians.ClinicalCenterApp.dto;

import com.softwareComedians.ClinicalCenterApp.model.RequestForAbsence;

import java.util.Date;

public class RequestForAbsenceDTO {
    private Long id;
    private Long applicant;
    private boolean isAccepted;
    private String resaonOfRejection;
    private Date from;
    private Date to;
    private Long clinicAdministrator;

    public RequestForAbsenceDTO() { }

    public RequestForAbsenceDTO(Long id, Long applicant, boolean isAccepted, String resaonOfRejection, Date from, Date to, Long clinicAdministrator) {
        this.id = id;
        this.applicant = applicant;
        this.isAccepted = false;
        this.resaonOfRejection = resaonOfRejection;
        this.from = from;
        this.to = to;
        this.clinicAdministrator = clinicAdministrator;
    }

    public RequestForAbsenceDTO (RequestForAbsence rq){
        this.id = rq.getId();
        this.applicant = rq.getApplicant().getId();
        this.isAccepted = false;
        this.resaonOfRejection = rq.getResaonOfRejection();
        this.from = rq.getFroom();
        this.to = rq.getToo();
        this.clinicAdministrator = rq.getClinicAdministrator().getId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public boolean isAccepted() {
        return isAccepted;
    }

    public void setAccepted(boolean accepted) {
        isAccepted = accepted;
    }

    public String getResaonOfRejection() {
        return resaonOfRejection;
    }

    public void setResaonOfRejection(String resaonOfRejection) {
        this.resaonOfRejection = resaonOfRejection;
    }

    public Date getFrom() {
        return from;
    }

    public void setFrom(Date from) {
        this.from = from;
    }

    public Date getTo() {
        return to;
    }

    public void setTo(Date to) {
        this.to = to;
    }

    public Long getApplicant() {
        return applicant;
    }

    public void setApplicant(Long applicant) {
        this.applicant = applicant;
    }

    public Long getClinicAdministrator() {
        return clinicAdministrator;
    }

    public void setClinicAdministrator(Long clinicAdministrator) {
        this.clinicAdministrator = clinicAdministrator;
    }
}
