package com.softwareComedians.ClinicalCenterApp.controller;

import com.softwareComedians.ClinicalCenterApp.dto.RequestForPatientRegistrationDTO;
import com.softwareComedians.ClinicalCenterApp.model.ConfirmationToken;
import com.softwareComedians.ClinicalCenterApp.model.RequestForPatientRegistration;
import com.softwareComedians.ClinicalCenterApp.repository.ConfirmationTokenRepository;
import com.softwareComedians.ClinicalCenterApp.service.RequestForPatientRegistrationService;
import com.softwareComedians.ClinicalCenterApp.service.email.MailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "api/RqForPatientReg")
public class RequestForPatientRegistrationController {

    private RequestForPatientRegistrationService requestForPatientRegistrationService;

    @Autowired
    private MailSenderService mailSenderService;

    @Autowired
    private ConfirmationTokenRepository confirmationTokenRepository;

    @Autowired
    public RequestForPatientRegistrationController(RequestForPatientRegistrationService requestForPatientRegistrationService) {
        this.requestForPatientRegistrationService = requestForPatientRegistrationService;
    }

    @PostMapping()
    public ResponseEntity<RequestForPatientRegistrationDTO> createRqForPatientReg(@RequestBody RequestForPatientRegistrationDTO rqDTO) {

        RequestForPatientRegistration rq = new RequestForPatientRegistration();
        rq.setId(rqDTO.getId());
        rq.setAccepted(rqDTO.isAccepted());
        rq.setReasonOfRejection(rqDTO.getReasonOfRejection());
        rq.setUserData(rq.getUserData());

        rq = requestForPatientRegistrationService.save(rq);
        return new ResponseEntity<>(new RequestForPatientRegistrationDTO(rq), HttpStatus.CREATED);
    }

    @GetMapping(value = "/getAll")
    public ResponseEntity<List<RequestForPatientRegistrationDTO>> getAll() {

        List<RequestForPatientRegistration> rqs = requestForPatientRegistrationService.findAll();
        List<RequestForPatientRegistrationDTO> rqsDTO = new ArrayList<>();
        for (RequestForPatientRegistration rq : rqs) {
            rqsDTO.add(new RequestForPatientRegistrationDTO(rq));
        }

        return new ResponseEntity<>(rqsDTO, HttpStatus.OK);
    }

    //u frontednu ovo pozovi za reject
    @DeleteMapping(value = "/reject/{id}")
    public ResponseEntity<Void> remove(@PathVariable Long id){

        RequestForPatientRegistration requestForPatientRegistration = requestForPatientRegistrationService.findOne(id);

        if(requestForPatientRegistration == null){
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            requestForPatientRegistrationService.remove(id);

            ConfirmationToken token = this.createConfirmationToken(requestForPatientRegistration);
            mailSenderService.sendMailForRegistration(requestForPatientRegistration, token);

            return new ResponseEntity<>(HttpStatus.OK);
        }

    }

    //u frontednu ovo pozovi za accept
    @PutMapping(value = "/accept/{id}")
    public ResponseEntity<Void> setActivate(@PathVariable Long id){
        RequestForPatientRegistration regForPatientReq = requestForPatientRegistrationService.findOne(id);

        regForPatientReq.setAccepted(true);
        regForPatientReq.getUserData().setActivated(true);

        requestForPatientRegistrationService.setAccepted(regForPatientReq);

        ConfirmationToken token = this.createConfirmationToken(regForPatientReq);
        mailSenderService.sendMailForRegistration(regForPatientReq, token);

        return new ResponseEntity<>(HttpStatus.OK);

    }

    private ConfirmationToken createConfirmationToken(RequestForPatientRegistration user) {
        ConfirmationToken confirmationToken = new ConfirmationToken(user);
        return confirmationTokenRepository.save(confirmationToken);
    }


}
