package com.softwareComedians.ClinicalCenterApp.controller;

import com.softwareComedians.ClinicalCenterApp.dto.DiagnosisDTO;
import com.softwareComedians.ClinicalCenterApp.model.Diagnosis;
import com.softwareComedians.ClinicalCenterApp.service.DiagnosisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "api/diagnosis")
@CrossOrigin
public class DiagnosisController {

   DiagnosisService diagnosisService;

    @Autowired
    public DiagnosisController(DiagnosisService diagnosisService){this.diagnosisService = diagnosisService;}

    @GetMapping(value = "/getAll")
    public ResponseEntity<List<DiagnosisDTO>> getAll(){

        List<Diagnosis> diagnosis = diagnosisService.findAll();
        List<DiagnosisDTO> diagnosisDTOS = new ArrayList<>();
        for(Diagnosis d:diagnosis){
            diagnosisDTOS.add(new DiagnosisDTO(d));
        }
        return new ResponseEntity<>(diagnosisDTOS, HttpStatus.OK);
    }

    @PostMapping()
    public  ResponseEntity<DiagnosisDTO> addDiagnosis(@RequestBody DiagnosisDTO diagnosisDTO){
        Diagnosis diagnosis = new Diagnosis(diagnosisDTO);
        diagnosis = diagnosisService.save(diagnosis);

        return new ResponseEntity<>(new DiagnosisDTO(diagnosis), HttpStatus.OK);
    }


    @DeleteMapping(value = "/del/{id}")
    public ResponseEntity<Long> deletePost(@PathVariable Long id){

        diagnosisService.remove(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @PutMapping(value = "/edit")
    public ResponseEntity<DiagnosisDTO> editDiagnosis (@RequestBody DiagnosisDTO diagnosisDTO) {
        Diagnosis d = diagnosisService.findOne(diagnosisDTO.getId());
        d.setName(diagnosisDTO.getName());
        d.setCode(diagnosisDTO.getCode());
        d.setDescription((diagnosisDTO.getDescription()));
        d = diagnosisService.save(d);

        return new ResponseEntity<>(new DiagnosisDTO(d), HttpStatus.OK);
    }
}
