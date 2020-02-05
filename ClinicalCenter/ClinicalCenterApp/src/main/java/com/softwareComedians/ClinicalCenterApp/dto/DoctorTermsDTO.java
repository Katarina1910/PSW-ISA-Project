package com.softwareComedians.ClinicalCenterApp.dto;

import com.softwareComedians.ClinicalCenterApp.model.DoctorTerms;

public class DoctorTermsDTO {
    private Long id;
    boolean term1;
    boolean term2;
    boolean term3;
    boolean term4;
    String date;
    DoctorDTO doctorDTO;

    public DoctorTermsDTO() {

    }

    public DoctorTermsDTO(Long id, boolean term1, boolean term2, boolean term3, boolean term4, String date, DoctorDTO doc) {
        this.id = id;
        this.term1 = term1;
        this.term2 = term2;
        this.term3 = term3;
        this.term4 = term4;
        this.date = date;
        this.doctorDTO = doc;
    }

    public DoctorTermsDTO(DoctorTerms d) {
        this.id = d.getId();
        this.term1 = d.isTerm1();
        this.term2 = d.isTerm2();
        this.term3 = d.isTerm3();
        this.term4 = d.isTerm4();
        this.date = d.getDate();
        this.doctorDTO = new DoctorDTO(d.getDoctor());

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

    public DoctorDTO getDoctorDTO() {
        return doctorDTO;
    }

    public void setDoctorDTO(DoctorDTO doctorDTO) {
        this.doctorDTO = doctorDTO;
    }
}
