package com.softwareComedians.ClinicalCenterApp.model;

import com.softwareComedians.ClinicalCenterApp.dto.DoctorDTO;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
public class Doctor extends Personnel {

    @Autowired
    @Transient
    private PasswordEncoder passwordEncoder;

    @Column
    private Double grade;

  //  @OneToMany(mappedBy = "applicant", fetch = FetchType.LAZY , cascade = CascadeType.ALL)
   // private Set<RequstForOperation> requstForOperations;
    @Column
    private Double typeId;

    //@OneToMany(mappedBy = "applicant", fetch = FetchType.LAZY , cascade = CascadeType.ALL)
   // private Set<RequstForOperation> requstForOperations;

    @OneToMany(mappedBy = "doctor", fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    private Set<ConsultTerm> consultTerms;

    @OneToMany(mappedBy = "doctor", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public Set<Recipe> recipes;

  //  @ManyToMany
  //  @JoinTable(name = "DocOp", joinColumns = @JoinColumn(name = "doc_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "op_id", referencedColumnName = "id"))
   // private Set<Operation> operations;

    public Doctor() {
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }

    public Double getTypeId() {
        return typeId;
    }

    public void setTypeId(Double typeId) {
        this.typeId = typeId;
    }

    public Doctor(DoctorDTO d){
        this.setId(d.getId());
        this.setName(d.getName());
        this.setSurname((d.getSurname()));
        this.setUcidn(d.getUcidn());
        this.setEmail(d.getEmail());
        this.setPassword(passwordEncoder.encode(d.getPassword()));
        this.setUsername(d.getUsername());
        this.setPhone(d.getPhone());
        this.setAddress(d.getAddress());
        this.setCity(d.getCity());
        this.setCountry(d.getCountry());
        this.setActivated(d.isActivated());
        this.grade = 0.0;
        this.typeId = null;
        this.setRole("DOCTOR");

    }


}
