package com.softwareComedians.ClinicalCenterApp.controller;

import com.softwareComedians.ClinicalCenterApp.dto.RequestForConsultDTO;
import com.softwareComedians.ClinicalCenterApp.mail.SmtpMailSender;
import com.softwareComedians.ClinicalCenterApp.model.RequestForConsult;
import com.softwareComedians.ClinicalCenterApp.service.ConsultTypeService;
import com.softwareComedians.ClinicalCenterApp.service.RequestForConsultService;
import com.softwareComedians.ClinicalCenterApp.service.UserService;
import com.softwareComedians.ClinicalCenterApp.model.*;
import com.softwareComedians.ClinicalCenterApp.service.*;
import com.softwareComedians.ClinicalCenterApp.service.impl.UserServiceImpl;
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
    private DoctorService doctorService;

    @Autowired
    private RoomService roomService;

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private ConsultTermService consultTermService;

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

    @PostMapping( value = "/add/{userId}")
    public ResponseEntity<?> addExamination(@RequestBody RequestForConsultDTO requestForConsultDTO,  @PathVariable Long userId) throws Exception {

        RequestForConsult rfc = new RequestForConsult();

        User u = userService.findById(userId);
        ConsultTerm ct = consultTermService.findById(requestForConsultDTO.getId());

        rfc.setId(requestForConsultDTO.getId());
        rfc.setDateAndTime(requestForConsultDTO.getDateAndTime());
        rfc.setType(consultTypeService.findOne(requestForConsultDTO.getType().getId()));
        rfc.setAccepted(false);
      //  rfc.setApplicant(u);
        rfc.setConsultTerm(ct);

/*
        if (rfc.getDuration() < 1) {
            return new ResponseEntity<>("Error! Duration is smaller then 1!", HttpStatus.METHOD_NOT_ALLOWED);
        }

        if (rfc.getPrice() < 0) {
            return new ResponseEntity<>("Error! Price is smaller then 0!", HttpStatus.METHOD_NOT_ALLOWED);
        }
        LocalDateTime dateTimeNow = LocalDateTime.now();

        int compareValue = appexm.getDateTime().compareTo(dateTimeNow);

        if (compareValue < 0) {
            return new ResponseEntity<>("Error! Date is in the past!", HttpStatus.METHOD_NOT_ALLOWED);
        }
*/
        rfc = requestForConsultService.save(rfc);

        //salje mejl adminu klinike
        //TODO: preko pacijenotovog ID-a pronaci u kojoj je klinici i poslati mejl odgovarajucem administratoru te klinike
        smtpMailSender.send("sansaduvic@gmail.com","Request for consult",
                " You have a request for consult: type: "+ct.getType().getName()+ "\r\n"+
                        "doctor's name: "+ct.getDoctor().getName()+ " "+ct.getDoctor().getSurname()+ "\r\n"+
                        "patient's name: "+u.getName()+" "+u.getSurname()+"\r\n"+
                        " <a href='http://localhost:8080/api/patient/requestConsultTerm/"+rfc.getId()+"'> Confirm </a>");

        return new ResponseEntity<>(new RequestForConsultDTO(rfc), HttpStatus.CREATED);
    }

}
