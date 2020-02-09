package com.softwareComedians.ClinicalCenterApp.controller;


import com.softwareComedians.ClinicalCenterApp.dto.ClinicAdminDTO;
import com.softwareComedians.ClinicalCenterApp.model.ClinicAdministrator;
import com.softwareComedians.ClinicalCenterApp.service.ClinicAdminService;
import com.softwareComedians.ClinicalCenterApp.service.ClinicsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    ClinicsService clinicsService;


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
        ClinicAdministrator clinicAdministrator = clinicAdminService.addNew(clinicAdminDTO);
        return new ResponseEntity<>(new ClinicAdminDTO(clinicAdministrator), HttpStatus.OK);
    }
}
