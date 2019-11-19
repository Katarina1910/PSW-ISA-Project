package com.softwareComedians.ClinicalCenterApp.controller;

import com.softwareComedians.ClinicalCenterApp.dto.ConsultTermDTO;
import com.softwareComedians.ClinicalCenterApp.dto.RequestForConsultDTO;
import com.softwareComedians.ClinicalCenterApp.model.ConsultTerm;
import com.softwareComedians.ClinicalCenterApp.model.RequestForConsult;
import com.softwareComedians.ClinicalCenterApp.service.ConsultTermService;
import com.softwareComedians.ClinicalCenterApp.service.RequestForConsultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/ConsultTerm")
@CrossOrigin
public class ConsultTermController {

    @Autowired
    private ConsultTermService consultTermService;

    @PostMapping()
    public ResponseEntity<ConsultTermDTO> createConsultTerm(@RequestBody ConsultTermDTO consultTermDTO) {

        ConsultTerm ct = new ConsultTerm();
        ct.setId(consultTermDTO.getId());
        ct.setType(consultTermDTO.getType());
        ct.setDuration(consultTermDTO.getDuration());
        ct.setDiscount(consultTermDTO.getDiscount());
        ct.setPrice(consultTermDTO.getPrice());

        ct = consultTermService.save(ct);
        return new ResponseEntity<>(new ConsultTermDTO(ct), HttpStatus.CREATED);
    }
}
