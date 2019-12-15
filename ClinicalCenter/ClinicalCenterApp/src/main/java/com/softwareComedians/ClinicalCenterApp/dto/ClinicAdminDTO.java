package com.softwareComedians.ClinicalCenterApp.dto;

import com.softwareComedians.ClinicalCenterApp.model.ClinicAdministrator;
import com.softwareComedians.ClinicalCenterApp.model.User;

public class ClinicAdminDTO extends UserDTO {

    private String clinic;

    public ClinicAdminDTO(){

    }

    public ClinicAdminDTO(Long id, String name, String surname, String ucidn, String address, String city, String country, String email, String phone, String username, String password,String role, boolean isActivated, String clinic) {
        super(id, name, surname, ucidn, address, city, country, email, phone, username, password,role, isActivated);
        this.clinic = clinic;
    }

    public ClinicAdminDTO(User u, String clinic) {
        super(u);
        this.clinic = clinic;
    }

    public ClinicAdminDTO(ClinicAdministrator ca){
        super(ca.getId(), ca.getName(), ca.getSurname(), ca.getUcidn(), ca.getAddress(),
                ca.getCity(), ca.getCountry(), ca.getEmail(), ca.getPhone(), ca.getUsername(),ca.getPassword(), ca.getRole(),ca.isActivated());
       // this.clinic = new ClinicsDTO(ca.getClinic());
    }

    public String getClinic(){return clinic;}

    public void setClinic(String clinic){this.clinic = clinic;}
}
