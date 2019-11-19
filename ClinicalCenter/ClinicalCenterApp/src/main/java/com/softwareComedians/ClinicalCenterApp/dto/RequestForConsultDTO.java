package com.softwareComedians.ClinicalCenterApp.dto;

import com.softwareComedians.ClinicalCenterApp.model.RequestForConsult;

import java.sql.Date;

public class RequestForConsultDTO {
    private Date dateAndTime;
    private boolean isAccepted;
    private  String type;
    private Long id;

    public RequestForConsultDTO() {
    }

    public RequestForConsultDTO(Date dateAndTime, boolean isAccepted, String type, Long id) {
        this.dateAndTime = dateAndTime;
        this.isAccepted = isAccepted;
        this.type = type;
        this.id=id;
    }

    public RequestForConsultDTO(RequestForConsult rfc) {
       dateAndTime = rfc.getDateAndTime();
       isAccepted = rfc.isAccepted();
       type = rfc.getType();
       id=rfc.getId();
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
}
