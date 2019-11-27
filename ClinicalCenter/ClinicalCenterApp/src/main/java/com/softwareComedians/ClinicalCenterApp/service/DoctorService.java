package com.softwareComedians.ClinicalCenterApp.service;

import com.softwareComedians.ClinicalCenterApp.model.Doctor;
import com.softwareComedians.ClinicalCenterApp.model.User;
import com.softwareComedians.ClinicalCenterApp.repository.DoctorRepository;
import com.softwareComedians.ClinicalCenterApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.List;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;


    public Doctor findOne(Long id){
        return doctorRepository.findById(id).orElseGet(null);
    }

    public List<Doctor> findAll(){
        return doctorRepository .findAll();
    }

    public Doctor findByEmail(String email){

        Doctor user = doctorRepository.findByEmail(email);

        return user;

    }

    public Doctor findByUserName(String userName){
        for(Doctor u : doctorRepository.findAll()){
            if(u.getUserName().equals(userName)){
                return u;
            }
        }
        return null;
    }

    public Doctor findByUICDN(String uicdn){
        for(Doctor u : doctorRepository.findAll()){
            if(u.getUcidn().equals(uicdn)){
                return u;
            }
        }
        return null;
    }


    public Doctor save(Doctor u) {
        return doctorRepository.save(u);
    }

    public void remove(Long id){
        doctorRepository.deleteById(id);
    }

}