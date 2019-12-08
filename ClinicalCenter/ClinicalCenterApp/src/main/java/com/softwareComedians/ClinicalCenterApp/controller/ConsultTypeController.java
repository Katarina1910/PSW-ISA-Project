package com.softwareComedians.ClinicalCenterApp.controller;

import com.softwareComedians.ClinicalCenterApp.dto.ConsultTypeDTO;
import com.softwareComedians.ClinicalCenterApp.model.ConsultType;
import com.softwareComedians.ClinicalCenterApp.service.ConsultTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "api/ConsultType")
@CrossOrigin
public class ConsultTypeController {

    ConsultTypeService consultTypeService;

    @Autowired
    public ConsultTypeController(ConsultTypeService consultTypeService){
        this.consultTypeService=consultTypeService;
    }

    @GetMapping(value = "/getAll")
    public ResponseEntity<List<ConsultTypeDTO>> getAll() {

        List<ConsultType> consultTypes = consultTypeService.findAll();
        List<ConsultTypeDTO> consultTypeDTOS= new ArrayList<>();
        for (ConsultType d : consultTypes) {
            consultTypeDTOS.add(new ConsultTypeDTO(d));
        }

        return new ResponseEntity<>(consultTypeDTOS, HttpStatus.OK);
    }
    @PostMapping()
    public ResponseEntity<ConsultTypeDTO> addConsultType(@RequestBody ConsultTypeDTO consultTypeDTO) {
        ConsultType ct = new ConsultType(consultTypeDTO);
        ct = consultTypeService.save(ct);
        return new ResponseEntity<>(new ConsultTypeDTO(ct), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/del/{id}")
    public ResponseEntity<Long> deleteConsultType(@PathVariable Long id) {

        consultTypeService.remove(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

}
