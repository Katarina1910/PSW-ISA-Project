package com.softwareComedians.ClinicalCenterApp.dto;

import com.softwareComedians.ClinicalCenterApp.model.ConsultType;

public class ConsultTypeDTO {
    private  String name;
    private Long id;

    public ConsultTypeDTO() {
    }

    public ConsultTypeDTO(String name, Long id) {
        this.name = name;
        this.id = id;
    }

    public ConsultTypeDTO(ConsultType c){
        this.id = c.getId();
        this.name = c.getName();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
