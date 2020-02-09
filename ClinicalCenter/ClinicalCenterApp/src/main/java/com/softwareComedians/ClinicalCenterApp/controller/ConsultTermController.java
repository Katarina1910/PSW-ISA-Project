package com.softwareComedians.ClinicalCenterApp.controller;

import com.softwareComedians.ClinicalCenterApp.dto.ConsultDTO;
import com.softwareComedians.ClinicalCenterApp.dto.ConsultTermDTO;
import com.softwareComedians.ClinicalCenterApp.mail.SmtpMailSender;
import com.softwareComedians.ClinicalCenterApp.model.ConsultTerm;
import com.softwareComedians.ClinicalCenterApp.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.util.List;

@RestController
@RequestMapping(value = "api/ConsultTerm")
@CrossOrigin
public class ConsultTermController {

    @Autowired
    private ConsultTermService consultTermService;


    @Autowired
    private SmtpMailSender smtpMailSender;

    @PutMapping(value = "/editConsult")
    public ResponseEntity<Void> editConsult(@RequestBody ConsultDTO consultDTO) throws MessagingException {
        return this.consultTermService.editConsult(consultDTO);
    }


    @PostMapping(value = "/addConsultReport")
    public ResponseEntity<Void> addConsultReport(@RequestBody ConsultDTO consultDTO){
        return this.consultTermService.addReport(consultDTO);
    }

    @PostMapping()
    public ResponseEntity<ConsultTermDTO> createConsultTerm(@RequestBody ConsultTermDTO consultTermDTO) {
        ConsultTerm ct = consultTermService.createConsultTerm(consultTermDTO);
        return new ResponseEntity<>(new ConsultTermDTO(ct), HttpStatus.CREATED);
    }

    @GetMapping(value = "/getTermsByTypeId/{id}")
    public ResponseEntity<List<ConsultTermDTO>> getDoctorsByTypeId(@PathVariable String typeName) {
        List<ConsultTermDTO> termsDTO = consultTermService.getDoctorsByTypeId(typeName);
        return new ResponseEntity<>(termsDTO, HttpStatus.OK);
    }

    @PostMapping(value = "res/{date}/{term}/{room}/{doctor}/{id}")
    public ResponseEntity<ConsultTermDTO> reserveRoomForConsultTerm(@PathVariable String date, @PathVariable String term,
                                                         @PathVariable String room, @PathVariable Long doctor, @PathVariable Long id) throws MessagingException {

       ConsultTerm ct = consultTermService.reserveRoom(date, term, room, doctor, id);
        smtpMailSender.send(ct.getPatient().getEmail(),"Consult term",
                " You have a new consult term : "+ct.getDate());
        smtpMailSender.send(ct.getDoctor().getEmail(),"Consult term",
                " You have a new consult term : "+ct.getDate());
        return new ResponseEntity<>(new ConsultTermDTO(ct), HttpStatus.CREATED);
    }


    @GetMapping(value = "/getConsults/{id}/{role}")
    public ResponseEntity<List<ConsultTermDTO>> getConsultsByUser(@PathVariable Long id, @PathVariable String role){
        List<ConsultTermDTO>  consults= consultTermService.getConsultsByUser(id,role);

        if(consults == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            return  new ResponseEntity<>(consults, HttpStatus.OK);
        }

    }

    @GetMapping(value = "/getConsultTerms/{userId}")
    public ResponseEntity<List<ConsultTermDTO>> getAllConsultTermsUserID(@PathVariable Long userId) {
        List<ConsultTermDTO> ctDTO = consultTermService.getAllConsultTermsUserID(userId);
        return new ResponseEntity<>(ctDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/getConsult/{id}")
    public ResponseEntity<ConsultTermDTO> getConsult(@PathVariable Long id) {
            ConsultTermDTO consult = consultTermService.findByIdDTO(id);

            if(consult != null){
                return new ResponseEntity<>(consult, HttpStatus.OK);
            }else {
                return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
    }



}
