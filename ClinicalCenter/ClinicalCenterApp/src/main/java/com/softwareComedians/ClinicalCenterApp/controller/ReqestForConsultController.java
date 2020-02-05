package com.softwareComedians.ClinicalCenterApp.controller;

import com.softwareComedians.ClinicalCenterApp.dto.RequestForConsultDTO;
import com.softwareComedians.ClinicalCenterApp.mail.SmtpMailSender;
import com.softwareComedians.ClinicalCenterApp.model.*;
import com.softwareComedians.ClinicalCenterApp.service.*;
import com.softwareComedians.ClinicalCenterApp.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "api/rqForConsult")
@CrossOrigin
public class ReqestForConsultController {

    @Autowired
    private RequestForConsultService requestForConsultService;

    @Autowired
    private ConsultTypeService consultTypeService;

    @Autowired
    private ClinicsService clinicsService;

    @Autowired
    private ClinicAdminService clinicAdminService;

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

    @Autowired
    private  RoomTermsServie roomTermsServie;

    @Autowired
    private  DoctorTermsService doctorTermsService;


    @GetMapping(value = "/getAll")
    public ResponseEntity<List<RequestForConsultDTO>> getAll() {

        List<RequestForConsult> requestForConsults = requestForConsultService.findAll();
        List<RequestForConsultDTO> requestForConsultDTOS= new ArrayList<>();
        for (RequestForConsult d : requestForConsults) {
            requestForConsultDTOS.add(new RequestForConsultDTO(d));
        }

        return new ResponseEntity<>(requestForConsultDTOS, HttpStatus.OK);
    }




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
    public ResponseEntity<RequestForConsultDTO> createRequestDoctor(@RequestBody RequestForConsultDTO requestForConsultDTO) throws MessagingException {
        boolean cT = true;
        boolean dT = true;

        RequestForConsult rq = new RequestForConsult();
        rq.setId(requestForConsultDTO.getId());
        rq.setDateAndTime(requestForConsultDTO.getDateAndTime());
        rq.setType(consultTypeService.findOne(requestForConsultDTO.getType().getId()));
        rq.setPatient(userService.findById(requestForConsultDTO.getPatient().getId()));
        //send mail, getPatient.getClicic.getAdmin.getMail
        // Clinic c =clinicsService.findById(requestForConsultDTO.getPatient().getC)
        String description = "You have scheduled a new consult!";
      //  smtpMailSender.send(requestForConsultDTO.getPatient().getEmail(),"New consult", description);

        for(RoomTerms rr : roomTermsServie.findAll()){
            if (rr.getDate().equals(rq.getDateAndTime())){
                cT = false;
            }
        }

        for(DoctorTerms dt : doctorTermsService.findAll()){
            if (dt.getDate().equals(rq.getDateAndTime())){
                dT = false;
            }
        }
        if(cT){
            System.out.println("ctt");
            for (Room r: roomService.findAll()){
                System.out.println(r.getName());
                RoomTerms roomTerms = new RoomTerms();
                roomTerms.setDate(requestForConsultDTO.getDateAndTime());
                roomTerms.setRoom(r);
                roomTermsServie.save(roomTerms);
            }
        }

        if(dT){
            System.out.println("dtt");
            for (Doctor d: doctorService.findAll()){
                System.out.println(d.getName());
                DoctorTerms dTerms = new DoctorTerms();
                dTerms.setDate(requestForConsultDTO.getDateAndTime());
                dTerms.setDoctor(d);
                doctorTermsService.save(dTerms);
            }
        }



        rq = requestForConsultService.save(rq);
        return new ResponseEntity<>(new RequestForConsultDTO(rq), HttpStatus.CREATED);
    }

    @PostMapping( value = "/add/{userId}")
    public ResponseEntity<?> requestForConsultPatient(@RequestBody RequestForConsultDTO requestForConsultDTO,  @PathVariable Long userId) throws Exception {

        RequestForConsult rq = new RequestForConsult();

        User u = userService.findById(userId);
        ConsultTerm ct = consultTermService.findById(requestForConsultDTO.getId());

        rq.setId(requestForConsultDTO.getId());
        rq.setDateAndTime(requestForConsultDTO.getDateAndTime());
        rq.setType(consultTypeService.findOne(requestForConsultDTO.getType().getId()));
        rq.setPatient(u);
        rq.setAccepted(false);
        rq.setConsultTerm(ct);

        rq = requestForConsultService.save(rq);

        //salje mejl adminu klinike
        //TODO: preko pacijenotovog ID-a pronaci u kojoj je klinici i poslati mejl odgovarajucem administratoru te klinike
        smtpMailSender.send("pswtim2@gmail.com","Request for consult",
                " You have a request for consult: type: "+ct.getType().getName()+ "\r\n"+
                        "doctor's name: "+ct.getDoctor().getName()+ " "+ct.getDoctor().getSurname()+ "\r\n"+
                        "patient's name: "+u.getName()+" "+u.getSurname()+"\r\n"+
                        " <a href='http://localhost:8080/api/patient/requestConsultTerm/"+rq.getId()+"'> Confirm </a>");

        return new ResponseEntity<>(new RequestForConsultDTO(rq), HttpStatus.CREATED);
    }

}
