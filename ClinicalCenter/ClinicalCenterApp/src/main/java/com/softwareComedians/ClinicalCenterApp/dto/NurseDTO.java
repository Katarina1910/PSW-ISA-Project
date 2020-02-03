package com.softwareComedians.ClinicalCenterApp.dto;

import com.softwareComedians.ClinicalCenterApp.model.Nurse;
import com.softwareComedians.ClinicalCenterApp.model.User;

public class NurseDTO extends UserDTO {

    public NurseDTO() {
    }

    public NurseDTO(Long id, String name, String surname, String ucidn, String address, String city, String country, String email, String phone, String username, String password, String role, boolean isActivated) {
        super(id, name, surname, ucidn, address, city, country, email, phone, username, password, role, isActivated);
    }

    public NurseDTO(User u) {
        super(u);
    }

    public NurseDTO(Nurse d){
        super(d.getId(),d.getName(),d.getSurname(), d.getUcidn(),d.getAddress(),d.getCity(),d.getCountry(),d.getEmail(),
                d.getPhone(),d.getUsername(),d.getPassword(),d.getRole(),d.isActivated());
    }
}

