package com.softwareComedians.ClinicalCenterApp.service;

import com.softwareComedians.ClinicalCenterApp.model.RequestForConsult;
import com.softwareComedians.ClinicalCenterApp.repository.RequestForConsultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RequestForConsultService {
    @Autowired
    private RequestForConsultRepository requestForConsultRepository;

    public RequestForConsult save(RequestForConsult requestForConsult) {
        return requestForConsultRepository.save(requestForConsult);
    }

    public void remove(Long id){
        requestForConsultRepository.deleteById(id);
    }

    public RequestForConsult findOne(Long id){
        return requestForConsultRepository.findById(id).orElseGet(null);
    }
}
