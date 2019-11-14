package com.softwareComedians.ClinicalCenterApp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
public class Diagnosis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String code;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private DiagnosisCodebook diagnosisCodebook;


  //  private Set<MedicalRecord> medicalRecords;

    public Diagnosis() {
    }


}
