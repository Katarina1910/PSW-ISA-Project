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

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "priceList_id", referencedColumnName = "id")
     private PriceList priceList;

    @OneToMany(mappedBy = "clinic", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<ConsultTerm> freeConsultTerms;

    @OneToMany(mappedBy = "clinic", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<ConsultTerm> appointedConsultTerms;

    @OneToMany(mappedBy = "clinic", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Personnel> personnels;

    @OneToMany(mappedBy = "clinic", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Patient> patients;

   @OneToMany(mappedBy = "clinic", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Room> rooms;


    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "clinic")
    private Set<ClinicAdministrator> clinicAdministrators;

    public Clinic() {

    }

    public Clinic(ClinicsDTO c){
        this.id = c.getId();
        this.name = c.getName();
        this.address = c.getAddress();
        this.description = c.getDescription();
        this.grade = c.getGrade();
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
}
