package com.softwareComedians.ClinicalCenterApp.service;

import com.softwareComedians.ClinicalCenterApp.model.Medicament;
import com.softwareComedians.ClinicalCenterApp.repository.MedicamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicamentService {

    @Autowired
    private MedicamentRepository medicamentRepository;

    public Medicament findOne(Long id) {return  medicamentRepository.findById(id).orElseGet(null);}

    public List<Medicament> findAll(){return  medicamentRepository.findAll();}

    public Medicament findById(Long id){
        Medicament medicament = medicamentRepository.findById(id).orElseGet(null);
        return medicament;
    }

    public Medicament findByName(String name){
        for(Medicament m:medicamentRepository.findAll()){
            if(m.getName().equals(name)){
                return m;
            }
        }
        return null;
    }

    public Medicament findByCode(String code){
        for(Medicament m:medicamentRepository.findAll()){
            if(m.getCode().equals(code)){
                return m;
            }
        }
        return null;
    }

    public Medicament save(Medicament m){return medicamentRepository.save(m);}

    //public void remove(Long id){ medicamentRepository.deleteById(id);}

    public void remove(Long id){
        Medicament m = medicamentRepository.findById(id).orElseGet(null);
        if(m!=null){
            medicamentRepository.delete(m);
        }
    }
}
