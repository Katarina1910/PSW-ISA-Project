package com.softwareComedians.ClinicalCenterApp.service;

import com.softwareComedians.ClinicalCenterApp.dto.DoctorTermsDTO;
import com.softwareComedians.ClinicalCenterApp.model.DoctorTerms;
import com.softwareComedians.ClinicalCenterApp.repository.DoctorTermsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DoctorTermsService {

    @Autowired
    private DoctorTermsRepository doctorTermsRepository;

    public List<DoctorTerms> findAll() { return doctorTermsRepository.findAll(); }

    public DoctorTerms save(DoctorTerms doctorTerms) {
        return  doctorTermsRepository.save(doctorTerms);
    }
    public List<DoctorTerms> findByDate(String date){
        return  doctorTermsRepository.findByDate(date);
    }

    public List<DoctorTermsDTO> getAllDateTerm(String date, String term) {

        List<DoctorTerms> docs = this.findByDate(date);
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

        return dtos;
    }

}
