package com.softwareComedians.ClinicalCenterApp.dto;

import com.softwareComedians.ClinicalCenterApp.model.ConsultType;

public class ConsultTypeDTO {
    private  String name;
    private Long id;
    private  String description;

    public ConsultTypeDTO() {
    }

    public ConsultTypeDTO(String name, Long id,String description) {
        this.name = name;
        this.id = id;
        this.description = description;
    }

    public ConsultTypeDTO(ConsultType c){
        this.id = c.getId();
        this.name = c.getName();
        this.description = c.getDescription();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
