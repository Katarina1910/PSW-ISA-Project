package com.softwareComedians.ClinicalCenterApp.model;

import com.softwareComedians.ClinicalCenterApp.dto.MedicamentDTO;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
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

    @Column
    private String description;

    @ManyToMany(mappedBy = "medicaments")
    public Set<Recipe> recipes;

   // @ManyToMany
    //@JoinTable(name = "MedPatient", joinColumns = @JoinColumn(name = "med_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "medRec_id", referencedColumnName = "id"))
  //  private Set<MedicalRecord> medicalRecords;



    public Medicament(MedicamentDTO m){
        this.name = m.getName();
        this.id = m.getId();
        this.code = m.getCode();
        this.description = m.getDescription();
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
