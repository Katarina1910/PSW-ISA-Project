package com.softwareComedians.ClinicalCenterApp.dto;

import com.softwareComedians.ClinicalCenterApp.model.ConsultTerm;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class ConsultTermDTO {
    private  ConsultTypeDTO type;
    private Long id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;
    private  Double duration;
    private  Double price;
    private  Double discount;
    private  String doctor;
    private  String room;

    public ConsultTermDTO() {
    }

    public ConsultTermDTO(ConsultTypeDTO type, Long id, Date date, Double duration, Double price, Double discount, String doctor, String room) {
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
        type=new ConsultTypeDTO(c.getType());
        date = c.getDate();
        duration=c.getDuration();
        price=c.getPrice();
        discount=c.getDiscount();
        doctor = c.getDoctor().getName();
        room = c.getRoom().getName();
    }

    public ConsultTypeDTO getType() {
        return type;
    }

    public void setType(ConsultTypeDTO type) {
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
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
