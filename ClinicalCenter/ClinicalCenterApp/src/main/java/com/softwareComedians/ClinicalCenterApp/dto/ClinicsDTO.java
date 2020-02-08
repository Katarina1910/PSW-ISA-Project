package com.softwareComedians.ClinicalCenterApp.dto;
import com.softwareComedians.ClinicalCenterApp.model.Clinic;

public class ClinicsDTO {

    private String name;
    private String address;
    private String description;
    private double grade;
    private Long id;
    private Double income;

    public ClinicsDTO(){

    }

    public void setIncome(Double income) {
        this.income = income;
    }

    public ClinicsDTO(String name, Double inc,String address, String description, double grade, long id){
        this.name = name;
        this.address = address;
        this.description = description;
        this.grade = grade;
        this.id = id;
        this.income = inc;
    }

    public ClinicsDTO(String name, Double income, String address, String description, double grade){
        this.name = name;
        this.address = address;
        this.description = description;
        this.grade = grade;
        this.income = income;


    }

    public ClinicsDTO(Clinic c){

        name = c.getName();
        address = c.getAddress();
        description = c.getDescription();
        grade = c.getGrade();
        id = c.getId();
        income = c.getIncome();
    }

    public Long getId(){return id;}
    public void setId(Long id){this.id = id;}

    public String getName(){ return name;}
    public void setName(String name){this.name = name;}

    public String getAddress(){return  address;}
    public void  setAddress(String address){this.address = address;}

    public  String getDescription(){return  description;}
    public void setDescription(String description){this.description = description;}

    public double getGrade(){return grade;}
    public void setGrade(double grade){this.grade = grade;}

    public Double getIncome() {
        return income;
    }
}
