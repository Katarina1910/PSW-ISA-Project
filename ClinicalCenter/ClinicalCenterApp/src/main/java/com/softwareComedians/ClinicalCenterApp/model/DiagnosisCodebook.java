package com.softwareComedians.ClinicalCenterApp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
public class DiagnosisCodebook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "diagnosisCodebook")
    private Set<Diagnosis> diagnoses;


    public DiagnosisCodebook() {
    }

    public Long getId() {
        return id;
    }

    public Set<Diagnosis> getDiagnoses() {
        return diagnoses;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDiagnoses(Set<Diagnosis> diagnoses) {
        this.diagnoses = diagnoses;
    }
}
