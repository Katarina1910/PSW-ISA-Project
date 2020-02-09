package com.softwareComedians.ClinicalCenterApp.controller;

import com.softwareComedians.ClinicalCenterApp.dto.OperationDTO;
import com.softwareComedians.ClinicalCenterApp.dto.RequestForOperationDTO;
import com.softwareComedians.ClinicalCenterApp.model.Operation;
import com.softwareComedians.ClinicalCenterApp.model.RequstForOperation;
import com.softwareComedians.ClinicalCenterApp.service.RqForOperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.util.List;

@RestController
@RequestMapping(value = "api/rqForOperation")
@CrossOrigin
public class RqForOperationController {
    @Autowired
    private RqForOperationService rqForOperationService;


    @GetMapping(value = "/getAll")
    public ResponseEntity<List<RequestForOperationDTO>> getAllRequest() {
        List<RequestForOperationDTO> requestForOPDTOS= rqForOperationService.getAllRequest();
        return new ResponseEntity<>(requestForOPDTOS, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<RequestForOperationDTO> createRequest(@RequestBody RequestForOperationDTO requestForOperationDTO) {

        RequstForOperation rq = rqForOperationService.createRequest(requestForOperationDTO);
        return new ResponseEntity<>(new RequestForOperationDTO(rq), HttpStatus.CREATED);
    }

    @PostMapping(value = "doctor")
    public ResponseEntity<RequestForOperationDTO> createRequestDoctor(@RequestBody RequestForOperationDTO requestForOperationDTO) throws MessagingException {

        RequstForOperation rq = rqForOperationService.createRequestDoctor(requestForOperationDTO);
        return new ResponseEntity<>(new RequestForOperationDTO(rq), HttpStatus.CREATED);
    }

    @PostMapping(value = "res/{date}/{term}/{room}/{doctor}/{id}")
    public ResponseEntity<OperationDTO> reserveOperation(@PathVariable String date, @PathVariable String term,
                                                         @PathVariable String room, @PathVariable Long doctor, @PathVariable Long id) throws MessagingException {

        Operation ct = rqForOperationService.reserveOperation(date,term,room,doctor,id);
        return new ResponseEntity<>(new OperationDTO(ct), HttpStatus.CREATED);
    }

}
