package com.softwareComedians.ClinicalCenterApp.service;

import com.softwareComedians.ClinicalCenterApp.model.RequstForOperation;
import com.softwareComedians.ClinicalCenterApp.repository.RqForOperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RqForOperationService {
    @Autowired
    private RqForOperationRepository rqForOperationRepository;

    public RequstForOperation save(RequstForOperation requestForOperation) {
        return rqForOperationRepository.save(requestForOperation);
    }

    public void remove(Long id){
        rqForOperationRepository.deleteById(id);
    }

    public RequstForOperation findOne(Long id){
        return rqForOperationRepository.findById(id).orElseGet(null);
    }
}

