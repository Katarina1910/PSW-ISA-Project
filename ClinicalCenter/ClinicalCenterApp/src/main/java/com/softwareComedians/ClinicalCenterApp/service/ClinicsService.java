package com.softwareComedians.ClinicalCenterApp.service;

import com.softwareComedians.ClinicalCenterApp.exception.ApiRequestException;
import com.softwareComedians.ClinicalCenterApp.model.Clinic;
import com.softwareComedians.ClinicalCenterApp.repository.ClinicsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ClinicsService {

    @Autowired
    private ClinicsRepository clinicsRepository;

    public Clinic findOne(Long id){
        return clinicsRepository.findById(id).orElseGet(null);
    }

    public List<Clinic> findAll(){return  clinicsRepository.findAll();}

    public Clinic findById(Long id){
        try {
            return clinicsRepository.findById(id).get();
        } catch (NoSuchElementException e) {
            throw new ApiRequestException("Clinic with id '" + id + "' doesn't exist.");
        }
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

