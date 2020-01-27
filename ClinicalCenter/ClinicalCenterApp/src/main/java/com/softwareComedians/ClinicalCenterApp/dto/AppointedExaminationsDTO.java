package com.softwareComedians.ClinicalCenterApp.dto;

import com.softwareComedians.ClinicalCenterApp.model.AppointedExaminations;

import java.sql.Date;
import java.time.LocalDateTime;

public class AppointedExaminationsDTO {
    private Long id;
    private Date dateAndTime;
    private String type;
    private String doctor;
    private int duration;
    private String room;
    private double price;
    private Long discount;

    public AppointedExaminationsDTO(Long id, Date dateAndTime, String type, String doctor, int duration, String room, double price, Long discount) {
        this.id = id;
        this.dateAndTime = dateAndTime;
        this.type = type;
        this.doctor = doctor;
        this.duration = duration;
        this.room = room;
        this.price = price;
        this.discount = discount;
    }

    public AppointedExaminationsDTO() {
    }

    public AppointedExaminationsDTO(AppointedExaminations appexm) {
        dateAndTime = appexm.getDateTime();
        type = appexm.getType();
        id=appexm.getId();
        doctor = appexm.getDoctor();
        duration = appexm.getDuration();
        room = appexm.getRoom();
        price = appexm.getPrice();
        discount = appexm.getDiscount();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(Date dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Long getDiscount() {
        return discount;
    }

    public void setDiscount(Long discount) {
        this.discount = discount;
    }
}
