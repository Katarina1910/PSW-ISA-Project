package com.softwareComedians.ClinicalCenterApp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

//@Entity
@Getter
@Setter
public class DiagnosisCodebook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

  //  @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL,mappedBy = "diagnosisCodebook")
   // private Set<Diagnosis> diagnoses;

    @Column
    private ClinicalCenter clinicalCenter;

    public DiagnosisCodebook() {
    }

}
