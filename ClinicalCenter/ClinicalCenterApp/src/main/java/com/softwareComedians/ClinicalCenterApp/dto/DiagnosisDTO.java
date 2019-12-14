package com.softwareComedians.ClinicalCenterApp.dto;
import com.softwareComedians.ClinicalCenterApp.model.Diagnosis;

public class DiagnosisDTO {

    private String name;
    private String code;
    private String description;
    private Long id;

    public DiagnosisDTO() {
    }

    public DiagnosisDTO(String name, String code, String description, Long id) {
        this.name = name;
        this.code = code;
        this.description = description;
        this.id = id;
    }

    public DiagnosisDTO(Diagnosis d){
        this.name = d.getName();
        this.code = d.getCode();
        this.description = d.getDescription();
        this.id = d.getId();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
