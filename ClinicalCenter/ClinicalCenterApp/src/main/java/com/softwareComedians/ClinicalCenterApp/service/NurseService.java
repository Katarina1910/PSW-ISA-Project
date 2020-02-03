package com.softwareComedians.ClinicalCenterApp.service;

import com.softwareComedians.ClinicalCenterApp.model.Nurse;
import com.softwareComedians.ClinicalCenterApp.repository.NurseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NurseService {

    @Autowired
    private NurseRepository nurseRepository;

    public Nurse findOne(Long id){return nurseRepository.findById(id).orElseGet(null);}

    public  Nurse findByName(String name){return nurseRepository.findByName(name);}

    public List<Nurse> findAll(){return nurseRepository.findAll();}

    public Nurse findByEmail(String email){
        Nurse user = nurseRepository.findByEmail(email);
        return user;
    }

    public Nurse save(Nurse n){ return nurseRepository.save(n);}

    public void remove(Long id){nurseRepository.deleteById(id);}

    public void remove(String email){
        Nurse n = nurseRepository.findByEmail(email);
        if(n!=null){
            nurseRepository.delete(n);
        }
    }
}
