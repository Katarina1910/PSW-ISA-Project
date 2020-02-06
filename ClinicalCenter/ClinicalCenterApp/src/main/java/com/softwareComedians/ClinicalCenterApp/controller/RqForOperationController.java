package com.softwareComedians.ClinicalCenterApp.controller;

import com.softwareComedians.ClinicalCenterApp.dto.OperationDTO;
import com.softwareComedians.ClinicalCenterApp.dto.RequestForOperationDTO;
import com.softwareComedians.ClinicalCenterApp.mail.SmtpMailSender;
import com.softwareComedians.ClinicalCenterApp.model.*;
import com.softwareComedians.ClinicalCenterApp.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private RoomService roomService;

    @Autowired
    private RoomTermsServie roomTermsServie;

    @Autowired
    private  DoctorTermsService doctorTermsService;

    @GetMapping(value = "/getAll")
    public ResponseEntity<List<RequestForOperationDTO>> getAll() {

        List<RequstForOperation> requestForOP = rqForOperationService.findAll();
        List<RequestForOperationDTO> requestForOPDTOS= new ArrayList<>();
        for (RequstForOperation d : requestForOP) {
            System.out.println(d.getPatient().getName());
            requestForOPDTOS.add(new RequestForOperationDTO(d));
        }

        return new ResponseEntity<>(requestForOPDTOS, HttpStatus.OK);
    }

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

        boolean cT = true;
        boolean dT = true;

        RequstForOperation rq = new RequstForOperation();
        rq.setId(requestForOperationDTO.getId());
        System.out.println(requestForOperationDTO.getPatient().getName());
         rq.setDateAndTime(requestForOperationDTO.getDateAndTime());
         User patient = userService.findById(requestForOperationDTO.getPatient().getId());
         System.out.println(patient.getName());
        rq.setPatient(patient);
        //send mail, getPatient.getClicic.getAdmin.getMail
        //smtpMailSender.send(requestForConsultDTO.get,"Registration", description);

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
                roomTerms.setDate(requestForOperationDTO.getDateAndTime());
                roomTerms.setRoom(r);
                roomTermsServie.save(roomTerms);
            }
        }

        if(dT){
            System.out.println("dtt");
            for (Doctor d: doctorService.findAll()){
                System.out.println(d.getName());
                DoctorTerms dTerms = new DoctorTerms();
                dTerms.setDate(requestForOperationDTO.getDateAndTime());
                dTerms.setDoctor(d);
                doctorTermsService.save(dTerms);
            }
        }



        rq = rqForOperationService.save(rq);
        return new ResponseEntity<>(new RequestForOperationDTO(rq), HttpStatus.CREATED);
    }

    @PostMapping(value = "res/{date}/{term}/{room}/{doctor}/{id}")
    public ResponseEntity<OperationDTO> addConsultTerm(@PathVariable String date, @PathVariable String term,
                                                         @PathVariable String room, @PathVariable Long doctor, @PathVariable Long id) {

        Operation ct = new Operation();
        RequstForOperation rq = rqForOperationService.findOne(id);
        System.out.println(rq.getId());

        List<RoomTerms> rts= roomTermsServie.findByDate(date);
        List<DoctorTerms> dts = doctorTermsService.findByDate(date);
        DoctorTerms dt = null;
        RoomTerms r = null;
        for (RoomTerms rr : rts){
            if(rr.getRoom().getName().equals(room)){
                r=rr;
                System.out.println(r.getRoom().getName());
            }
        }

        for(DoctorTerms d : dts){
            if(d.getDoctor().getId() == doctor){
                dt = d;
            }
        }


        if(term.equals("07:00-09:00")){
            r.setTerm1(false);
            dt.setTerm1(false);
        }else if(term.equals("09:00-11:00")){
            r.setTerm2(false);
            dt.setTerm2(false);
        }else if(term.equals("11:00-13:00")){
            r.setTerm3(false);
            dt.setTerm3(false);
        }
        else if(term.equals("13:00-15:00")){
            r.setTerm4(false);
            dt.setTerm4(false);
        }else if(term.equals("15:00-17:00")){
            r.setTerm5(false);
            dt.setTerm5(false);
        }else if(term.equals("17:00-19:00")){
            r.setTerm6(false);
            dt.setTerm6(false);
        }
        roomTermsServie.save(r);
        doctorTermsService.save(dt);

        ct.setRoom(roomService.findByName(room));
        ct.setRoom(new Room());
        System.out.println(roomService.findByName(room));
        ct.setRequstForOperation(rq);

        //req.getPatient.getMedical
        ct.setMedicalRecord(new MedicalRecord());

        ct = roomService.saveOperation(ct);

        return new ResponseEntity<>(new OperationDTO(ct), HttpStatus.CREATED);
    }

}
