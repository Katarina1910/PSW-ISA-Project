package com.softwareComedians.ClinicalCenterApp.service.impl;

import com.softwareComedians.ClinicalCenterApp.model.Clinic;
import com.softwareComedians.ClinicalCenterApp.repository.ClinicsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClinicsService {

    @Autowired
    private ClinicsRepository clinicsRepository;

    public Clinic findOne(Long id){
        return clinicsRepository.findById(id).orElseGet(null);
    }

    public List<Clinic> findAll(){return  clinicsRepository.findAll();}

    public Clinic findById(String id){
        Clinic clinic = clinicsRepository.findByName(id);
        return clinic;
    }

    public Clinic findByName(String name){
        for(Clinic c:clinicsRepository.findAll()){
            if(c.getName().equals(name)){
                return c;
            }
        }
        return null;
    }

    public Clinic findByAddress(String address){
        for(Clinic c:clinicsRepository.findAll()){
            if(c.getAddress().equals(address)){
                return c;
            }
        }
        return null;
    }

    public Clinic save(Clinic c){ return clinicsRepository.save(c);}

    public void remove(Long id){
        Clinic c = clinicsRepository.findById(id).orElseGet(null);
        if(c!=null){
            clinicsRepository.delete(c);
        }
    }
}

