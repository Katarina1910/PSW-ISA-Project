package com.softwareComedians.ClinicalCenterApp.controller;

import com.softwareComedians.ClinicalCenterApp.dto.RequestForPatientRegistrationDTO;
import com.softwareComedians.ClinicalCenterApp.model.RequestForPatientRegistration;
import com.softwareComedians.ClinicalCenterApp.service.RequestForPatientRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/RqForPatientReg")
@CrossOrigin
public class RequestForPatientRegistrationController {


    @Autowired
    private RequestForPatientRegistrationService requestForPatientRegistrationService;

    @PostMapping()
    public ResponseEntity<RequestForPatientRegistrationDTO> createRqForPatientReg(@RequestBody RequestForPatientRegistrationDTO rqDTO) {

        RequestForPatientRegistration rq = new RequestForPatientRegistration();
        rq.setId(rqDTO.getId());
        rq.setAccepted(rqDTO.isAccepted());
        rq.setReasonOfRejection(rq.getReasonOfRejection());
        rq.setUserData(rq.getUserData());

        rq = requestForPatientRegistrationService.save(rq);
        return new ResponseEntity<>(new RequestForPatientRegistrationDTO(rq), HttpStatus.CREATED);
    }
}
