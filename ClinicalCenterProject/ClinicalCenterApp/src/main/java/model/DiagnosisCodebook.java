package model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Set;

@Entity
public class DiagnosisCodebook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL,mappedBy = "diagnosisCodebook")
    private Set<Diagnosis> diagnoses;


    private ClinicalCenter clinicalCenter;

    public DiagnosisCodebook() {
    }

    public Set<Diagnosis> getDiagnoses() {
        return diagnoses;
    }

    public void setDiagnoses(Set<Diagnosis> diagnoses) {
        this.diagnoses = diagnoses;
    }

    public ClinicalCenter getClinicalCenter() {
        return clinicalCenter;
    }

    public void setClinicalCenter(ClinicalCenter clinicalCenter) {
        this.clinicalCenter = clinicalCenter;
    }
}
