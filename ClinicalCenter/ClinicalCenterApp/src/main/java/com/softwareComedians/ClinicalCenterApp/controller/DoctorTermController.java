package com.softwareComedians.ClinicalCenterApp.controller;

import com.softwareComedians.ClinicalCenterApp.dto.DoctorTermsDTO;
import com.softwareComedians.ClinicalCenterApp.service.DoctorTermsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/doctorTerms")
@CrossOrigin
public class DoctorTermController {
    DoctorTermsService doctorTermsService;

    @Autowired
    public DoctorTermController(DoctorTermsService doctorTermsService){
        this.doctorTermsService=doctorTermsService;
    }

    @GetMapping(value = "/getAllDate/{date}/{term}")
    public ResponseEntity<List<DoctorTermsDTO>> getAllDateTerm(@PathVariable String date, @PathVariable String term) {
        List<DoctorTermsDTO> dtos =doctorTermsService.getAllDateTerm(date,term);
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }
}
