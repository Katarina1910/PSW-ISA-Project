package com.softwareComedians.ClinicalCenterApp.service;

import com.softwareComedians.ClinicalCenterApp.model.ConsultType;
import com.softwareComedians.ClinicalCenterApp.repository.ConsultTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultTypeService {
    @Autowired
    ConsultTypeRepository consultTypeRepository;

    public ConsultType findOne(Long id){
        return consultTypeRepository.findById(id).orElseGet(null);
    }

    public ConsultType findByName(String name) { return  consultTypeRepository.findByName(name); }

    public List<ConsultType> findAll(){
        return consultTypeRepository.findAll();
    }

    public ConsultType save(ConsultType t) {
        return consultTypeRepository.save(t);
    }

    public void remove(Long id){
        consultTypeRepository.deleteById(id);
    }

}
