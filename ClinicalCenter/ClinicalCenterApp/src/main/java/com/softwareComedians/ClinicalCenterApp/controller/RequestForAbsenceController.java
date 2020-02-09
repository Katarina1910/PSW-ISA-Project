package com.softwareComedians.ClinicalCenterApp.controller;

import com.softwareComedians.ClinicalCenterApp.dto.RequestForAbsenceDTO;
import com.softwareComedians.ClinicalCenterApp.model.RequestForAbsence;
import com.softwareComedians.ClinicalCenterApp.repository.ConfirmationTokenRepository;
import com.softwareComedians.ClinicalCenterApp.service.ClinicAdminService;
import com.softwareComedians.ClinicalCenterApp.service.ClinicsService;
import com.softwareComedians.ClinicalCenterApp.service.RequestForAbsenceService;
import com.softwareComedians.ClinicalCenterApp.service.UserService;
import com.softwareComedians.ClinicalCenterApp.service.email.MailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "api/RqForAbsence")
public class RequestForAbsenceController {
    private RequestForAbsenceService requestForAbsenceService;

    @Autowired
    private MailSenderService mailSenderService;

    @Autowired
    private UserService userService;

    @Autowired
    private ClinicsService clinicsService;

    @Autowired
    private ClinicAdminService clinicAdminService;

    @Autowired
    private ConfirmationTokenRepository confirmationTokenRepository;

    @Autowired
    public RequestForAbsenceController(RequestForAbsenceService requestForAbsenceService) {
        this.requestForAbsenceService = requestForAbsenceService;
    }

    @PostMapping()
    public ResponseEntity<RequestForAbsenceDTO> createRqForAbsence(@RequestBody RequestForAbsenceDTO rqDTO) {
        RequestForAbsence rq = requestForAbsenceService.createRqForAbsence(rqDTO);
        return new ResponseEntity<>(new RequestForAbsenceDTO(rq), HttpStatus.CREATED);
    }

    @GetMapping(value = "/getAll")
    public ResponseEntity<List<RequestForAbsenceDTO>> getAll() {
        List<RequestForAbsenceDTO> rqsDTO = requestForAbsenceService.getAll();
        return new ResponseEntity<>(rqsDTO, HttpStatus.OK);
    }
/*
    @GetMapping(value = "/getAll/{id}")
    public ResponseEntity<List<RequestForAbsenceDTO>> getAllDoctor(@PathVariable Long id) {
        List<RequestForAbsenceDTO> rqsDTO = requestForAbsenceService.getAllDoctor(id);
        return new ResponseEntity<>(rqsDTO, HttpStatus.OK);
    }
*/

    @GetMapping(value = "/getAll/{id}")
    public ResponseEntity<List<RequestForAbsenceDTO>> getAllDoctor(@PathVariable Long id) {

        List<RequestForAbsence> rqs = requestForAbsenceService.findAllById(id);
        List<RequestForAbsenceDTO> rqsDTO = new ArrayList<>();
        for (RequestForAbsence rq : rqs) {
            if(rq.isAccepted() == true) {
                rqsDTO.add(new RequestForAbsenceDTO(rq));
            }
        }

        return new ResponseEntity<>(rqsDTO, HttpStatus.OK);
    }



}
