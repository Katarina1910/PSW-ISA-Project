package com.softwareComedians.ClinicalCenterApp.controller;

import com.softwareComedians.ClinicalCenterApp.dto.RequestForOperationDTO;
import com.softwareComedians.ClinicalCenterApp.mail.SmtpMailSender;
import com.softwareComedians.ClinicalCenterApp.model.RequstForOperation;
import com.softwareComedians.ClinicalCenterApp.service.RqForOperationService;
import com.softwareComedians.ClinicalCenterApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/rqForOperation")
@CrossOrigin
public class RqForOperationController {
    @Autowired
    private RqForOperationService rqForOperationService;


    @Autowired
    private UserService userService;

    @Autowired
    private SmtpMailSender smtpMailSender;

    @PostMapping()
    public ResponseEntity<RequestForOperationDTO> createRequest(@RequestBody RequestForOperationDTO requestForOperationDTO) {

        RequstForOperation rq = new RequstForOperation();
        rq.setId(requestForOperationDTO.getId());
        // rq.setDateAndTime(requestForOPerationDTO.getDateAndTime());
        // rq.setPatient(userService.findById(requestForOperationDTO.getPatient().getId()));

        rq = rqForOperationService.save(rq);
        return new ResponseEntity<>(new RequestForOperationDTO(rq), HttpStatus.CREATED);
    }

    @PostMapping(value = "doctor")
    public ResponseEntity<RequestForOperationDTO> createRequestDoctor(@RequestBody RequestForOperationDTO requestForOperationDTO) {

        RequstForOperation rq = new RequstForOperation();
        rq.setId(requestForOperationDTO.getId());
        System.out.println(requestForOperationDTO.getPatient().getName());
        // rq.setDateAndTime(requestForConsultDTO.getDateAndTime());
        rq.setPatient(userService.findById(requestForOperationDTO.getPatient().getId()));
        //send mail, getPatient.getClicic.getAdmin.getMail
        //smtpMailSender.send(requestForConsultDTO.get,"Registration", description);

        rq = rqForOperationService.save(rq);
        return new ResponseEntity<>(new RequestForOperationDTO(rq), HttpStatus.CREATED);
    }
}
