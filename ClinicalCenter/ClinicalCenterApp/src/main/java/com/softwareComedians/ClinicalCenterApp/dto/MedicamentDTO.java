package com.softwareComedians.ClinicalCenterApp.dto;

import com.softwareComedians.ClinicalCenterApp.model.Medicament;

public class MedicamentDTO {

    private String name;
    private String code;
    private String description;
    private Long id;

    public MedicamentDTO(){

    }

    public MedicamentDTO(String name, String code, String description, long id){
        this.name = name;
        this.code = code;
        this.description = description;
        this.id = id;
    }

    public MedicamentDTO(String name, String code, String description){
        this.name = name;
        this.code = code;
        this.description = description;
    }

    public MedicamentDTO(Medicament m){

        name = m.getName();
        code = m.getCode();
        description = m.getDescription();
        id = m.getId();
    }

    public Long getId(){return id;}
    public void setId(Long id){this.id = id;}

    public String getName(){ return name;}
    public void setName(String name){this.name = name;}

    public String getCode(){return code;}
    public void  setCode(String code){this.code = code;}

    public  String getDescription(){return  description;}
    public void setDescription(String description){this.description = description;}

}
