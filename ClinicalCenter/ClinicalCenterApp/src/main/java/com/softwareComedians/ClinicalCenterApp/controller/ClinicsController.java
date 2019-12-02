package com.softwareComedians.ClinicalCenterApp.controller;


import com.softwareComedians.ClinicalCenterApp.dto.ClinicsDTO;
import com.softwareComedians.ClinicalCenterApp.model.Clinic;
import com.softwareComedians.ClinicalCenterApp.service.impl.ClinicsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "api/clinics")
@CrossOrigin
public class ClinicsController {

    ClinicsService clinicsService;

    @Autowired
    public ClinicsController(ClinicsService clinicsService){
        this.clinicsService = clinicsService;
    }

    @GetMapping(value = "/getAll")
    public ResponseEntity<List<ClinicsDTO>> getAll(){

        List<Clinic> clinics = clinicsService.findAll();
        List<ClinicsDTO> clinicsDTO = new ArrayList<>();
        for(Clinic c : clinics){
            clinicsDTO.add(new ClinicsDTO(c));
        }

        return new ResponseEntity<>(clinicsDTO, HttpStatus.OK);
    }

    @PostMapping()
    public  ResponseEntity<ClinicsDTO> addClinics(@RequestBody ClinicsDTO clinicsDTO){
        Clinic clinic = new Clinic();

        clinic.setName(clinicsDTO.getName());
        clinic.setAddress(clinicsDTO.getAddress());
        clinic.setDescription(clinicsDTO.getDescription());
        clinic.setGrade(clinicsDTO.getGrade());

        clinic = clinicsService.save(clinic);

        return new ResponseEntity<>(new ClinicsDTO(clinic), HttpStatus.OK);
    }

    @DeleteMapping(value = "/del/{name}")
    public ResponseEntity<String> deletePost(@PathVariable String name){

        clinicsService.remove(name);
        return new ResponseEntity<>(name, HttpStatus.OK);
    }
}
