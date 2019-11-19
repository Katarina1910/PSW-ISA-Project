package com.softwareComedians.ClinicalCenterApp.dto;

import com.softwareComedians.ClinicalCenterApp.model.ConsultTerm;

import java.sql.Date;

public class ConsultTermDTO {
    private  String type;
    private Long id;
    private  String duration;
    private  String price;
    private  String discount;

    public ConsultTermDTO() {
    }

    public ConsultTermDTO(String type, Long id, String duration, String price, String discount) {
        this.type = type;
        this.id = id;
        this.duration = duration;
        this.price = price;
        this.discount = discount;
    }

    public ConsultTermDTO(ConsultTerm c){
        id=c.getId();
        type=c.getType();
        duration=c.getDuration();
        price=c.getPrice();
        discount=c.getDiscount();
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

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }
}
