package com.softwareComedians.ClinicalCenterApp.service;

import com.softwareComedians.ClinicalCenterApp.dto.DiagnosisDTO;
import com.softwareComedians.ClinicalCenterApp.model.Diagnosis;
import com.softwareComedians.ClinicalCenterApp.repository.DiagnosisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiagnosisService {

    @Autowired
    private DiagnosisRepository diagnosisRepository;

    public Diagnosis findOne(Long id){return diagnosisRepository.findById(id).orElseGet(null);}

    public List<Diagnosis> findAll(){return diagnosisRepository.findAll();}

    public Diagnosis findById(Long id){
        Diagnosis diagnosis = diagnosisRepository.findById(id).orElseGet(null);
        return diagnosis;
    }

    public Diagnosis findByName(String name){
        for(Diagnosis d:diagnosisRepository.findAll()){
            if(d.getName().equals(name)){
                return d;
            }
        }
        return null;
    }

    public Diagnosis findByCode(String code){
        for(Diagnosis d:diagnosisRepository.findAll()){
            if(d.getCode().equals(code)){
                return d;
            }
        }
        return null;
    }

    public Diagnosis save(Diagnosis d){return diagnosisRepository.save(d);}

    public void remove(Long id){
        Diagnosis d = diagnosisRepository.findById(id).orElseGet(null);
        if(d!=null){
            diagnosisRepository.delete(d);
        }
    }

    public Diagnosis editDiagnosis (DiagnosisDTO diagnosisDTO) {
        Diagnosis d = this.findOne(diagnosisDTO.getId());
        d.setName(diagnosisDTO.getName());
        d.setCode(diagnosisDTO.getCode());
        d.setDescription((diagnosisDTO.getDescription()));
        d = this.save(d);
        return d;
    }
}
