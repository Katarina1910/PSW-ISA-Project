package com.softwareComedians.ClinicalCenterApp.controller;

import com.softwareComedians.ClinicalCenterApp.dto.ConsultTypeDTO;
import com.softwareComedians.ClinicalCenterApp.model.ConsultType;
import com.softwareComedians.ClinicalCenterApp.service.ConsultTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/ConsultType")
@CrossOrigin
public class ConsultTypeController {

    ConsultTypeService consultTypeService;

    @Autowired
    public ConsultTypeController(ConsultTypeService consultTypeService){
        this.consultTypeService=consultTypeService;
    }


    @PostMapping()
    public ResponseEntity<ConsultTypeDTO> addConsultType(@RequestBody ConsultTypeDTO consultTypeDTO) {
        ConsultType ct = new ConsultType(consultTypeDTO);
        ct = consultTypeService.save(ct);
        return new ResponseEntity<>(new ConsultTypeDTO(ct), HttpStatus.CREATED);
    }

}
