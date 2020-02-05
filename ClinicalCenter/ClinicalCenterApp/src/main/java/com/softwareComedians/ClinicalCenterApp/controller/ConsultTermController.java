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
    private DoctorTermsService doctorTermsService;

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

        Doctor d = doctorService.findByName(consultTermDTO.getDoctor().getName());
        //stampaj
       // System.out.println(d.getName()+"sdfgh IME"+consultTermDTO.getDoctor());
        ct.setDoctor(d);

        Room r = roomService.findByName(consultTermDTO.getRoom().getName());
      //  System.out.println(r.getName());
        ct.setRoom(r);

        ConsultType consultType = consultTypeService.findByName(consultTermDTO.getType().getName());
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

    @PostMapping(value = "res/{date}/{term}/{room}/{doctor}/{id}")
    public ResponseEntity<ConsultTermDTO> addConsultTerm(@PathVariable String date, @PathVariable String term,
                                                         @PathVariable String room, @PathVariable Long doctor, @PathVariable Long id) {

        ConsultTerm ct = new ConsultTerm();
        RequestForConsult rq = requestForConsultService.findById(id);
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

        ct.setType(rq.getType());
        ct.setRoom(roomService.findByName(room));
        ct.setRequestForConsult(rq);
        ct.setPatient((Patient) rq.getPatient());
        ct.setDate(date);
        ct.setPrice((double) 0);
        ct.setDuration((double) 2);
        ct.setDiscount((double) 0);

        //nije dobar doktor, ni klinika
        Doctor doc = doctorService.findOne(doctor);
        ct.setDoctor(doc);
        ct.setClinic(clinicsService.findOne(doc.getClinic().getId()));



        ct = consultTermService.save(ct);
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
}
