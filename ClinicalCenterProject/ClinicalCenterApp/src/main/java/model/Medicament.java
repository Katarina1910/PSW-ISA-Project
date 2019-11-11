package model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Medicament {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    @JoinTable(name = "MedCd", joinColumns = @JoinColumn(name = "med_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "medCodeBook_id", referencedColumnName = "id"))
    private  Set<MedicamentCodeBook> medicamentCodeBooks;

    @Column
    private String name;

    @Column
    private String code;

    @ManyToMany
    @JoinTable(name = "MedPatient", joinColumns = @JoinColumn(name = "med_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "medRec_id", referencedColumnName = "id"))
    private Set<MedicalRecord> medicalRecords;

    public Medicament() {

    }

    public Medicament(String name, String code) {
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
