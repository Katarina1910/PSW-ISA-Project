package com.softwareComedians.ClinicalCenterApp.controller;


import com.softwareComedians.ClinicalCenterApp.dto.ClinicsDTO;
import com.softwareComedians.ClinicalCenterApp.model.Clinic;
import com.softwareComedians.ClinicalCenterApp.model.ClinicAdministrator;
import com.softwareComedians.ClinicalCenterApp.service.ClinicAdminService;
import com.softwareComedians.ClinicalCenterApp.service.ClinicsService;
import com.softwareComedians.ClinicalCenterApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "api/clinics")
@CrossOrigin
public class ClinicsController {

    @Autowired
    ClinicsService clinicsService;

    @Autowired
    UserService userService;

    @Autowired
    ClinicAdminService clinicAdminService;

    @Autowired
    public ClinicsController(ClinicsService clinicsService){
        this.clinicsService = clinicsService;
    }

    @GetMapping(value = "/getAll")
    //@PreAuthorize("hasRole('ROLE_PATIENT')")
    public ResponseEntity<List<ClinicsDTO>> getAll(){

        List<Clinic> clinics = clinicsService.findAll();
        List<ClinicsDTO> clinicsDTO = new ArrayList<>();
        for(Clinic c : clinics){
            clinicsDTO.add(new ClinicsDTO(c));
        }

        return new ResponseEntity<>(clinicsDTO, HttpStatus.OK);
    }

   @GetMapping(value = "/get/{id}")
    public ResponseEntity<ClinicsDTO> getOne(@PathVariable Long id){

        ClinicAdministrator ca = clinicAdminService.findById(id);
      ClinicsDTO c = new ClinicsDTO(ca.getClinic());
      System.out.println(c.getAddress());
        return new ResponseEntity<>(c, HttpStatus.OK);
    }

    @PostMapping()
    public  ResponseEntity<ClinicsDTO> addClinics(@RequestBody ClinicsDTO clinicsDTO){
        Clinic clinic = new Clinic(clinicsDTO);
        clinic.setIncome(0);
        clinic = clinicsService.save(clinic);

        return new ResponseEntity<>(new ClinicsDTO(clinic), HttpStatus.OK);
    }

    @DeleteMapping(value = "/del/{id}")
    public ResponseEntity<Long> deletePost(@PathVariable Long id){

        clinicsService.remove(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @PutMapping(value = "/edit")
    public ResponseEntity<ClinicsDTO> editClinic (@RequestBody ClinicsDTO clinicsDTO) {
        Clinic clinic = clinicsService.findOne(clinicsDTO.getId());
        clinic.setName(clinicsDTO.getName());
        clinic.setAddress(clinicsDTO.getAddress());
        clinic.setDescription(clinicsDTO.getDescription());
        clinic = clinicsService.save(clinic);

        return new ResponseEntity<>(new ClinicsDTO(clinic), HttpStatus.OK);
    }
}
