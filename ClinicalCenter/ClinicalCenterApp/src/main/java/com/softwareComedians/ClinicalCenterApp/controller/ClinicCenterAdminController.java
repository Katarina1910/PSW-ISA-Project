package com.softwareComedians.ClinicalCenterApp.controller;


import com.softwareComedians.ClinicalCenterApp.dto.ClinicCenterAdminDTO;
import com.softwareComedians.ClinicalCenterApp.model.ClinicCenterAdministrator;
import com.softwareComedians.ClinicalCenterApp.repository.AuthorityRepository;
import com.softwareComedians.ClinicalCenterApp.service.ClinicCenterAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "api/clinicCenterAdmins")
@CrossOrigin
public class ClinicCenterAdminController {

    @Autowired
    ClinicCenterAdminService clinicCenterAdminService;

    @Autowired
    private AuthorityRepository authorityRepository;

    @GetMapping(value="/getAll")
    public ResponseEntity<List<ClinicCenterAdminDTO>> getAll(){

        List<ClinicCenterAdministrator> clinicCenterAdministrators = clinicCenterAdminService.findAll();
        List<ClinicCenterAdminDTO> clinicCenterAdminDTO = new ArrayList<>();

        for(ClinicCenterAdministrator cca: clinicCenterAdministrators){
            clinicCenterAdminDTO.add(new ClinicCenterAdminDTO(cca));
        }

        return new ResponseEntity<>(clinicCenterAdminDTO, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<ClinicCenterAdminDTO> addClinicCenterAdmin(@RequestBody ClinicCenterAdminDTO clinicCenterAdminDTO){

        ClinicCenterAdministrator clinicCenterAdministrator = new ClinicCenterAdministrator(clinicCenterAdminDTO);
        clinicCenterAdministrator = clinicCenterAdminService.save(clinicCenterAdministrator);

        return new ResponseEntity<>(new ClinicCenterAdminDTO(clinicCenterAdministrator), HttpStatus.OK);
    }

}
