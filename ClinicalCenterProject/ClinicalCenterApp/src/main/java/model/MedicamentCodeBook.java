package model;

import javax.persistence.*;
import java.util.Set;
@Entity
public class MedicamentCodeBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(mappedBy = "MedCd")
    private Set<Medicament> medicamentCodeBook;

    private ClinicalCenter clinicalCenter;

    public MedicamentCodeBook() {
    }

    public Set<Medicament> getMedicamentCodeBook() {
        return medicamentCodeBook;
    }

    public void setMedicamentCodeBook(Set<Medicament> medicamentCodeBook) {
        this.medicamentCodeBook = medicamentCodeBook;
    }

    public ClinicalCenter getClinicalCenter() {
        return clinicalCenter;
    }

    public void setClinicalCenter(ClinicalCenter clinicalCenter) {
        this.clinicalCenter = clinicalCenter;
    }
}
