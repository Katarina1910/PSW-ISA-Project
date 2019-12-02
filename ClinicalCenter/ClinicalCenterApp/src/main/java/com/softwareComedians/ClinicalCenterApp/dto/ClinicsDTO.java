package com.softwareComedians.ClinicalCenterApp.dto;
import com.softwareComedians.ClinicalCenterApp.model.Clinic;

public class ClinicsDTO {

    private String name;
    private String address;
    private String description;
    private double grade;

    public ClinicsDTO(){

    }

    public ClinicsDTO(String name, String address, String description, double grade){
        this.name = name;
        this.address = address;
        this.description = description;
        this.grade = grade;
    }

    public ClinicsDTO(Clinic c){

        name = c.getName();
        address = c.getAddress();
        description = c.getDescription();
        grade = c.getGrade();
    }

    public String getName(){ return name;}
    public void setName(String name){this.name = name;}

    public String getAddress(){return  address;}
    public void  setAddress(String address){this.address = address;}

    public  String getDescription(){return  description;}
    public void setDescription(String description){this.description = description;}

    public double getGrade(){return grade;}
    public void setGrade(double grade){this.grade = grade;}
}
