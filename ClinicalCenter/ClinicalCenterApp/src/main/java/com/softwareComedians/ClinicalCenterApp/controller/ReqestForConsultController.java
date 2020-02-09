package com.softwareComedians.ClinicalCenterApp.controller;

import com.softwareComedians.ClinicalCenterApp.dto.RequestForConsultDTO;
import com.softwareComedians.ClinicalCenterApp.model.RequestForConsult;
import com.softwareComedians.ClinicalCenterApp.service.RequestForConsultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.util.List;

@RestController
@RequestMapping(value = "api/rqForConsult")
@CrossOrigin
public class ReqestForConsultController {

    @Autowired
    private RequestForConsultService requestForConsultService;


    @GetMapping(value = "/getAll")
    public ResponseEntity<List<RequestForConsultDTO>> getAll() {
        List<RequestForConsultDTO> requestForConsultDTOS= requestForConsultService.getAll();
        return new ResponseEntity<>(requestForConsultDTOS, HttpStatus.OK);
    }



    @PostMapping()
    public ResponseEntity<RequestForConsultDTO> createRequest(@RequestBody RequestForConsultDTO requestForConsultDTO) {
        RequestForConsult rq = requestForConsultService.createRequest(requestForConsultDTO);
        return new ResponseEntity<>(new RequestForConsultDTO(rq), HttpStatus.CREATED);
    }

    @PostMapping(value = "doctor")
    public ResponseEntity<RequestForConsultDTO> createRequestDoctor(@RequestBody RequestForConsultDTO requestForConsultDTO) throws MessagingException {
        RequestForConsult rq = requestForConsultService.createRequestDoctor(requestForConsultDTO);
        return new ResponseEntity<>(new RequestForConsultDTO(rq), HttpStatus.CREATED);
    }

    @PostMapping( value = "/add/{userId}")
    public ResponseEntity<?> requestForConsultPatient(@RequestBody RequestForConsultDTO requestForConsultDTO,  @PathVariable Long userId) throws Exception {
        RequestForConsult rq = this.requestForConsultService.createReq(requestForConsultDTO, userId);
        return new ResponseEntity<>(new RequestForConsultDTO(rq), HttpStatus.CREATED);
    }

}
