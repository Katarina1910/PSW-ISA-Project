package com.softwareComedians.ClinicalCenterApp.controller;


import com.softwareComedians.ClinicalCenterApp.dto.MedicalRecordDTO;
import com.softwareComedians.ClinicalCenterApp.model.MedicalRecord;
import com.softwareComedians.ClinicalCenterApp.service.MedicalRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/medicalRecord")
@CrossOrigin
public class MedicalRecordController {

    MedicalRecordService medicalRecordService;

    @Autowired
    public MedicalRecordController(MedicalRecordService medicalRecordService){
        this.medicalRecordService = medicalRecordService;
    }

    @GetMapping(value = "/get/{id}")
    public ResponseEntity<MedicalRecordDTO> get(@PathVariable Long id){

        MedicalRecordDTO medicalRecordDTO = medicalRecordService.getByUserId(id);
        return new ResponseEntity<>(medicalRecordDTO, HttpStatus.OK);
    }

}
