package com.softwareComedians.ClinicalCenterApp.controller;

import com.softwareComedians.ClinicalCenterApp.dto.DoctorTermsDTO;
import com.softwareComedians.ClinicalCenterApp.model.DoctorTerms;
import com.softwareComedians.ClinicalCenterApp.service.DoctorTermsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "api/doctorTerms")
@CrossOrigin
public class DoctorTermController {
    DoctorTermsService doctorTermsService;

    @Autowired
    public DoctorTermController(DoctorTermsService doctorTermsService){
        this.doctorTermsService=doctorTermsService;
    }

    @GetMapping(value = "/getAllDate/{date}/{term}")
    public ResponseEntity<List<DoctorTermsDTO>> getAll(@PathVariable String date, @PathVariable String term) {

        List<DoctorTerms> docs = doctorTermsService.findByDate(date);
        System.out.println(date);
        int x=0; //term

        if(term.equals("07:00-09:00")){
            x=1;
        }else if(term.equals("09:00-11:00")){
            x=2;
        }else if(term.equals("11:00-13:00")){
            x=3;
        }
        else if(term.equals("13:00-15:00")){
            x=4;
        }else if(term.equals("15:00-17:00")){
            x=5;
        }else if(term.equals("17:00-19:00")){
            x=6;
        }

        List<DoctorTermsDTO> dtos = new ArrayList<>();
        for (DoctorTerms d : docs) {
            if(x==1 && d.isTerm1()){
                dtos.add(new DoctorTermsDTO(d));
            } else  if(x==2 && d.isTerm2()){
                dtos.add(new DoctorTermsDTO(d));
            } else  if(x==3 && d.isTerm3()){
                dtos.add(new DoctorTermsDTO(d));
            } else  if(x==4 && d.isTerm4()){
                dtos.add(new DoctorTermsDTO(d));
            } else  if(x==5 && d.isTerm5()){
                dtos.add(new DoctorTermsDTO(d));
            } else  if(x==6 && d.isTerm6()){
                dtos.add(new DoctorTermsDTO(d));
            }

        }

        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }
}
