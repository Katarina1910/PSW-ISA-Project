package com.softwareComedians.ClinicalCenterApp.dto;

import com.softwareComedians.ClinicalCenterApp.model.ConsultTerm;
import com.softwareComedians.ClinicalCenterApp.model.RequestForConsult;
import com.softwareComedians.ClinicalCenterApp.model.User;

import java.sql.Date;

public class RequestForConsultDTO {
    private Date dateAndTime;
    private boolean isAccepted;
    private  String type;
    private Long id;
    private User applicant;
    private ConsultTerm consultTerm;

    public RequestForConsultDTO() {
    }

    public RequestForConsultDTO(Date dateAndTime, boolean isAccepted, String type, Long id, User applicant, ConsultTerm consultTerm) {
        this.dateAndTime = dateAndTime;
        this.isAccepted = isAccepted;
        this.type = type;
        this.id=id;
        this.applicant = applicant;
        this.consultTerm = consultTerm;
    }

    public RequestForConsultDTO(RequestForConsult rfc) {
       dateAndTime = rfc.getDateAndTime();
       isAccepted = rfc.isAccepted();
       type = rfc.getType();
       id=rfc.getId();
       applicant = rfc.getApplicant();
       consultTerm = rfc.getConsultTerm();
    }

    public Date getDateAndTime() {
        return dateAndTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDateAndTime(Date dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    public boolean isAccepted() {
        return isAccepted;
    }

    public void setAccepted(boolean accepted) {
        isAccepted = accepted;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public User getApplicant() {
        return applicant;
    }

    public void setApplicant(User applicant) {
        this.applicant = applicant;
    }

    public ConsultTerm getConsultTerm() {
        return consultTerm;
    }

    public void setConsultTerm(ConsultTerm consultTerm) {
        this.consultTerm = consultTerm;
    }
}
