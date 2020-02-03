package com.softwareComedians.ClinicalCenterApp.dto;

import com.softwareComedians.ClinicalCenterApp.model.Doctor;
import com.softwareComedians.ClinicalCenterApp.model.User;

public class DoctorDTO extends UserDTO {
    private Double grade;
    private Double typeId;
    private  Long clinic;

    public DoctorDTO() {
    }

    public DoctorDTO(Long id, String name, String surname, String ucidn, String address, String city, String country, String email, String phone, String userName, String password, String role,boolean isActivated, Double grade, Double typeId, Long clinic) {
        super(id, name, surname, ucidn, address, city, country, email, phone, userName, password,role, isActivated);
        this.grade = grade;
        this.typeId = typeId;
        this.clinic = clinic;
    }

    public DoctorDTO(User u, Double grade, Double typeId, Long clinic) {
        super(u);
        this.grade = grade;
        this.typeId = typeId;
        this.clinic = clinic;
    }

    public DoctorDTO(Doctor d){
        super(d.getId(),d.getName(),d.getSurname(), d.getUcidn(),d.getAddress(),d.getCity(),d.getCountry(),d.getEmail(),
                d.getPhone(),d.getUsername(),d.getPassword(),d.getRole(),d.isActivated());
        this.grade = d.getGrade();
        this.typeId = d.getTypeId();
        this.clinic = d.getClinic().getId();
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

    public Long getClinic() {
        return clinic;
    }

    public void setClinic(Long clinic) {
        this.clinic = clinic;
    }
}
