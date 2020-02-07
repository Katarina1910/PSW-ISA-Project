package com.softwareComedians.ClinicalCenterApp.service;

import com.softwareComedians.ClinicalCenterApp.exception.ApiRequestException;
import com.softwareComedians.ClinicalCenterApp.model.Doctor;
import com.softwareComedians.ClinicalCenterApp.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;


    public Doctor findOne(Long id) {
        try {
            return doctorRepository.findById(id).get();
        } catch (NoSuchElementException e) {
            throw new ApiRequestException("Doctor with id '" + id + "' doesn't exist.");
        }
    }


    public Doctor findByName(String name){
        return doctorRepository.findByName(name);
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
            if(u.getUsername().equals(userName)){
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

    public void remove(String email) {
      Doctor d =  doctorRepository.findByEmail(email);
      if(d!=null){
          doctorRepository.delete(d);
      }
    }

}
