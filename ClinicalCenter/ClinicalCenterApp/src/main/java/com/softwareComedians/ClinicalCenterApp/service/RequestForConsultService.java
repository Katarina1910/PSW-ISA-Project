package com.softwareComedians.ClinicalCenterApp.service;

import com.softwareComedians.ClinicalCenterApp.model.ConsultTerm;
import com.softwareComedians.ClinicalCenterApp.model.RequestForConsult;
import com.softwareComedians.ClinicalCenterApp.repository.RequestForConsultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public RequestForConsult findById(Long id) {
        return requestForConsultRepository.findById(id).orElse(null);
    }
}
