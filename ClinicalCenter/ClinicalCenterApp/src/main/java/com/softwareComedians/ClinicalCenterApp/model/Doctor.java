package com.softwareComedians.ClinicalCenterApp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
public class Doctor extends Personnel {
    @Column
    private Double grade;

    @OneToMany(mappedBy = "applicant", fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    private Set<RequstForOperation> requstForOperations;

  //  @ManyToMany
  //  @JoinTable(name = "DocOp", joinColumns = @JoinColumn(name = "doc_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "op_id", referencedColumnName = "id"))
   // private Set<Operation> operations;

    public Doctor() {
    }

}
