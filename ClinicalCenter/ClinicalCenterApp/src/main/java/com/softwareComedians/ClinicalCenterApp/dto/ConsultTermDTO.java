package com.softwareComedians.ClinicalCenterApp.dto;

import com.softwareComedians.ClinicalCenterApp.model.ConsultTerm;

public class ConsultTermDTO {
    private  String type;
    private Long id;
    private String date;
    private  Double duration;
    private  Double price;
    private  Double discount;
    private  String doctor;
    private  String room;

    public ConsultTermDTO() {
    }

    public ConsultTermDTO(String type, Long id, String date, Double duration, Double price, Double discount, String doctor, String room) {
        this.type = type;
        this.id = id;
        this.date = date;
        this.duration = duration;
        this.price = price;
        this.discount = discount;
        this.doctor = doctor;
        this.room = room;
    }

    public ConsultTermDTO(ConsultTerm c){
        id=c.getId();
        type=c.getType().getName();
        date = c.getDate();
        duration=c.getDuration();
        price=c.getPrice();
        discount=c.getDiscount();
        doctor = c.getDoctor().getName();
        room = c.getRoom().getName();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Double getDuration() {
        return duration;
    }

    public void setDuration(Double duration) {
        this.duration = duration;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }
}
