package com.softwareComedians.ClinicalCenterApp.model;


import com.softwareComedians.ClinicalCenterApp.dto.ClinicsDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
public class Clinic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String description;

    @Column
    private double grade;

    @Column
    private  double income;

    @OneToOne( fetch = FetchType.LAZY)
    @JoinColumn(name = "priceList_id", referencedColumnName = "id")
     private PriceList priceList;

    @OneToMany(mappedBy = "clinic", fetch = FetchType.LAZY)
    private Set<ConsultTerm> freeConsultTerms;

    @OneToMany(mappedBy = "clinic", fetch = FetchType.LAZY)
    private Set<ConsultTerm> appointedConsultTerms;

    @OneToMany(mappedBy = "clinic", fetch = FetchType.LAZY)
    private Set<Personnel> personnels;

    @OneToMany(mappedBy = "clinic", fetch = FetchType.LAZY)
    private Set<Patient> patients;

   @OneToMany(mappedBy = "clinic", fetch = FetchType.LAZY)
    private Set<Room> rooms;


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "clinic")
    private Set<ClinicAdministrator> clinicAdministrators;

    public Clinic() {
        this.income = 0;

    }

    public Clinic(ClinicsDTO c){
        this.id = c.getId();
        this.name = c.getName();
        this.address = c.getAddress();
        this.description = c.getDescription();
        this.grade = c.getGrade();
        this.income = c.getIncome();
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
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

    public ClinicAdministrator getClinicAdministrator() {
        return clinicAdministrators.iterator().next();
    }

    public void setClinicAdministrators(Set<ClinicAdministrator> clinicAdministrators) {
        this.clinicAdministrators = clinicAdministrators;
    }
}
