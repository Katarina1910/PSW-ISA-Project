package com.softwareComedians.ClinicalCenterApp.model;

import com.softwareComedians.ClinicalCenterApp.dto.DiagnosisDTO;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Diagnosis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String code;

    @Column
    private String description;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private DiagnosisCodebook diagnosisCodebook;

    @OneToMany(mappedBy = "diagnosis")
    public Set<Consult> consults;



  //  private Set<MedicalRecord> medicalRecords;


    public Long getId() {
        return id;
    }

    public Diagnosis(String name, String code, String description, DiagnosisCodebook diagnosisCodebook) {
        this.name = name;
        this.code = code;
        this.description = description;
        this.diagnosisCodebook = diagnosisCodebook;
    }

    public Diagnosis(String name, String code, String description) {
        this.name = name;
        this.code = code;
        this.description = description;
    }

    public Diagnosis(DiagnosisDTO d){
        this.name = d.getName();
        this.id = d.getId();
        this.code = d.getCode();
        this.description = d.getDescription();
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public DiagnosisCodebook getDiagnosisCodebook() {
        return diagnosisCodebook;
    }

    public void setDiagnosisCodebook(DiagnosisCodebook diagnosisCodebook) {
        this.diagnosisCodebook = diagnosisCodebook;
    }
}
