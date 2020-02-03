package com.softwareComedians.ClinicalCenterApp.controller;

import com.softwareComedians.ClinicalCenterApp.dto.RequestForAbsenceDTO;
import com.softwareComedians.ClinicalCenterApp.model.ClinicAdministrator;
import com.softwareComedians.ClinicalCenterApp.model.Personnel;
import com.softwareComedians.ClinicalCenterApp.model.RequestForAbsence;
import com.softwareComedians.ClinicalCenterApp.repository.ConfirmationTokenRepository;
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
    private ConfirmationTokenRepository confirmationTokenRepository;

    @Autowired
    public RequestForAbsenceController(RequestForAbsenceService requestForAbsenceService) {
        this.requestForAbsenceService = requestForAbsenceService;
    }

    @PostMapping()
    public ResponseEntity<RequestForAbsenceDTO> createRqForAbsence(@RequestBody RequestForAbsenceDTO rqDTO) {

        RequestForAbsence rq = new RequestForAbsence();
        Personnel applicant = (Personnel) userService.findById(rqDTO.getId());
        ClinicAdministrator ca = (ClinicAdministrator) userService.findById(rqDTO.getClinicAdministrator());
        rq.setId(rqDTO.getId());
        rq.setAccepted(rqDTO.isAccepted());
       rq.setResaonOfRejection(rqDTO.getResaonOfRejection());
       rq.setFrom(rq.getFrom());
       rq.setTo(rq.getTo());
       rq.setApplicant(applicant);
       rq.setClinicAdministrator(ca);

        rq = requestForAbsenceService.save(rq);
        return new ResponseEntity<>(new RequestForAbsenceDTO(rq), HttpStatus.CREATED);
    }

    @GetMapping(value = "/getAll")
    public ResponseEntity<List<RequestForAbsenceDTO>> getAll() {

        List<RequestForAbsence> rqs = requestForAbsenceService.findAll();
        List<RequestForAbsenceDTO> rqsDTO = new ArrayList<>();
        for (RequestForAbsence rq : rqs) {
            rqsDTO.add(new RequestForAbsenceDTO(rq));
        }

        return new ResponseEntity<>(rqsDTO, HttpStatus.OK);
    }
}
