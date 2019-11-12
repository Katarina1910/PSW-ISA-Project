package model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Doctor extends Personnel {
    @Column
    private Double grade;

    @OneToMany(mappedBy = "applicant", fetch = FetchType.EAGER , cascade = CascadeType.ALL)
    private Set<RequstForOperation> requstForOperations;

    @ManyToMany
    @JoinTable(name = "DocOp", joinColumns = @JoinColumn(name = "doc_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "op_id", referencedColumnName = "id"))
    private Set<Operation> operations;

    public Doctor() {
    }

    public Doctor(double grade) {
        this.grade = grade;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }
}
