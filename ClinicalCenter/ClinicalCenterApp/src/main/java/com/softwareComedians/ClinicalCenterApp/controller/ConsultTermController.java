package com.softwareComedians.ClinicalCenterApp.controller;

import com.softwareComedians.ClinicalCenterApp.dto.ConsultDTO;
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
    private RoomService roomService;

    @Autowired
    private ConsultTypeService consultTypeService;

    @PutMapping(value = "/editConsult")
    public ResponseEntity<Void> editConsult(@RequestBody ConsultDTO consultDTO){
        return this.consultTermService.editConsult(consultDTO);
    }


    @PostMapping(value = "/addConsultReport")
    public ResponseEntity<Void> addConsultReport(@RequestBody ConsultDTO consultDTO){
        return this.consultTermService.addReport(consultDTO);
    }

    @PostMapping()
    public ResponseEntity<ConsultTermDTO> createConsultTerm(@RequestBody ConsultTermDTO consultTermDTO) {

        ConsultTerm ct = new ConsultTerm();
        //System.out.println("Dodaj");

        ct.setType(consultTypeService.findOne(consultTermDTO.getType().getId()));
        ct.setDuration(consultTermDTO.getDuration());
        ct.setDiscount(consultTermDTO.getDiscount());
        ct.setPrice(consultTermDTO.getPrice());
        ct.setDate(consultTermDTO.getDate());

        Doctor d = doctorService.findByName(consultTermDTO.getDoctor().getName());
        //stampaj
       // System.out.println(d.getName()+"sdfgh IME"+consultTermDTO.getDoctor());
        ct.setDoctor(d);
        ct.setClinic(d.getClinic());

        Room r = roomService.findByName(consultTermDTO.getRoom().getName());
      //  System.out.println(r.getName());
        ct.setRoom(r);

        ct.setPatient(new Patient());


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

       ConsultTerm ct = consultTermService.reserveRoom(date, term, room, doctor, id);
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
    public ResponseEntity<List<ConsultTermDTO>> getAllConsultTerms(@PathVariable Long userId) {

        List<ConsultTerm> cts = consultTermService.findAll();
        List<ConsultTermDTO> ctDTO = new ArrayList<>();
        for (ConsultTerm ct : cts) {
            if(ct.getPatient().getId() == userId)
                ctDTO.add(new ConsultTermDTO(ct));
        }

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
