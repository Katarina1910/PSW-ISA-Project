package com.softwareComedians.ClinicalCenterApp.service;

import com.softwareComedians.ClinicalCenterApp.dto.ConsultTypeDTO;
import com.softwareComedians.ClinicalCenterApp.exception.ApiRequestException;
import com.softwareComedians.ClinicalCenterApp.model.ConsultType;
import com.softwareComedians.ClinicalCenterApp.repository.ConsultTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ConsultTypeService {
    @Autowired
    ConsultTypeRepository consultTypeRepository;

    public ConsultType findOne(Long id){
        try {
            return consultTypeRepository.findById(id).get();
        } catch (NoSuchElementException e) {
            throw new ApiRequestException("Consult type with id '" + id + "' doesn't exist.");
        }
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

    public ConsultType editConsultType (ConsultTypeDTO consultTypeDTO) {
        ConsultType ct = this.findOne(consultTypeDTO.getId());
        ct.setName(consultTypeDTO.getName());
        ct.setDescription(consultTypeDTO.getDescription());
        ct = this.save(ct);
        return ct;
    }

}
