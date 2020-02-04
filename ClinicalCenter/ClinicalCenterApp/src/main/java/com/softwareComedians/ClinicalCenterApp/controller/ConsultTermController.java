package com.softwareComedians.ClinicalCenterApp.controller;

import com.softwareComedians.ClinicalCenterApp.dto.ConsultTermDTO;
import com.softwareComedians.ClinicalCenterApp.model.*;
import com.softwareComedians.ClinicalCenterApp.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "api/ConsultTerm")
@CrossOrigin
public class ConsultTermController {

    @Autowired
    private ConsultTermService consultTermService;

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private ClinicsService clinicsService;

    @Autowired
    private RoomService roomService;

    @Autowired
    private ConsultTypeService consultTypeService;

    @Autowired
    private RoomTermsServie roomTermsServie;

    @Autowired
    private  RequestForConsultService requestForConsultService;

    @PostMapping()
    public ResponseEntity<ConsultTermDTO> createConsultTerm(@RequestBody ConsultTermDTO consultTermDTO) {

        ConsultTerm ct = new ConsultTerm();
        //System.out.println("Dodaj");

       // ct.setType(new ConsultType(consultTermDTO.getType().getId(), consultTermDTO.getType().getName()));
        ct.setDuration(consultTermDTO.getDuration());
        ct.setDiscount(consultTermDTO.getDiscount());
        ct.setPrice(consultTermDTO.getPrice());
        ct.setDate(consultTermDTO.getDate());

        Doctor d = doctorService.findByName(consultTermDTO.getDoctor());
        //stampaj
       // System.out.println(d.getName()+"sdfgh IME"+consultTermDTO.getDoctor());
        ct.setDoctor(d);

        Room r = roomService.findByName(consultTermDTO.getRoom());
      //  System.out.println(r.getName());
        ct.setRoom(r);

        ConsultType consultType = consultTypeService.findByName(consultTermDTO.getType());
        ct.setType(consultType);

        ct = consultTermService.save(ct);
        return new ResponseEntity<>(new ConsultTermDTO(ct), HttpStatus.CREATED);
    }

    @GetMapping(value = "/getTermsByTypeId/{id}")
    public ResponseEntity<List<ConsultTermDTO>> getDoctorsByTypeId(@PathVariable String typeName) {

        List<ConsultTerm> term = consultTermService.findByTypeName(typeName);
        List<ConsultTermDTO> termsDTO = new ArrayList<>();
        for (ConsultTerm ct : term) {
            termsDTO.add(new ConsultTermDTO(ct));
        }

        return new ResponseEntity<>(termsDTO, HttpStatus.OK);
    }

    @PostMapping(value = "res/{idr}/{s}/{id}")
    public ResponseEntity<ConsultTermDTO> addConsultTerm(@PathVariable Long idr, @PathVariable String s, @PathVariable Long id) {

        ConsultTerm ct = new ConsultTerm();
        RequestForConsult rq = requestForConsultService.findById(id);
        System.out.println(rq.getId());

        RoomTerms r = roomTermsServie.findOne(idr);
        System.out.println(r.getRoom().getName()); //datum i ssoba

        if(s.equals("07:00-09:00")){
            r.setTerm1(false);
        }else if(s.equals("09:00-11:00")){
            r.setTerm2(false);
        }else if(s.equals("11:00-13:00")){
            r.setTerm3(false);
        }
        else if(s.equals("13:00-15:00")){
            r.setTerm4(false);
        }else if(s.equals("15:00-17:00")){
            r.setTerm5(false);
        }else if(s.equals("17:00-19:00")){
            r.setTerm6(false);
        }
        roomTermsServie.save(r);

        ct.setType(rq.getType());
        ct.setRoom(r.getRoom());
        ct.setRequestForConsult(rq);
        ct.setPatient((Patient) rq.getPatient());
        ct.setDate(rq.getDateAndTime());
        ct.setPrice((double) 0);
        ct.setDuration((double) 2);
        ct.setDiscount((double) 0);

        //nije dobar doktor, ni klinika
        ct.setDoctor(new Doctor());
        ct.setClinic(clinicsService.findOne(r.getId()));



        ct = consultTermService.save(ct);
        return new ResponseEntity<>(new ConsultTermDTO(ct), HttpStatus.CREATED);
    }


}
