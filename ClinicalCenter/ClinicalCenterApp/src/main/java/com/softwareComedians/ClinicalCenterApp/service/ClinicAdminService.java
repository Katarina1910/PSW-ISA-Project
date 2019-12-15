package com.softwareComedians.ClinicalCenterApp.service;

import com.softwareComedians.ClinicalCenterApp.model.ClinicAdministrator;
import com.softwareComedians.ClinicalCenterApp.repository.ClinicAdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClinicAdminService {

    @Autowired
    private ClinicAdminRepository clinicAdminRepository;

    public ClinicAdministrator findOne(Long id){
        return clinicAdminRepository.findById(id).orElseGet(null);
    }

    public List<ClinicAdministrator> findAll(){return  clinicAdminRepository.findAll();}

    public ClinicAdministrator findById(Long id){
        ClinicAdministrator clinicAdministrator = clinicAdminRepository.findById(id).orElseGet(null);
        return clinicAdministrator;
    }

    public ClinicAdministrator findByName(String name){
        for(ClinicAdministrator ca:clinicAdminRepository.findAll()){
            if(ca.getName().equals(name)){
                return ca;
            }
        }
        return null;
    }

    public ClinicAdministrator save(ClinicAdministrator ca){ return clinicAdminRepository.save(ca);}

    public void remove(Long id){
        ClinicAdministrator ca = clinicAdminRepository.findById(id).orElseGet(null);
        if(ca!=null){
            clinicAdminRepository.delete(ca);
        }
    }
}
