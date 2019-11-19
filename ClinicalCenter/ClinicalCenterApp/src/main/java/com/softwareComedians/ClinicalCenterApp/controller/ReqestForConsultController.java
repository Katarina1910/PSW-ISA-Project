package com.softwareComedians.ClinicalCenterApp.controller;

import com.softwareComedians.ClinicalCenterApp.dto.RequestForConsultDTO;
import com.softwareComedians.ClinicalCenterApp.dto.UserDTO;
import com.softwareComedians.ClinicalCenterApp.model.RequestForConsult;
import com.softwareComedians.ClinicalCenterApp.model.User;
import com.softwareComedians.ClinicalCenterApp.service.RequestForConsultService;
import com.softwareComedians.ClinicalCenterApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/rqForConsult")
@CrossOrigin
public class ReqestForConsultController {

    @Autowired
    private RequestForConsultService requestForConsultService;

    @PostMapping()
    public ResponseEntity<RequestForConsultDTO> createRequest(@RequestBody RequestForConsultDTO requestForConsultDTO) {

        RequestForConsult rq = new RequestForConsult();
        rq.setId(requestForConsultDTO.getId());
        rq.setDateAndTime(requestForConsultDTO.getDateAndTime());
        rq.setType(requestForConsultDTO.getType());

        rq = requestForConsultService.save(rq);
        return new ResponseEntity<>(new RequestForConsultDTO(rq), HttpStatus.CREATED);
    }
}
