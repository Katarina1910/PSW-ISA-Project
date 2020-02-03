package com.softwareComedians.ClinicalCenterApp.dto;

import com.softwareComedians.ClinicalCenterApp.model.RequestForAbsence;

import java.util.Date;

public class RequestForAbsenceDTO {
    private Long id;
    private PersonnelDTO applicant;
    private boolean isAccepted;
    private String resaonOfRejection;
    private Date from;
    private Date to;

    public RequestForAbsenceDTO() {
    }

    public RequestForAbsenceDTO(Long id, PersonnelDTO applicant, boolean isAccepted, String resaonOfRejection, Date from, Date to) {
        this.id = id;
        this.applicant = applicant;
        this.isAccepted = false;
        this.resaonOfRejection = resaonOfRejection;
        this.from = from;
        this.to = to;
    }

    public RequestForAbsenceDTO(RequestForAbsence rq) {
        this.id = rq.getId();
        this.applicant = new PersonnelDTO(rq.getApplicant());
        this.isAccepted = false;
        this.resaonOfRejection = rq.getResaonOfRejection();
        this.from = rq.getFroom();
        this.to = rq.getToo();
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

    public PersonnelDTO getApplicant() {
        return applicant;
    }

    public void setApplicant(PersonnelDTO applicant) {
        this.applicant = applicant;
    }
}
