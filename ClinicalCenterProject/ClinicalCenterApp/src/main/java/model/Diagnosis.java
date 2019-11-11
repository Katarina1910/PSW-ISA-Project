package model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Diagnosis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String code;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private DiagnosisCodebook diagnosisCodebook;

    @ManyToMany
    @JoinTable(name = "diagAtMedRec", joinColumns = @JoinColumn(name = "diagnosis_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "medRec_id", referencedColumnName = "id"))
    private Set<MedicalRecord> medicalRecords;

    public Diagnosis() {
    }

    public Diagnosis(String name, String code) {
        this.name = name;
        this.code = code;
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
}
