package com.softwareComedians.ClinicalCenterApp.controller;

import com.softwareComedians.ClinicalCenterApp.dto.RequestForAbsenceDTO;
import com.softwareComedians.ClinicalCenterApp.model.Clinic;
import com.softwareComedians.ClinicalCenterApp.model.Personnel;
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

        RequestForAbsence rq = new RequestForAbsence();

        Personnel applicant = (Personnel) userService.findById(rqDTO.getApplicant().getId());
        rq.setId(rqDTO.getId());
        rq.setAccepted(rqDTO.isAccepted());
       rq.setResaonOfRejection(rqDTO.getResaonOfRejection());
       rq.setFroom(rqDTO.getFrom());
       rq.setToo(rqDTO.getTo());
       rq.setApplicant(applicant);
       Clinic c = clinicsService.findById(applicant.getClinic().getId());
       rq.setClinicAdministrator(clinicAdminService.findById(c.getClinicAdministrator().getId()));
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
