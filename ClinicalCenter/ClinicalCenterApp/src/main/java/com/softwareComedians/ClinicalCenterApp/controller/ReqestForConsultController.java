package com.softwareComedians.ClinicalCenterApp.controller;

import com.softwareComedians.ClinicalCenterApp.dto.RequestForConsultDTO;
import com.softwareComedians.ClinicalCenterApp.mail.SmtpMailSender;
import com.softwareComedians.ClinicalCenterApp.model.RequestForConsult;
import com.softwareComedians.ClinicalCenterApp.service.ConsultTypeService;
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

    @Autowired
    private ConsultTypeService consultTypeService;

    @Autowired
    private UserService userService;

    @Autowired
    private SmtpMailSender smtpMailSender;

    @PostMapping()
    public ResponseEntity<RequestForConsultDTO> createRequest(@RequestBody RequestForConsultDTO requestForConsultDTO) {

        RequestForConsult rq = new RequestForConsult();
        rq.setId(requestForConsultDTO.getId());
       // rq.setDateAndTime(requestForConsultDTO.getDateAndTime());
        rq.setType(consultTypeService.findOne(requestForConsultDTO.getType().getId()));
       // rq.setPatient(userService.findById(requestForConsultDTO.getPatient().getId()));

        rq = requestForConsultService.save(rq);
        return new ResponseEntity<>(new RequestForConsultDTO(rq), HttpStatus.CREATED);
    }

    @PostMapping(value = "doctor")
    public ResponseEntity<RequestForConsultDTO> createRequestDoctor(@RequestBody RequestForConsultDTO requestForConsultDTO) {

        RequestForConsult rq = new RequestForConsult();
        rq.setId(requestForConsultDTO.getId());
        // rq.setDateAndTime(requestForConsultDTO.getDateAndTime());
        rq.setType(consultTypeService.findOne(requestForConsultDTO.getType().getId()));
        rq.setPatient(userService.findById(requestForConsultDTO.getPatient().getId()));
        //send mail, getPatient.getClicic.getAdmin.getMail
        //smtpMailSender.send(requestForConsultDTO.get,"Registration", description);

        rq = requestForConsultService.save(rq);
        return new ResponseEntity<>(new RequestForConsultDTO(rq), HttpStatus.CREATED);
    }
}
