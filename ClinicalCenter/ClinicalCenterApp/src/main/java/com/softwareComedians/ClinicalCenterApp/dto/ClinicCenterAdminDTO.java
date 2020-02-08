package com.softwareComedians.ClinicalCenterApp.dto;

import com.softwareComedians.ClinicalCenterApp.model.ClinicCenterAdministrator;
import com.softwareComedians.ClinicalCenterApp.model.User;
import com.softwareComedians.ClinicalCenterApp.model.UserTokenState;

public class ClinicCenterAdminDTO extends UserDTO {

    public ClinicCenterAdminDTO() {
    }

    public ClinicCenterAdminDTO(Long id, String name, String surname, String ucidn, String address, String city,
                                String country, String email, String phone, String username, String password,
                                String role, boolean isActivated, UserTokenState token) {
        super(id, name, surname, ucidn, address, city, country, email, phone, username, password, role, isActivated, token);
    }

    public ClinicCenterAdminDTO(User u) {
        super(u);
    }

    public ClinicCenterAdminDTO(ClinicCenterAdministrator ca){
        super(ca.getId(), ca.getName(), ca.getSurname(), ca.getUcidn(), ca.getAddress(),
                ca.getCity(), ca.getCountry(), ca.getEmail(), ca.getPhone(), ca.getUsername(),ca.getPassword(),
                ca.getRole(),ca.isActivated(), null);
    }
}

