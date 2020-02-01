package com.softwareComedians.ClinicalCenterApp.dto;

import com.softwareComedians.ClinicalCenterApp.model.RequestForConsult;

import java.sql.Date;

public class RequestForConsultDTO {
    private Date dateAndTime;
    private boolean isAccepted;
    private  ConsultTypeDTO type;
    private Long id;
    //private String applicant;
    private UserDTO patient;

    public UserDTO getPatient() {
        return patient;
    }

    public void setPatient(UserDTO patient) {
        this.patient = patient;
    }

    public RequestForConsultDTO() {
    }

    public RequestForConsultDTO(Date dateAndTime, boolean isAccepted, ConsultTypeDTO type, Long id, UserDTO p) {
        this.dateAndTime = dateAndTime;
        this.isAccepted = isAccepted;
        this.type = type;
        this.id=id;
       // this.applicant = u;
        this.patient = p;
    }

    public RequestForConsultDTO(RequestForConsult rfc) {
       dateAndTime = rfc.getDateAndTime();
       isAccepted = rfc.isAccepted();
       type = new ConsultTypeDTO(rfc.getType());
       id=rfc.getId();
       patient = new UserDTO(rfc.getPatient());
       //applicant = new UserDTO(rfc.getApplicant());

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

    public ConsultTypeDTO getType() {
        return type;
    }

    public void setType(ConsultTypeDTO type) {
        this.type = type;
    }

}
