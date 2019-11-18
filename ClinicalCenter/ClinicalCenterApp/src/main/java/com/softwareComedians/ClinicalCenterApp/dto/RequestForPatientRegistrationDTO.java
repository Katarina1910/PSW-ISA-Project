package com.softwareComedians.ClinicalCenterApp.dto;

import com.softwareComedians.ClinicalCenterApp.model.RequestForConsult;
import com.softwareComedians.ClinicalCenterApp.model.RequestForPatientRegistration;
import com.softwareComedians.ClinicalCenterApp.model.User;

public class RequestForPatientRegistrationDTO {
    private User userData;
    private Long id;
    private boolean isAccepted;
    private String reasonOfRejection;

    public RequestForPatientRegistrationDTO() {
    }

    public RequestForPatientRegistrationDTO(User userData, Long id, boolean isAccepted, String reasonOfRejection) {
        this.userData = userData;
        this.id = id;
        this.isAccepted = isAccepted;
        this.reasonOfRejection = reasonOfRejection;
    }
    public RequestForPatientRegistrationDTO(RequestForPatientRegistration rq){
        this.id=rq.getId();
        this.userData= rq.getUserData();
        this.isAccepted = rq.isAccepted();
        this.reasonOfRejection = rq.getReasonOfRejection();
    }

    public User getUserData() {
        return userData;
    }

    public void setUserData(User userData) {
        this.userData = userData;
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

    public String getReasonOfRejection() {
        return reasonOfRejection;
    }

    public void setReasonOfRejection(String reasonOfRejection) {
        this.reasonOfRejection = reasonOfRejection;
    }
}
