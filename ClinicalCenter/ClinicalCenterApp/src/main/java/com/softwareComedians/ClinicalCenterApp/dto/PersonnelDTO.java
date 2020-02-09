package com.softwareComedians.ClinicalCenterApp.dto;

import com.softwareComedians.ClinicalCenterApp.model.User;
import com.softwareComedians.ClinicalCenterApp.model.UserTokenState;

public class PersonnelDTO extends UserDTO {

    public PersonnelDTO() {
    }

    public PersonnelDTO(Long id, String name, String surname, String ucidn, String address, String city, String country,
                        String email, String phone, String username, String password, String role, boolean isActivated, UserTokenState token) {
        super(id, name, surname, ucidn, address, city, country, email, phone, username, password, role, isActivated, token);
    }

    public PersonnelDTO(User u) {
        super(u);
    }
}
