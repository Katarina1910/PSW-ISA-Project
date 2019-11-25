package com.softwareComedians.ClinicalCenterApp.service;

import com.softwareComedians.ClinicalCenterApp.model.ConsultTerm;
import com.softwareComedians.ClinicalCenterApp.model.RequestForPatientRegistration;
import com.softwareComedians.ClinicalCenterApp.repository.ConsultTermRepository;
import com.softwareComedians.ClinicalCenterApp.repository.RequestForPatientRegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestForPatientRegistrationService {

    @Autowired
    private RequestForPatientRegistrationRepository requestForPatientRegistrationRepository;

    public RequestForPatientRegistration save(RequestForPatientRegistration rq) {
        return requestForPatientRegistrationRepository.save(rq);
    }

    public List<RequestForPatientRegistration> getAll(){
        return  requestForPatientRegistrationRepository.findAll();
    }

    public void remove(Long id){
        requestForPatientRegistrationRepository.deleteById(id);
    }

    public RequestForPatientRegistration findOne(Long id){
        return requestForPatientRegistrationRepository.findById(id).orElseGet(null);
    }
}
