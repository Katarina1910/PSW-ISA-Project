package com.softwareComedians.ClinicalCenterApp.model;


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

}
