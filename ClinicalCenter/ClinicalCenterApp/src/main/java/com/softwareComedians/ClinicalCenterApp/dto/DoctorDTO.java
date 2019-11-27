package com.softwareComedians.ClinicalCenterApp.dto;

import com.softwareComedians.ClinicalCenterApp.model.Doctor;
import com.softwareComedians.ClinicalCenterApp.model.User;

public class DoctorDTO extends UserDTO {
    private Double grade;

    public DoctorDTO() {
    }

    public DoctorDTO(Long id, String name, String surname, String ucidn, String address, String city, String country, String email, String phone, String userName, String password, boolean isActivated, Double grade) {
        super(id, name, surname, ucidn, address, city, country, email, phone, userName, password, isActivated);
        this.grade = grade;
    }

    public DoctorDTO(User u, Double grade) {
        super(u);
        this.grade = grade;
    }

    public DoctorDTO(Doctor d){
        super(d.getId(),d.getName(),d.getSurname(), d.getUcidn(),d.getAddress(),d.getCity(),d.getCountry(),d.getEmail(),
                d.getPhone(),d.getUsername(),d.getPassword(),d.isActivated());
        this.grade = d.getGrade();
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }
}
