package com.softwareComedians.ClinicalCenterApp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;
@Entity
@Getter
@Setter
public class MedicamentCodeBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   // @ManyToMany(mappedBy = "MedCd")
  //  private Set<Medicament> medicamentCodeBook;

    @OneToOne(mappedBy = "medicamentCodebook")
    private ClinicalCenter clinicalCenter;

    public MedicamentCodeBook() {
    }

}
