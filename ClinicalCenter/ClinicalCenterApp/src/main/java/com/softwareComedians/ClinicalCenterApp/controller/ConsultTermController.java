package com.softwareComedians.ClinicalCenterApp.controller;

import com.softwareComedians.ClinicalCenterApp.dto.ConsultTermDTO;
import com.softwareComedians.ClinicalCenterApp.model.ConsultTerm;
import com.softwareComedians.ClinicalCenterApp.model.ConsultType;
import com.softwareComedians.ClinicalCenterApp.model.Doctor;
import com.softwareComedians.ClinicalCenterApp.model.Room;
import com.softwareComedians.ClinicalCenterApp.service.ConsultTermService;
import com.softwareComedians.ClinicalCenterApp.service.ConsultTypeService;
import com.softwareComedians.ClinicalCenterApp.service.DoctorService;
import com.softwareComedians.ClinicalCenterApp.service.RoomService;
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

    @GetMapping(value = "getConsults/{id}/{role}")
    public ResponseEntity<List<ConsultTermDTO>> getConsultsByUser(@PathVariable Long id, @PathVariable String role){
        List<ConsultTermDTO>  consults= consultTermService.getConsultsByUser(id,role);

        if(consults == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            return  new ResponseEntity<>(consults, HttpStatus.OK);
        }

    }
}
