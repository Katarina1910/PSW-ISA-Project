package com.softwareComedians.ClinicalCenterApp.controller;


import com.softwareComedians.ClinicalCenterApp.common.consts.UserRoles;
import com.softwareComedians.ClinicalCenterApp.dto.ClinicAdminDTO;
import com.softwareComedians.ClinicalCenterApp.model.Authority;
import com.softwareComedians.ClinicalCenterApp.model.Clinic;
import com.softwareComedians.ClinicalCenterApp.model.ClinicAdministrator;
import com.softwareComedians.ClinicalCenterApp.repository.AuthorityRepository;
import com.softwareComedians.ClinicalCenterApp.service.ClinicAdminService;
import com.softwareComedians.ClinicalCenterApp.service.ClinicsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "api/clinicAdmins")
@CrossOrigin
public class ClinicAdminController {

    @Autowired
    ClinicAdminService clinicAdminService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    ClinicsService clinicsService;

    @Autowired
    private AuthorityRepository authorityRepository;

    @Autowired
    public ClinicAdminController(ClinicAdminService clinicAdminService){this.clinicAdminService = clinicAdminService;}

    @GetMapping(value = "/getAll")
    public ResponseEntity<List<ClinicAdminDTO>> getAll(){

        List<ClinicAdministrator> clinicAdmin = clinicAdminService.findAll();
        List<ClinicAdminDTO> clinicAdminDTO = new ArrayList<>();
        for(ClinicAdministrator ca : clinicAdmin){
            clinicAdminDTO.add(new ClinicAdminDTO(ca));
        }

        return new ResponseEntity<>(clinicAdminDTO, HttpStatus.OK);
    }

    @PostMapping()
    public  ResponseEntity<ClinicAdminDTO> addClinicAdmin(@RequestBody ClinicAdminDTO clinicAdminDTO){

        ClinicAdministrator clinicAdministrator = new ClinicAdministrator();

        clinicAdministrator.setId(clinicAdminDTO.getId());
        clinicAdministrator.setName(clinicAdminDTO.getName());
        clinicAdministrator.setSurname(clinicAdminDTO.getSurname());
        clinicAdministrator.setUcidn(clinicAdminDTO.getUcidn());
        clinicAdministrator.setAddress(clinicAdminDTO.getAddress());
        clinicAdministrator.setCity(clinicAdminDTO.getCity());
        clinicAdministrator.setCountry(clinicAdminDTO.getCountry());
        clinicAdministrator.setEmail(clinicAdminDTO.getEmail());
        clinicAdministrator.setPassword(passwordEncoder.encode(clinicAdminDTO.getPassword()));

        clinicAdministrator.setRole(UserRoles.ROLE_CA);
        clinicAdministrator.setActivated(true);
        Authority caAutority = authorityRepository.findByName(UserRoles.ROLE_CA);
        clinicAdministrator.getUsersAuthorities().add(caAutority);

        Clinic c = clinicsService.findById(clinicAdminDTO.getClinic().getId());
        clinicAdministrator.setClinic(c);
        clinicAdministrator = clinicAdminService.save(clinicAdministrator);

        return new ResponseEntity<>(new ClinicAdminDTO(clinicAdministrator), HttpStatus.OK);
    }
}
