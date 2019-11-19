package com.softwareComedians.ClinicalCenterApp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
public class Medicament {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   // @ManyToMany
    //@JoinTable(name = "MedCd", joinColumns = @JoinColumn(name = "med_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "medCodeBook_id", referencedColumnName = "id"))
   // private  Set<MedicamentCodeBook> medicamentCodeBooks;

    @Column
    private String name;

    @Column
    private String code;

    @OneToOne(mappedBy = "medicament")
    private  Recipe recipe;

   // @ManyToMany
    //@JoinTable(name = "MedPatient", joinColumns = @JoinColumn(name = "med_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "medRec_id", referencedColumnName = "id"))
  //  private Set<MedicalRecord> medicalRecords;

    public Medicament() {

    }

}
