package com.softwareComedians.ClinicalCenterApp.dto;

import com.softwareComedians.ClinicalCenterApp.model.Doctor;
import com.softwareComedians.ClinicalCenterApp.model.User;

public class DoctorDTO extends UserDTO {
    private Double grade;
    private Double typeId;

    public DoctorDTO() {
    }

    public DoctorDTO(Long id, String name, String surname, String ucidn, String address, String city, String country, String email, String phone, String userName, String password, String role,boolean isActivated, Double grade, Double typeId) {
        super(id, name, surname, ucidn, address, city, country, email, phone, userName, password,role, isActivated);
        this.grade = grade;
        this.typeId = typeId;
    }

    public DoctorDTO(User u, Double grade, Double typeId) {
        super(u);
        this.grade = grade;
        this.typeId = typeId;
    }

    public DoctorDTO(Doctor d){
        super(d.getId(),d.getName(),d.getSurname(), d.getUcidn(),d.getAddress(),d.getCity(),d.getCountry(),d.getEmail(),
                d.getPhone(),d.getUsername(),d.getPassword(),d.getRole(),d.isActivated());
        this.grade = d.getGrade();
        this.typeId = d.getTypeId();
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
}
