package com.softwareComedians.ClinicalCenterApp.model;

import javax.persistence.*;

@Entity
public class DoctorTerms {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    boolean term1;

    @Column
    boolean term2;

    @Column
    boolean term3;

    @Column
    boolean term4;

    @Column
    boolean term5;

    @Column
    boolean term6;

    @Column
    String date;

    @ManyToOne(fetch = FetchType.LAZY)
    Doctor doctor;

    public DoctorTerms() {
        term1=true;
        term2= true;
        term3=true;
        term4=true;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isTerm1() {
        return term1;
    }

    public void setTerm1(boolean term1) {
        this.term1 = term1;
    }

    public boolean isTerm2() {
        return term2;
    }

    public void setTerm2(boolean term2) {
        this.term2 = term2;
    }

    public boolean isTerm3() {
        return term3;
    }

    public void setTerm3(boolean term3) {
        this.term3 = term3;
    }

    public boolean isTerm4() {
        return term4;
    }

    public void setTerm4(boolean term4) {
        this.term4 = term4;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public boolean isTerm5() {
        return term5;
    }

    public void setTerm5(boolean term5) {
        this.term5 = term5;
    }

    public boolean isTerm6() {
        return term6;
    }

    public void setTerm6(boolean term6) {
        this.term6 = term6;
    }
}
