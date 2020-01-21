package com.softwareComedians.ClinicalCenterApp.service;

import com.softwareComedians.ClinicalCenterApp.model.ClinicCenterAdministrator;
import com.softwareComedians.ClinicalCenterApp.repository.ClinicCenterAdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClinicCenterAdminService {

    @Autowired
    private ClinicCenterAdminRepository clinicCenterAdminRepository;

    public ClinicCenterAdministrator findOne(Long id){ return clinicCenterAdminRepository.findById(id).orElseGet(null);}

    public List<ClinicCenterAdministrator> findAll() {return clinicCenterAdminRepository.findAll();}

    public ClinicCenterAdministrator findById(Long id){
        ClinicCenterAdministrator clinicCenterAdministrator = clinicCenterAdminRepository.findById(id).orElseGet(null);
        return clinicCenterAdministrator;
    }

    public ClinicCenterAdministrator findByName(String name){
        for(ClinicCenterAdministrator cca: clinicCenterAdminRepository.findAll()){
            if(cca.getName().equals(name)){
                return cca;
            }
        }
        return null;
    }

    public ClinicCenterAdministrator save(ClinicCenterAdministrator cca){ return clinicCenterAdminRepository.save(cca);}

    public void remove(Long id){
        ClinicCenterAdministrator cca = clinicCenterAdminRepository.findById(id).orElseGet(null);
        if(cca!=null){
            clinicCenterAdminRepository.delete(cca);
        }
    }
}
